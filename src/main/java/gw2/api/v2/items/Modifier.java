package gw2.api.v2.items;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class Modifier {
private static Cache<Integer, Modifier> CACHE = CacheBuilder.newBuilder().weakKeys().build();

public final Integer value;

private Modifier(final Integer value) {
	this.value = value;
}

public Integer getValue() {
	return value;
}

public static Modifier valueOf(final Integer value) {
	Modifier result = null;
	try {
		result = CACHE.get(value, new Callable<Modifier>() {
			public Modifier call() {
				return new Modifier(value);
			}
		});
	} catch (ExecutionException e) {
		throw new IllegalStateException(e);
	}
	return result;
}

}
