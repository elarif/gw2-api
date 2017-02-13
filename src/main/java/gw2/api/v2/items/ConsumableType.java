package gw2.api.v2.items;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum ConsumableType {
APPEARANCE_CHANGE("AppearanceChange"), 
BOOZE("Booze"), 
CONTRACT_NPC("ContractNpc"), 
FOOD("Food"), 
GENERIC("Generic"), 
HALLOWEEN("Halloween"), 
IMMEDIATE("Immediate"), 
TRANSMUTATION("Transmutation"), 
UNLOCK("Unlock"), 
UPGRADE_REMOVAL("UpgradeRemoval"), 
UTILITY("Utility"), 
TELEPORT_TO_FRIEND("TeleportToFriend"),
RANDOM_UNLOCK("RandomUnlock");
	public final String value;
	private static final Map<String, ConsumableType> _VALUES;
	static {
		final Builder<String, ConsumableType> builder = ImmutableMap.<String, ConsumableType>builder();
		for (ConsumableType v : ConsumableType.values()) {
			builder.put(v.value, v);
		}
		_VALUES = builder.build();
	}

	private ConsumableType(final String value) {
		this.value = value;
	}

	public static ConsumableType from(String value) {
		return _VALUES.get(value);
	}

	public String getValue() {
		return value;
	}
	
}
