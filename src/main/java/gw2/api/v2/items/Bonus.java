package gw2.api.v2.items;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class Bonus {
	private static Cache<String, Bonus> CACHE = CacheBuilder.newBuilder().weakKeys().build();

	public final String value;

	private Bonus(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Bonus valueOf(final String value) {
		Bonus result = null;
		try {
			result = CACHE.get(value, new Callable<Bonus>() {
				public Bonus call() {
					return new Bonus(value);
				}
			});
		} catch (ExecutionException e) {
			throw new IllegalStateException(e);
		}
		return result;
	}
	
}
