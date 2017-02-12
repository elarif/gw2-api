package gw2.api.v2.items;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class Price {
	private static Cache<Integer, Price> CACHE = CacheBuilder.newBuilder().weakKeys().build();

	public final Integer value;

	private Price(final Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public static Price valueOf(final Integer value) {
		Price result = null;
		try {
			result = CACHE.get(value, new Callable<Price>() {
				public Price call() {
					return new Price(value);
				}
			});
		} catch (ExecutionException e) {
			throw new IllegalStateException(e);
		}
		return result;
	}
	
}
