package gw2.api.v2.recipes;

import gw2.api.v2.items.Id;

public class GuildIngredient {
	public final Id upgradeId;
	public final Count count;
	private GuildIngredient(Builder builder) {
	  this.upgradeId = builder.upgradeId;
	  this.count = builder.count;
	}
	public static class Builder{

		private Id upgradeId;
		private Count count;
		public Builder withUpgradeId(Id upgradeId) {
		  this.upgradeId = upgradeId;
		  return this;
		}
		public Builder withCount(Count count) {
		  this.count = count;
		  return this;
		}
		public GuildIngredient build() {
		  return new GuildIngredient(this);
		}
	}
}
