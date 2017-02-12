package gw2.api.v2.items;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum WeightClass {
	HEAVY("Heavy"),
	MEDIUM("Medium"),
	LIGHT("Light"), 
	CLOTHING("Clothing");
	public final String value;
	private static final Map<String, WeightClass> _VALUES;
	static {
		final Builder<String, WeightClass> builder = ImmutableMap.<String, WeightClass>builder();
		for (WeightClass v : WeightClass.values()) {
			builder.put(v.value, v);
		}
		_VALUES = builder.build();
	}

	private WeightClass(final String value) {
		this.value = value;
	}

	public static WeightClass from(String value) {
		return _VALUES.get(value);
	}

	public String getValue() {
		return value;
	}
	
}
