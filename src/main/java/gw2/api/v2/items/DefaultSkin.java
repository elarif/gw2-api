package gw2.api.v2.items;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class DefaultSkin {
private static Cache<Integer, DefaultSkin> CACHE = CacheBuilder.newBuilder().weakKeys().build();

public final Integer value;

private DefaultSkin(final Integer value) {
	this.value = value;
}

public Integer getValue() {
	return value;
}

public static DefaultSkin valueOf(final Integer value) {
	DefaultSkin result = null;
	try {
		result = CACHE.get(value, new Callable<DefaultSkin>() {
			public DefaultSkin call() {
				return new DefaultSkin(value);
			}
		});
	} catch (ExecutionException e) {
		throw new IllegalStateException(e);
	}
	return result;
}
}
