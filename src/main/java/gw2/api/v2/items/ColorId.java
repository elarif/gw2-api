package gw2.api.v2.items;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class ColorId {
	private static Cache<Integer, ColorId> CACHE = CacheBuilder.newBuilder().weakKeys().build();

	public final Integer value;

	private ColorId(final Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public static ColorId valueOf(final Integer value) {
		ColorId result = null;
		try {
			result = CACHE.get(value, new Callable<ColorId>() {
				public ColorId call() {
					return new ColorId(value);
				}
			});
		} catch (ExecutionException e) {
			throw new IllegalStateException(e);
		}
		return result;
	}
}
