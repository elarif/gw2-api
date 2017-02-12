package gw2.api.v2.recipes;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class MinRating {
	private static Cache<Integer, MinRating> CACHE = CacheBuilder.newBuilder().weakKeys().build();

	public final Integer value;

	private MinRating(final Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public static MinRating valueOf(final Integer value) {
		MinRating result = null;
		try {
			result = CACHE.get(value, new Callable<MinRating>() {
				public MinRating call() {
					return new MinRating(value);
				}
			});
		} catch (ExecutionException e) {
			throw new IllegalStateException(e);
		}
		return result;
	}
	
}
