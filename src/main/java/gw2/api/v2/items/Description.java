package gw2.api.v2.items;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class Description {
	private static Cache<String, Description> CACHE = CacheBuilder.newBuilder().weakKeys().build();

	public final String value;

	private Description(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Description valueOf(final String value) {
		Description result = null;
		try {
			result = CACHE.get(value, new Callable<Description>() {
				public Description call() {
					return new Description(value);
				}
			});
		} catch (ExecutionException e) {
			throw new IllegalStateException(e);
		}
		return result;
	}
	
}
