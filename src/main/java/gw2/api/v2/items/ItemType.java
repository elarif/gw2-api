package gw2.api.v2.items;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum ItemType {
	ARMOR("Armor"),
	BACK("Back"),
	BAG("Bag"),
	CONSUMABLE("Consumable"),
	CONTAINER("Container"),
	CRAFTING_MATERIAL("CraftingMaterial"),
	GATHERING("Gathering"),
	GIZMO("Gizmo"),
	MINI_PET("MiniPet"),
	TOOL("Tool"),
	TRAIT("Trait"),
	TRINKET("Trinket"),
	TROPHY("Trophy"),
	UPGRADE_COMPONENT("UpgradeComponent"),
	WEAPON("Weapon");
	public final String value;
	private static final Map<String, ItemType> _VALUES;
	static {
		final Builder<String, ItemType> builder = ImmutableMap.<String, ItemType>builder();
		for (ItemType v : ItemType.values()) {
			builder.put(v.value, v);
		}
		_VALUES = builder.build();
	}

	private ItemType(final String value) {
		this.value = value;
	}

	public static ItemType from(String value) {
		return _VALUES.get(value);
	}

	public String getValue() {
		return value;
	}
	
}
