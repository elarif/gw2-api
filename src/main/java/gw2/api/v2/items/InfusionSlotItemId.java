package gw2.api.v2.items;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class InfusionSlotItemId {
private static Cache<Integer, InfusionSlotItemId> CACHE = CacheBuilder.newBuilder().weakKeys().build();

public final Integer value;

private InfusionSlotItemId(final Integer value) {
	this.value = value;
}

public Integer getValue() {
	return value;
}

public static InfusionSlotItemId valueOf(final Integer value) {
	InfusionSlotItemId result = null;
	try {
		result = CACHE.get(value, new Callable<InfusionSlotItemId>() {
			public InfusionSlotItemId call() {
				return new InfusionSlotItemId(value);
			}
		});
	} catch (ExecutionException e) {
		throw new IllegalStateException(e);
	}
	return result;
}

}
