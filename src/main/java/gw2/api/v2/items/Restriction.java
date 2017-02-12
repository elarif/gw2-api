package gw2.api.v2.items;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum Restriction {
	ASURA("Asura"),
	CHARR("Charr"),
	HUMAN("Human"),
	NORN("Norn"),
	SYLVARI("Sylvari"),
	ELEMENTALIST("Elementalist"),
	ENGINEER("Engineer"),
	GUARDIAN("Guardian"),
	MESMER("Mesmer"),
	NECROMANCER("Necromancer"),
	RANGER("Ranger"),
	THIEF("Thief"),
	WARRIOR("Warrior");
	public final String value;
	private static final Map<String, Restriction> _VALUES;
	static {
		final Builder<String, Restriction> builder = ImmutableMap.<String, Restriction>builder();
		for (Restriction v : Restriction.values()) {
			builder.put(v.value, v);
		}
		_VALUES = builder.build();
	}

	private Restriction(final String value) {
		this.value = value;
	}

	public static Restriction from(String value) {
		return _VALUES.get(value);
	}

	public String getValue() {
		return value;
	}
	
}
