package gw2.api.v2.items;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum UpgradeComponentType {
	DEFAULT("Default"),
	GEM("Gem"),
	RUNE("Rune"),
	SIGIL("Sigil");
	public final String value;
	private static final Map<String, UpgradeComponentType> _VALUES;
	static {
		final Builder<String, UpgradeComponentType> builder = ImmutableMap
				.<String, UpgradeComponentType>builder();
		for (UpgradeComponentType v : UpgradeComponentType.values()) {
			builder.put(v.value, v);
		}
		_VALUES = builder.build();
	}

	private UpgradeComponentType(final String value) {
		this.value = value;
	}

	public static UpgradeComponentType from(String value) {
		return _VALUES.get(value);
	}

	public String getValue() {
		return value;
	}
	
}
