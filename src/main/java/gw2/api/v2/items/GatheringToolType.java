package gw2.api.v2.items;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum GatheringToolType {
FORAGING("Foraging"),
LOGGING("Logging"),
MINING("Mining");
public final String value;
private static final Map<String, GatheringToolType> _VALUES;
static {
	final Builder<String, GatheringToolType> builder = ImmutableMap.<String, GatheringToolType>builder();
	for (GatheringToolType v : GatheringToolType.values()) {
		builder.put(v.value, v);
	}
	_VALUES = builder.build();
}

private GatheringToolType(final String value) {
	this.value = value;
}

public static GatheringToolType from(String value) {
	return _VALUES.get(value);
}

public String getValue() {
	return value;
}

}
