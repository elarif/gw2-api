package gw2.api.v2.items;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum WeaponType {
	AXE("Axe"),
	DAGGER("Dagger"),
	MACE("Mace"),
	PISTOL("Pistol"),
	SCEPTER("Scepter"),
	SWORD("Sword"),
	FOCUS("Focus"),
	SHIELD("Shield"),
	TORCH("Torch"),
	WARHORN("Warhorn"),
	GREATSWORD("Greatsword"),
	HAMMER("Hammer"),
	LONG_BOW("LongBow"),
	RIFLE("Rifle"),
	SHORT_BOW("ShortBow"),
	STAFF("Staff"),
	HARPOON("Harpoon"),
	SPEARGUN("Speargun"),
	TRIDENT("Trident"),
	LARGE_BUNDLE("LargeBundle"),
	SMALL_BUNDLE("SmallBundle"),
	TOY("Toy"),
	TWO_HANDED_TOY("TwoHandedToy");
	public final String value;
	private static final Map<String, WeaponType> _VALUES;
	static {
		final Builder<String, WeaponType> builder = ImmutableMap.<String, WeaponType>builder();
		for (WeaponType v : WeaponType.values()) {
			builder.put(v.value, v);
		}
		_VALUES = builder.build();
	}

	private WeaponType(final String value) {
		this.value = value;
	}

	public static WeaponType from(String value) {
		return _VALUES.get(value);
	}

	public String getValue() {
		return value;
	}
	

}
