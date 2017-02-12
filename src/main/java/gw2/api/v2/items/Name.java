package gw2.api.v2.items;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class Name {
	private static Cache<String, Name> CACHE = CacheBuilder.newBuilder().weakKeys().build();

	public final String value;

	private Name(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Name valueOf(final String value) {
		Name result = null;
		try {
			result = CACHE.get(value, new Callable<Name>() {
				public Name call() {
					return new Name(value);
				}
			});
		} catch (ExecutionException e) {
			throw new IllegalStateException(e);
		}
		return result;
	}
	
}
