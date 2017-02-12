package gw2.api.v2.items;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class RecipeId {
	private static Cache<Integer, RecipeId> CACHE = CacheBuilder.newBuilder().weakKeys().build();

	public final Integer value;

	private RecipeId(final Integer value) {
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public static RecipeId valueOf(final Integer value) {
		RecipeId result = null;
		try {
			result = CACHE.get(value, new Callable<RecipeId>() {
				public RecipeId call() {
					return new RecipeId(value);
				}
			});
		} catch (ExecutionException e) {
			throw new IllegalStateException(e);
		}
		return result;
	}
	
}
