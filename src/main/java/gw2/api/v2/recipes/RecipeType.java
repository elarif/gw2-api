package gw2.api.v2.recipes;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum RecipeType {
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
	BOOTS("Boots"),
	COAT("Coat"),
	GLOVES("Gloves"),
	HELM("Helm"),
	LEGGINGS("Leggings"),
	SHOULDERS("Shoulders"),
	AMULET("Amulet"),
	EARRING("Earring"),
	RING("Ring"),
	DESSERT("Dessert"),
	FEAST("Feast"),
	INGREDIENT_COOKING("IngredientCooking"),
	MEAL("Meal"),
	SEASONING("Seasoning"),
	SNACK("Snack"),
	SOUP("Soup"),
	FOOD("Food"),
	COMPONENT("Component"),
	INSCRIPTION("Inscription"),
	INSIGNIA("Insignia"),
	LEGENDARY_COMPONENT("LegendaryComponent"),
	REFINEMENT("Refinement"),
	REFINEMENT_ECTOPLASM("RefinementEctoplasm"),
	REFINEMENT_OBSIDIAN("RefinementObsidian"),
	GUILD_CONSUMABLE("GuildConsumable"),
	GUILD_DECORATION("GuildDecoration"),
	GUILD_CONSUMABLE_WVW("GuildConsumableWvw"),
	BACKPACK("Backpack"),
	BAG("Bag"),
	BULK("Bulk"),
	CONSUMABLE("Consumable"),
	DYE("Dye"),
	POTION("Potion"),
	UPGRADE_COMPONENT("UpgradeComponent");
	public final String value;
	private static final Map<String, RecipeType> _VALUES;
	static {
		final Builder<String, RecipeType> builder = ImmutableMap.<String, RecipeType>builder();
		for (RecipeType v : RecipeType.values()) {
			builder.put(v.value, v);
		}
		_VALUES = builder.build();
	}

	private RecipeType(final String value) {
		this.value = value;
	}

	public static RecipeType from(String value) {
		return _VALUES.get(value);
	}

	public String getValue() {
		return value;
	}
	

}
