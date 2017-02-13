package gw2.api.v2.items;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum Attribute {
	AGONY_RESISTANCE("AgonyResistance"),
	BOON_DURATION("BoonDuration"), 
	CONDITION_DAMAGE("ConditionDamage"), 
	CONDITION_DURATION("ConditionDuration"),
	CRIT_DAMAGE("CritDamage"),
	HEALING("Healing"),
	POWER("Power"),
	PRECISION("Precision"),
	TOUGHNESS("Toughness"),
	VITALITY("Vitality");
	public final String value;
	private static final Map<String, Attribute> _VALUES;
	static {
		final Builder<String, Attribute> builder = ImmutableMap.<String, Attribute>builder();
		for (Attribute v : Attribute.values()) {
			builder.put(v.value, v);
		}
		_VALUES = builder.build();
	}

	private Attribute(final String value) {
		this.value = value;
	}

	public static Attribute from(String value) {
		return _VALUES.get(value);
	}

	public String getValue() {
		return value;
	}
	
}
