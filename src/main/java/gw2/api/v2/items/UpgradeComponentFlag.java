package gw2.api.v2.items;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum UpgradeComponentFlag {
	AXE("Axe"),
	DAGGER("Dagger"),
	FOCUS("Focus"),
	GREATSWORD("Greatsword"),
	HAMMER("Hammer"),
	HARPOON("Harpoon"),
	LONG_BOW("LongBow"),
	MACE("Mace"),
	PISTOL("Pistol"),
	RIFLE("Rifle"),
	SCEPTER("Scepter"),
	SHIELD("Shield"),
	SHORT_BOW("ShortBow"),
	SPEARGUN("Speargun"),
	STAFF("Staff"),
	SWORD("Sword"),
	TORCH("Torch"),
	TRIDENT("Trident"),
	WARHORN("Warhorn"),
	HEAVY_ARMOR("HeavyArmor"),
	MEDIUM_ARMOR("MediumArmor"),
	LIGHT_ARMOR("LightArmor"),
	TRINKET("Trinket");
	public final String value;
	private static final Map<String, UpgradeComponentFlag> _VALUES;
	static {
		final Builder<String, UpgradeComponentFlag> builder = ImmutableMap
				.<String, UpgradeComponentFlag>builder();
		for (UpgradeComponentFlag v : UpgradeComponentFlag.values()) {
			builder.put(v.value, v);
		}
		_VALUES = builder.build();
	}

	private UpgradeComponentFlag(final String value) {
		this.value = value;
	}

	public static UpgradeComponentFlag from(String value) {
		return _VALUES.get(value);
	}

	public String getValue() {
		return value;
	}
	
}
