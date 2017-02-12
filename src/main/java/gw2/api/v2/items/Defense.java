package gw2.api.v2.items;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class Defense {
	private static Cache<Integer, Defense> CACHE = CacheBuilder.newBuilder().weakKeys().build();

	public final Integer value;

	private Defense(final Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public static Defense valueOf(final Integer value) {
		Defense result = null;
		try {
			result = CACHE.get(value, new Callable<Defense>() {
				public Defense call() {
					return new Defense(value);
				}
			});
		} catch (ExecutionException e) {
			throw new IllegalStateException(e);
		}
		return result;
	}
}
