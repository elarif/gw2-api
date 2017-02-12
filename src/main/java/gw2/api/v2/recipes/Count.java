package gw2.api.v2.recipes;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class Count {
	private static Cache<Integer, Count> CACHE = CacheBuilder.newBuilder().weakKeys().expireAfterAccess(10, TimeUnit.MINUTES).build();

	public final Integer value;

	private Count(final Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public static Count valueOf(final Integer value) {
		Count result = null;
		try {
			result = CACHE.get(value, new Callable<Count>() {
				public Count call() {
					return new Count(value);
				}
			});
		} catch (ExecutionException e) {
			throw new IllegalStateException(e);
		}
		return result;
	}
	
}
