package gw2.api.v2.items;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum Flag {
	ACCOUNT_BIND_ON_USE("AccountBindOnUse"),
	ACCOUNT_BOUND("AccountBound"),
	HIDE_SUFFIX("HideSuffix"),
	MONSTER_ONLY("MonsterOnly"),
	NO_MYSTIC_FORGE("NoMysticForge"),
	NO_SALVAGE("NoSalvage"),
	NO_SELL("NoSell"),
	NOT_UPGRADEABLE("NotUpgradeable"),
	NO_UNDERWATER("NoUnderwater"),
	SOULBIND_ON_ACQUIRE("SoulbindOnAcquire"),
	SOULBIND_ON_USE("SoulBindOnUse"),
	UNIQUE("Unique");
	public final String value;
	private static final Map<String, Flag> _VALUES;
	static {
		final Builder<String, Flag> builder = ImmutableMap.<String, Flag>builder();
		for (Flag v : Flag.values()) {
			builder.put(v.value, v);
		}
		_VALUES = builder.build();
	}

	private Flag(final String value) {
		this.value = value;
	}

	public static Flag from(String value) {
		return _VALUES.get(value);
	}

	public String getValue() {
		return value;
	}
	
}
