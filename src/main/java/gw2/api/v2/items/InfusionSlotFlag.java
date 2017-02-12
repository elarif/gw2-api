package gw2.api.v2.items;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum InfusionSlotFlag {
	ENRICHMENT("Enrichment"), INFUSION("Infusion");
	public final String value;
	private static final Map<String, InfusionSlotFlag> _VALUES;
	static {
		final Builder<String, InfusionSlotFlag> builder = ImmutableMap.<String, InfusionSlotFlag>builder();
		for (InfusionSlotFlag v : InfusionSlotFlag.values()) {
			builder.put(v.value, v);
		}
		_VALUES = builder.build();
	}

	private InfusionSlotFlag(final String value) {
		this.value = value;
	}

	public static InfusionSlotFlag from(String value) {
		return _VALUES.get(value);
	}

	public String getValue() {
		return value;
	}
	
}
