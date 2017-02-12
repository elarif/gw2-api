package gw2.api.v2.items;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class Id  {
	private static Cache<Integer, Id> CACHE = CacheBuilder.newBuilder().weakKeys().build();

	public final Integer value;

	private Id(final Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public static Id valueOf(final Integer value) {
		Id result = null;
		try {
			result = CACHE.get(value, new Callable<Id>() {
				public Id call() {
					return new Id(value);
				}
			});
		} catch (ExecutionException e) {
			throw new IllegalStateException(e);
		}
		return result;
	}
	
}
