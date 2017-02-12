package gw2.api.v2.items;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class StatChoice {
	private static Cache<Integer, StatChoice> CACHE = CacheBuilder.newBuilder().weakKeys().build();

	public final Integer value;

	private StatChoice(final Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public static StatChoice valueOf(final Integer value) {
		StatChoice result = null;
		try {
			result = CACHE.get(value, new Callable<StatChoice>() {
				public StatChoice call() {
					return new StatChoice(value);
				}
			});
		} catch (ExecutionException e) {
			throw new IllegalStateException(e);
		}
		return result;
	}
	
}
