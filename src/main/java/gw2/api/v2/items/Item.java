package gw2.api.v2.items;

public class Item {
	public final Id id;
	public final ChatLink chatLink;
	public final Name name;
	public final Icon icon;
	public final Description description;
	public final ItemType type;
	public final Rarity rarity;
	public final Level level;
	public final Price vendorValue;
	public final DefaultSkin defaultSkin;
	public final Flag[] flags;
	public final GameType[] gameTypes;
	public final Restriction[] restrictions;
	public final Details details;
	private Item(Builder builder) {
	  this.id = builder.id;
	  this.chatLink = builder.chatLink;
	  this.name = builder.name;
	  this.icon = builder.icon;
	  this.description = builder.description;
	  this.type = builder.type;
	  this.rarity = builder.rarity;
	  this.level = builder.level;
	  this.vendorValue = builder.vendorValue;
	  this.defaultSkin = builder.defaultSkin;
	  this.flags = builder.flags;
	  this.gameTypes = builder.gameTypes;
	  this.restrictions = builder.restrictions;
	  this.details = builder.details;
	}
	public static class Builder{

		private Id id;
		private ChatLink chatLink;
		private Name name;
		private Icon icon;
		private Description description;
		private ItemType type;
		private Rarity rarity;
		private Level level;
		private Price vendorValue;
		private DefaultSkin defaultSkin;
		private Flag[] flags;
		private GameType[] gameTypes;
		private Restriction[] restrictions;
		private Details details;
		public Builder withId(Id id) {
		  this.id = id;
		  return this;
		}
		public Builder withChatLink(ChatLink chatLink) {
		  this.chatLink = chatLink;
		  return this;
		}
		public Builder withName(Name name) {
		  this.name = name;
		  return this;
		}
		public Builder withIcon(Icon icon) {
		  this.icon = icon;
		  return this;
		}
		public Builder withDescription(Description description) {
		  this.description = description;
		  return this;
		}
		public Builder withType(ItemType type) {
		  this.type = type;
		  return this;
		}
		public Builder withRarity(Rarity rarity) {
		  this.rarity = rarity;
		  return this;
		}
		public Builder withLevel(Level level) {
		  this.level = level;
		  return this;
		}
		public Builder withVendorValue(Price vendorValue) {
		  this.vendorValue = vendorValue;
		  return this;
		}
		public Builder withDefaultSkin(DefaultSkin defaultSkin) {
		  this.defaultSkin = defaultSkin;
		  return this;
		}
		public Builder withFlags(Flag[] flags) {
		  this.flags = flags;
		  return this;
		}
		public Builder withGameTypes(GameType[] gameTypes) {
		  this.gameTypes = gameTypes;
		  return this;
		}
		public Builder withRestrictions(Restriction[] restrictions) {
		  this.restrictions = restrictions;
		  return this;
		}
		public Builder withDetails(Details details) {
		  this.details = details;
		  return this;
		}
		public Item build() {
		  return new Item(this);
		}
	}
}
