package gw2.api.v2.items;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum TrinketType {
	ACCESSORY("Accessory"),
	AMULET("Amulet"),
	RING("Ring");
	public final String value;
	private static final Map<String, TrinketType> _VALUES;
	static {
		final Builder<String, TrinketType> builder = ImmutableMap.<String, TrinketType>builder();
		for (TrinketType v : TrinketType.values()) {
			builder.put(v.value, v);
		}
		_VALUES = builder.build();
	}

	private TrinketType(final String value) {
		this.value = value;
	}

	public static TrinketType from(String value) {
		return _VALUES.get(value);
	}

	public String getValue() {
		return value;
	}
	
}
