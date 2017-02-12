package gw2.api.v2.items;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum GizmoType {
DEFAULT("Default"),
CONTAINER_KEY("ContainerKey"), 
RENTABLE_CONTRACT_NPC("RentableContractNpc"), 
UNLIMITED_CONSUMABLE("UnlimitedConsumable");
public final String value;
private static final Map<String, GizmoType> _VALUES;
static {
	final Builder<String, GizmoType> builder = ImmutableMap.<String, GizmoType>builder();
	for (GizmoType v : GizmoType.values()) {
		builder.put(v.value, v);
	}
	_VALUES = builder.build();
}

private GizmoType(final String value) {
	this.value = value;
}

public static GizmoType from(String value) {
	return _VALUES.get(value);
}

public String getValue() {
	return value;
}

}
