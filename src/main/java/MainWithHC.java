import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Base64;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;

import gw2.api.v2.items.Item;
import gw2.api.v2.recipes.Recipe;

public class MainWithHC {
	private static final String V2_ITEMS = "https://api.guildwars2.com/v2/items";
	public final static ObjectMapper mapper = new ObjectMapper().registerModule(new GuavaModule());
	public final static int CHUNK_SIZE = 200;
	public final static Driver driver = GraphDatabase.driver("bolt://localhost:7687",
			AuthTokens.basic("neo4j", "bA6TASLw1qVqOhHrb0EA"));
	private static final String ITEM_CYPHER = "UNWIND $data AS items FOREACH(item in items | MERGE (i:Item { id: item.id}) "
			+ " ON CREATE SET i.chat_link=item.chat_link, i.name=item.name, i.icon=item.icon, i.description=item.description, i.level=    item.level, i.vendor_value=item.vendor_value, i.default_skin=item.default_skin "
			+ " MERGE (t:ItemType { name: item.type }) " + " MERGE (i)-[:TYPE]->(t) "
			+ " MERGE (r:ItemRarity {name: item.rarity}) " + " MERGE (i)-[:RARITY]->(r) "
			+ " FOREACH (flag in item.flags | MERGE (f:ItemFlag {name:flag}) MERGE (i)-[:HAS_FLAG]->(f))"
			+ " FOREACH (game_type in item.game_types | MERGE (g:ItemGameType {name:game_type}) MERGE (i)-[:USABLE_IN]->(g))"
			+ " FOREACH (restriction in item.restrictions| MERGE (rs:ItemRestriction {name:restriction}) MERGE (i)-[:RESTRICTED_TO]->(rs)))";
	private static final String V2_RECIPES = "https://api.guildwars2.com/v2/recipes";
	private static final String RECIPE_CYPHER = "UNWIND $data AS recipes FOREACH(recipe in recipes | MERGE (r:Recipe{ id: recipe.id}) "
			+ "ON CREATE SET r.chat_link=r.chat_link, r.min_rating=r.min_rating"
			+ " MERGE (t:RecipeType { name: recipe.type }) " + " MERGE (r)-[:TYPE]->(t) "
			+ " MERGE (i:Item {id: recipe.output_item_id}) "
			+ " MERGE (r)-[:PRODUCES {count: recipe.output_item_count, duration: recipe.time_to_craft_ms }]->(i) "
			+ " FOREACH (discipline in recipe.disciplines | MERGE (d:Discipline {name:discipline}) MERGE (r)-[:USED_BY]->(d))"
			+ " FOREACH (flag in recipe.flags | MERGE (f:Flag {name:flag}) MERGE (r)-[:HAS_FLAG]->(f))"
			+ " FOREACH (ingredient in recipe.ingredients| MERGE (i:Item {id:ingredient.item_id}) MERGE (r)-[:REQUIRES {count: ingredient.count}]->(i))"
			+ ")";

		public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
		final int numberOfCores = Runtime.getRuntime().availableProcessors();
		final double blockingCoefficient = 0.99;
		final int poolSize = (int) (numberOfCores / (1 - blockingCoefficient));

		System.out.println("Number of Cores available is " + numberOfCores);
		System.out.println("Pool size is " + poolSize);
		mapper.registerModule(new GuavaModule());

		final PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
		final CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
		final ExecutorService executorPool = Executors.newFixedThreadPool(poolSize);

		final long start = System.nanoTime();
		listAndDetails(httpClient, executorPool, V2_ITEMS, Item.class, ITEM_CYPHER);
		listAndDetails(httpClient, executorPool, V2_RECIPES, Recipe.class, RECIPE_CYPHER);
		final long end = System.nanoTime();
		System.out.println("Time (seconds) taken " + (end - start) / 1.0e9);
		executorPool.shutdown();
		driver.close();
	}

	private static <T extends Object> void listAndDetails(final CloseableHttpClient httpClient,
			final ExecutorService executorPool, final String uri, final Class<T> responseClass, final String cypher)
			throws InterruptedException, ExecutionException, IOException {
		final List<Integer> list = list(httpClient, uri);
		final int size = list.size();
		final ImmutableList.Builder<String> strings = ImmutableList.builder();
		for (int i = 0; i < 1+(size / CHUNK_SIZE); i++) {
			final List<Integer> subList = list.subList(i * CHUNK_SIZE, Math.min(size, (i + 1) * CHUNK_SIZE));
			strings.add(Joiner.on(",").join(subList));
		}
		final ImmutableList.Builder<Callable<String>> _partitions = ImmutableList.builder();
		for (String ids : strings.build()) {
			_partitions.add(new Callable<String>() {
				public String call() throws Exception {
					try {

						URL url = new URL(uri + "?ids=" + ids);
						HttpURLConnection conn = (HttpURLConnection) url.openConnection();
						conn.setRequestMethod("GET");
						conn.setRequestProperty("Accept", "application/json");

						if (conn.getResponseCode() != 200) {
							throw new RuntimeException("Failed : HTTP error code : "
									+ conn.getResponseCode());
						}
						BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
						ByteArrayOutputStream buf = new ByteArrayOutputStream();
						int result = bis.read();
						while(result != -1) {
						    buf.write((byte) result);
						    result = bis.read();
						}
						conn.disconnect();
						return buf.toString();

					  } catch (MalformedURLException e) {

						throw new IllegalStateException(e);

					  } catch (IOException e) {
						  throw new IllegalStateException(e);

					  }
				}
			});
		}
		CompletionService<String> ecs = new ExecutorCompletionService<String>(executorPool);
		final ImmutableList<Callable<String>> build = _partitions.build();
		for (Callable<String> s : build)
			ecs.submit(s);
		int n = build.size();
		for (int i = 0; i < n; ++i) {
			String r = ecs.take().get();
			if (r != null) {
				URL url = new URL("http://localhost:7474/db/data/transaction/commit");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Accept", "application/json; charset=UTF-8");
				conn.setRequestProperty("Content-Type", "application/json");
				conn.setRequestProperty("Authorization", "Basic "+Base64.getEncoder().encodeToString("neo4j:bA6TASLw1qVqOhHrb0EA".getBytes()));

				String input = MessageFormat.format("'{'\r\n" + 
						"  \"statements\" : [ '{'\r\n" + 
						"    \"statement\" : \"{0}\",\r\n" + 
						"    \"parameters\" : '{'\r\n" + 
						"      \"data\" : {1}\r\n" + 
						"      }\r\n" + 
						"  } ]\r\n" + 
						"}", cypher, r);
				OutputStream os = conn.getOutputStream();
				os.write(input.getBytes());
				os.flush();

				if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED && conn.getResponseCode() != HttpURLConnection.HTTP_OK  ) {
					throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
				}
				conn.disconnect();
			}
		}
	}

	private static List<Integer> list(CloseableHttpClient httpClient, String uri) {
		final HttpContext context = HttpClientContext.create();
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(new HttpGet(uri), context);
			final HttpEntity entity = response.getEntity();
			return mapper.readValue(entity.getContent(), new TypeReference<ImmutableList<Integer>>() {
			});

		} catch (ClientProtocolException e) {
			throw new IllegalStateException(e);
		} catch (IOException e) {
			throw new IllegalStateException(e);
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				throw new IllegalStateException(e);
			}
		}
	}
}
