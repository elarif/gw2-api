package gw2.api.v2.items;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum ArmorSlotType {
	BOOTS("Boots"), 
	COAT("Coat"), 
	GLOVES("Gloves"), 
	HELM("Helm"), 
	HELM_AQUATIC("HelmAquatic"), 
	LEGGINGS("Leggings"), 
	SHOULDERS("Shoulders");
	public final String value;
	private static final Map<String, ArmorSlotType> _VALUES;
	static {
		final Builder<String, ArmorSlotType> builder = ImmutableMap.<String, ArmorSlotType>builder();
		for (ArmorSlotType v : ArmorSlotType.values()) {
			builder.put(v.value, v);
		}
		_VALUES = builder.build();
	}

	private ArmorSlotType(final String value) {
		this.value = value;
	}

	public static ArmorSlotType from(String value) {
		return _VALUES.get(value);
	}

	public String getValue() {
		return value;
	}
}
