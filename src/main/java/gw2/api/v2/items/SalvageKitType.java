package gw2.api.v2.items;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum SalvageKitType {
	SALVAGE("Salvage");
	public final String value;
	private static final Map<String, SalvageKitType> _VALUES;
	static {
		final Builder<String, SalvageKitType> builder = ImmutableMap.<String, SalvageKitType>builder();
		for (SalvageKitType v : SalvageKitType.values()) {
			builder.put(v.value, v);
		}
		_VALUES = builder.build();
	}

	private SalvageKitType(final String value) {
		this.value = value;
	}

	public static SalvageKitType from(String value) {
		return _VALUES.get(value);
	}

	public String getValue() {
		return value;
	}
	
}
