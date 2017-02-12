package gw2.api.v2.items;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum UnlockType {
BAG_SLOT("BagSlot"), 
BANK_TAB("BankTab"), 
COLLECTIBLE_CAPACITY("CollectibleCapacity"), 
CONTENT("Content"), 
CRAFTING_RECIPE("CraftingRecipe"), 
DYE("Dye"), 
OUTFIT("Outfit"),
GLIDER_SKIN("GliderSkin"),
CHAMPION("Champion");
public final String value;
private static final Map<String, UnlockType> _VALUES;
static {
	final Builder<String, UnlockType> builder = ImmutableMap.<String, UnlockType>builder();
	for (UnlockType v : UnlockType.values()) {
		builder.put(v.value, v);
	}
	_VALUES = builder.build();
}

private UnlockType(final String value) {
	this.value = value;
}

public static UnlockType from(String value) {
	return _VALUES.get(value);
}

public String getValue() {
	return value;
}
	
}
