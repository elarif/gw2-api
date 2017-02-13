

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.parallec.core.ParallecResponseHandler;
import io.parallec.core.ParallelClient;
import io.parallec.core.RequestProtocol;
import io.parallec.core.ResponseOnSingleTask;

public class Main {
	public final static ObjectMapper mapper = new ObjectMapper();
	public final static File _ITEMS, _RECIPES, _LISTINGS;
	static {
		try {
			Files.deleteIfExists(Paths.get("./items.json"));
			Files.deleteIfExists(Paths.get("./recipes.json"));
			Files.deleteIfExists(Paths.get("./listings.json"));
			_ITEMS = Files.createFile(Paths.get("./items.json")).toFile();
			_RECIPES = Files.createFile(Paths.get("./recipes.json")).toFile();
			_LISTINGS = Files.createFile(Paths.get("./listings.json")).toFile();

		} catch (IOException e) {
			e.printStackTrace();
			throw new IllegalStateException();
		}
	}

	public static void main(String[] args) {
		ParallelClient pc = new ParallelClient();
		listEndpointAndWriteDetailsToFile(pc, "/v2/items", _ITEMS );
		listEndpointAndWriteDetailsToFile(pc, "/v2/recipes", _RECIPES );
		listEndpointAndWriteDetailsToFile(pc, "/v2/commerce/listings", _LISTINGS);
		// pc.releaseExternalResources();
	}

	private static void listEndpointAndWriteDetailsToFile(ParallelClient pc, String endpoint, File f) {
		final List<Integer> items = list(pc, endpoint);
		writeDetailsToFile(pc, endpoint, f, items);
	}

	private static void writeDetailsToFile(ParallelClient pc, String endpoint, final File f, final List<Integer> items) {
		final List<String> strings = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < items.size(); i++) {
			sb.append(Integer.toString(items.get(i)));
			if (i % 100 == 0) {
				strings.add(sb.toString());
				sb = new StringBuilder();
			} else {
				sb.append(",");
			}
		}
		pc.prepareHttpGet(endpoint+"?ids=$ID").async().setConcurrency(5).setEnableCapacityAwareTaskScheduler(true)
				.setProtocol(RequestProtocol.HTTPS).setHttpPort(443)
				.setReplaceVarMapToSingleTargetSingleVar("ID", strings, "api.guildwars2.com")
				.execute(new ParallecResponseHandler() {
					@Override
					public void onCompleted(ResponseOnSingleTask res, Map<String, Object> responseContext) {
						appendToFile(f, res.getResponseContent());
					}
				});
	}

	private static void appendToFile(File f, String json) {
			try (FileOutputStream outputStream = new FileOutputStream(f, true); ){
				outputStream.write(json.getBytes());
			} catch ( IOException e) {
				e.printStackTrace();
			}
	}

	private static List<Integer> list(ParallelClient pc, String endpoint) {
		final List<Integer> result = new ArrayList<>();
		pc.prepareHttpGet(endpoint).setProtocol(RequestProtocol.HTTPS).setHttpPort(443)
				.setTargetHostsFromString("api.guildwars2.com").execute(new ParallecResponseHandler() {
					public void onCompleted(ResponseOnSingleTask res, Map<String, Object> responseContext) {
						try {
							final String responseContent = res.getResponseContent();
							final Collection<? extends Integer> readValue = mapper.readValue(responseContent, new TypeReference<List<Integer>>() {
							});
							result.addAll(readValue);
						} catch (JsonParseException e) {
							e.printStackTrace();
						} catch (JsonMappingException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				});
		return result;
	}
}
