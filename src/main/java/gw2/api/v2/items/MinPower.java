package gw2.api.v2.items;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class MinPower {
private static Cache<Integer, MinPower> CACHE = CacheBuilder.newBuilder().weakKeys().build();

public final Integer value;

private MinPower(final Integer value) {
	this.value = value;
}

public Integer getValue() {
	return value;
}

public static MinPower valueOf(final Integer value) {
	MinPower result = null;
	try {
		result = CACHE.get(value, new Callable<MinPower>() {
			public MinPower call() {
				return new MinPower(value);
			}
		});
	} catch (ExecutionException e) {
		throw new IllegalStateException(e);
	}
	return result;
}

}
