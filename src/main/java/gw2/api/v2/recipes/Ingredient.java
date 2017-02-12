package gw2.api.v2.recipes;

import gw2.api.v2.items.Id;

public class Ingredient {
	public final Id itemId;
	public final Count count;
	private Ingredient(Builder builder) {
	  this.itemId = builder.itemId;
	  this.count = builder.count;
	}
	public static class Builder{

		private Id itemId;
		private Count count;
		public Builder withItemId(Id itemId) {
		  this.itemId = itemId;
		  return this;
		}
		public Builder withCount(Count count) {
		  this.count = count;
		  return this;
		}
		public Ingredient build() {
		  return new Ingredient(this);
		}
	}
}
