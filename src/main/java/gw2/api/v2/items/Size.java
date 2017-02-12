package gw2.api.v2.items;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class Size {
	private static Cache<Integer, Size> CACHE = CacheBuilder.newBuilder().weakKeys().build();

	public final Integer value;

	private Size(final Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public static Size valueOf(final Integer value) {
		Size result = null;
		try {
			result = CACHE.get(value, new Callable<Size>() {
				public Size call() {
					return new Size(value);
				}
			});
		} catch (ExecutionException e) {
			throw new IllegalStateException(e);
		}
		return result;
	}
	
}
