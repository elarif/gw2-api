package gw2.api.v2.items;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;

public enum GameType {
ACTIVITY("Activity"),
DUNGEON("Dungeon"),
PVE("Pve"),
PVP("Pvp"),
PVP_LOBBY("PvpLobby"),
WVW("Wvw");
public final String value;
private static final Map<String, GameType> _VALUES;
static {
	final Builder<String, GameType> builder = ImmutableMap.<String, GameType>builder();
	for (GameType v : GameType.values()) {
		builder.put(v.value, v);
	}
	_VALUES = builder.build();
}

private GameType(final String value) {
	this.value = value;
}

public static GameType from(String value) {
	return _VALUES.get(value);
}

public String getValue() {
	return value;
}

}
