package gw2.api.v2.recipes;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum RecipeFlag {
	AUTO_LEARNED("AutoLearned"),
	LEARNED_FROM_ITEM("LearnedFromItem");
	public final String value;
	private static final Map<String, RecipeFlag> _VALUES;
	static {
		final Builder<String, RecipeFlag> builder = ImmutableMap.<String, RecipeFlag>builder();
		for (RecipeFlag v : RecipeFlag.values()) {
			builder.put(v.value, v);
		}
		_VALUES = builder.build();
	}

	private RecipeFlag(final String value) {
		this.value = value;
	}

	public static RecipeFlag from(String value) {
		return _VALUES.get(value);
	}

	public String getValue() {
		return value;
	}
	
}
