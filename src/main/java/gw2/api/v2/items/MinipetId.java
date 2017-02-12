package gw2.api.v2.items;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class MinipetId {
	private static Cache<Integer, MinipetId> CACHE = CacheBuilder.newBuilder().weakKeys().build();

	public final Integer value;

	private MinipetId(final Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public static MinipetId valueOf(final Integer value) {
		MinipetId result = null;
		try {
			result = CACHE.get(value, new Callable<MinipetId>() {
				public MinipetId call() {
					return new MinipetId(value);
				}
			});
		} catch (ExecutionException e) {
			throw new IllegalStateException(e);
		}
		return result;
	}
	
}
