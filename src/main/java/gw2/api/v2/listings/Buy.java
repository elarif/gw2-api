package gw2.api.v2.listings;

import gw2.api.v2.items.Price;
import gw2.api.v2.recipes.Count;

public class Buy {
	public final Count listings;
	public final Price unitPrice;
	public final Count quantity;
	private Buy(Builder builder) {
	  this.listings = builder.listings;
	  this.unitPrice = builder.unitPrice;
	  this.quantity = builder.quantity;
	}
	public static class Builder{

		private Count listings;
		private Price unitPrice;
		private Count quantity;
		public Builder withListings(Count listings) {
		  this.listings = listings;
		  return this;
		}
		public Builder withUnitPrice(Price unitPrice) {
		  this.unitPrice = unitPrice;
		  return this;
		}
		public Builder withQuantity(Count quantity) {
		  this.quantity = quantity;
		  return this;
		}
		public Buy build() {
		  return new Buy(this);
		}
	}
}
