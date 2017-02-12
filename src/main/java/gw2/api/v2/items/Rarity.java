package gw2.api.v2.items;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum Rarity {
	JUNK("Junk"), 
	BASIC("Basic"),
	FINE("Fine"),
	MASTERWORK("Masterwork"),
	RARE("Rare"),
	EXOTIC("Exotic"),
	ASCENDED("Ascended"),
	LEGENDARY("Legendary");
	public final String value;
	private static final Map<String, Rarity> _VALUES;
	static {
		final Builder<String, Rarity> builder = ImmutableMap.<String, Rarity>builder();
		for (Rarity v : Rarity.values()) {
			builder.put(v.value, v);
		}
		_VALUES = builder.build();
	}

	private Rarity(final String value) {
		this.value = value;
	}

	public static Rarity from(String value) {
		return _VALUES.get(value);
	}

	public String getValue() {
		return value;
	}
	
}
