package gw2.api.v2.items;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class DurationMs {
	private static Cache<Integer, DurationMs> CACHE = CacheBuilder.newBuilder().weakKeys().build();

	public final Integer value;

	private DurationMs(final Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public static DurationMs valueOf(final Integer value) {
		DurationMs result = null;
		try {
			result = CACHE.get(value, new Callable<DurationMs>() {
				public DurationMs call() {
					return new DurationMs(value);
				}
			});
		} catch (ExecutionException e) {
			throw new IllegalStateException(e);
		}
		return result;
	}
	
	
}
