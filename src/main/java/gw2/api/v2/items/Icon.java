package gw2.api.v2.items;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class Icon {
	private static Cache<String, Icon> CACHE = CacheBuilder.newBuilder().weakKeys().build();

	public final String value;

	private Icon(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Icon valueOf(final String value) {
		Icon result = null;
		try {
			result = CACHE.get(value, new Callable<Icon>() {
				public Icon call() {
					return new Icon(value);
				}
			});
		} catch (ExecutionException e) {
			throw new IllegalStateException(e);
		}
		return result;
	}
}
