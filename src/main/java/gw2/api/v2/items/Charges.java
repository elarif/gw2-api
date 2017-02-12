package gw2.api.v2.items;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class Charges {
private static Cache<Integer, Charges> CACHE = CacheBuilder.newBuilder().weakKeys().build();

public final Integer value;

private Charges(final Integer value) {
	this.value = value;
}

public Integer getValue() {
	return value;
}

public static Charges valueOf(final Integer value) {
	Charges result = null;
	try {
		result = CACHE.get(value, new Callable<Charges>() {
			public Charges call() {
				return new Charges(value);
			}
		});
	} catch (ExecutionException e) {
		throw new IllegalStateException(e);
	}
	return result;
}

}
