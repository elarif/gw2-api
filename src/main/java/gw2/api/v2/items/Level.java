package gw2.api.v2.items;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class Level {
private static Cache<Integer, Level> CACHE = CacheBuilder.newBuilder().weakKeys().build();

public final Integer value;

private Level(final Integer value) {
	this.value = value;
}

public Integer getValue() {
	return value;
}

public static Level valueOf(final Integer value) {
	Level result = null;
	try {
		result = CACHE.get(value, new Callable<Level>() {
			public Level call() {
				return new Level(value);
			}
		});
	} catch (ExecutionException e) {
		throw new IllegalStateException(e);
	}
	return result;
}

}
