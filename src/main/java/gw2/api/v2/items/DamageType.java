package gw2.api.v2.items;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum DamageType {
	FIRE("Fire"),
	ICE("Ice"),
	LIGHTNING("Lightning"),
	PHYSICAL("Physical"),
	CHOKING("Choking");
	public final String value;
	private static final Map<String, DamageType> _VALUES;
	static {
		final Builder<String, DamageType> builder = ImmutableMap.<String, DamageType>builder();
		for (DamageType v : DamageType.values()) {
			builder.put(v.value, v);
		}
		_VALUES = builder.build();
	}

	private DamageType(final String value) {
		this.value = value;
	}

	public static DamageType from(String value) {
		return _VALUES.get(value);
	}

	public String getValue() {
		return value;
	}
	
}
