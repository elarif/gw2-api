package gw2.api.v2.items;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class MaxPower {
private static Cache<Integer, MaxPower> CACHE = CacheBuilder.newBuilder().weakKeys().build();

public final Integer value;

private MaxPower(final Integer value) {
	this.value = value;
}

public Integer getValue() {
	return value;
}

public static MaxPower valueOf(final Integer value) {
	MaxPower result = null;
	try {
		result = CACHE.get(value, new Callable<MaxPower>() {
			public MaxPower call() {
				return new MaxPower(value);
			}
		});
	} catch (ExecutionException e) {
		throw new IllegalStateException(e);
	}
	return result;
}

}
