package gw2.api.v2.items;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class SkillId {
	private static Cache<String, SkillId> CACHE = CacheBuilder.newBuilder().weakKeys().build();

	public final String value;

	private SkillId(final String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static SkillId valueOf(final String value) {
		SkillId result = null;
		try {
			result = CACHE.get(value, new Callable<SkillId>() {
				public SkillId call() {
					return new SkillId(value);
				}
			});
		} catch (ExecutionException e) {
			throw new IllegalStateException(e);
		}
		return result;
	}
	
	
}
