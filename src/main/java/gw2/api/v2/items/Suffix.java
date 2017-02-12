package gw2.api.v2.items;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class Suffix {
	private static Cache<String, Suffix> CACHE = CacheBuilder.newBuilder().weakKeys().build();

	public final String value;

	private Suffix(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Suffix valueOf(final String value) {
		Suffix result = null;
		try {
			result = CACHE.get(value, new Callable<Suffix>() {
				public Suffix call() {
					return new Suffix(value);
				}
			});
		} catch (ExecutionException e) {
			throw new IllegalStateException(e);
		}
		return result;
	}
	
}
