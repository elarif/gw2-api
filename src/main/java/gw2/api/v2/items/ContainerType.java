package gw2.api.v2.items;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum ContainerType {
DEFAULT("Default"),
GIFT_BOX("GiftBox"),
OPEN_UI("OpenUI");
public final String value;
private static final Map<String, ContainerType> _VALUES;
static {
	final Builder<String, ContainerType> builder = ImmutableMap.<String, ContainerType>builder();
	for (ContainerType v : ContainerType.values()) {
		builder.put(v.value, v);
	}
	_VALUES = builder.build();
}

private ContainerType(final String value) {
	this.value = value;
}

public static ContainerType from(String value) {
	return _VALUES.get(value);
}

public String getValue() {
	return value;
}

	
}
