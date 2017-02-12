package gw2.api.v2.items;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class NoSellOrSort {
	private static Cache<Boolean, NoSellOrSort> CACHE = CacheBuilder.newBuilder().weakKeys().build();

	public final Boolean value;

	private NoSellOrSort(final Boolean value) {
		this.value = value;
	}

	public Boolean getValue() {
		return value;
	}

	public static NoSellOrSort valueOf(final Boolean value) {
		NoSellOrSort result = null;
		try {
			result = CACHE.get(value, new Callable<NoSellOrSort>() {
				public NoSellOrSort call() {
					return new NoSellOrSort(value);
				}
			});
		} catch (ExecutionException e) {
			throw new IllegalStateException(e);
		}
		return result;
	}
	
}
