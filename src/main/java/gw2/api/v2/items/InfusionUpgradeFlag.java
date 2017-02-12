package gw2.api.v2.items;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum InfusionUpgradeFlag {
DEFENSE("Defense"),
OFFENSE("Offense"),
UTILITY("Utility"),
AGONY("Agony");
public final String value;
private static final Map<String, InfusionUpgradeFlag> _VALUES;
static {
	final Builder<String, InfusionUpgradeFlag> builder = ImmutableMap.<String, InfusionUpgradeFlag>builder();
	for (InfusionUpgradeFlag v : InfusionUpgradeFlag.values()) {
		builder.put(v.value, v);
	}
	_VALUES = builder.build();
}

private InfusionUpgradeFlag(final String value) {
	this.value = value;
}

public static InfusionUpgradeFlag from(String value) {
	return _VALUES.get(value);
}

public String getValue() {
	return value;
}

}
