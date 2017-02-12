package gw2.api.v2.items;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class ChatLink {
private static Cache<String, ChatLink> CACHE = CacheBuilder.newBuilder().weakKeys().build();

public final String value;

private ChatLink(final String value) {
	this.value = value;
}

public String getValue() {
	return value;
}

public static ChatLink valueOf(final String value) {
	ChatLink result = null;
	try {
		result = CACHE.get(value, new Callable<ChatLink>() {
			public ChatLink call() {
				return new ChatLink(value);
			}
		});
	} catch (ExecutionException e) {
		throw new IllegalStateException(e);
	}
	return result;
}

}
