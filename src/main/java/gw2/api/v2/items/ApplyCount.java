package gw2.api.v2.items;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class ApplyCount {
	private static Cache<Integer, ApplyCount> CACHE = CacheBuilder.newBuilder().weakKeys().build();

	public final Integer value;

	private ApplyCount(final Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public static ApplyCount valueOf(final Integer value) {
		ApplyCount result = null;
		try {
			result = CACHE.get(value, new Callable<ApplyCount>() {
				public ApplyCount call() {
					return new ApplyCount(value);
				}
			});
		} catch (ExecutionException e) {
			throw new IllegalStateException(e);
		}
		return result;
	}
	
}
