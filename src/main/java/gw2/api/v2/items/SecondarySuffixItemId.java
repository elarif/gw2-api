package gw2.api.v2.items;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class SecondarySuffixItemId {
private static Cache<String, SecondarySuffixItemId> CACHE = CacheBuilder.newBuilder().weakKeys().build();

public final String value;

private SecondarySuffixItemId(final String value) {
	this.value = value;
}

public String getValue() {
	return value;
}

public static SecondarySuffixItemId valueOf(final String value) {
	SecondarySuffixItemId result = null;
	try {
		result = CACHE.get(value, new Callable<SecondarySuffixItemId>() {
			public SecondarySuffixItemId call() {
				return new SecondarySuffixItemId(value);
			}
		});
	} catch (ExecutionException e) {
		throw new IllegalStateException(e);
	}
	return result;
}

}
