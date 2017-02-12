package gw2.api.v2.items;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class SuffixItemId {
private static Cache<Integer, SuffixItemId> CACHE = CacheBuilder.newBuilder().weakKeys().build();

public final Integer value;

private SuffixItemId(final Integer value) {
	this.value = value;
}

public Integer getValue() {
	return value;
}

public static SuffixItemId valueOf(final Integer value) {
	SuffixItemId result = null;
	try {
		result = CACHE.get(value, new Callable<SuffixItemId>() {
			public SuffixItemId call() {
				return new SuffixItemId(value);
			}
		});
	} catch (ExecutionException e) {
		throw new IllegalStateException(e);
	}
	return result;
}

}
