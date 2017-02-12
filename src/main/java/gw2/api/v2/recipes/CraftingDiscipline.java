package gw2.api.v2.recipes;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum CraftingDiscipline {
	ARTIFICER("Artificer"),
	ARMORSMITH("Armorsmith"),
	CHEF("Chef"),
	HUNTSMAN("Huntsman"),
	JEWELER("Jeweler"),
	LEATHERWORKER("Leatherworker"),
	TAILOR("Tailor"),
	WEAPONSMITH("Weaponsmith"),
	SCRIBE("Scribe");
	public final String value;
	private static final Map<String, CraftingDiscipline> _VALUES;
	static {
		final Builder<String, CraftingDiscipline> builder = ImmutableMap.<String, CraftingDiscipline>builder();
		for (CraftingDiscipline v : CraftingDiscipline.values()) {
			builder.put(v.value, v);
		}
		_VALUES = builder.build();
	}

	private CraftingDiscipline(final String value) {
		this.value = value;
	}

	public static CraftingDiscipline from(String value) {
		return _VALUES.get(value);
	}

	public String getValue() {
		return value;
	}
	

}
