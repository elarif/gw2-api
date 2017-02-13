package gw2.api.v2.listings;

import gw2.api.v2.items.Id;

public class ListingItem {
	public final Id id;
	public final Listing[] buys;
	public final Listing[] sells;
	private ListingItem(Builder builder) {
	  this.id = builder.id;
	  this.buys = builder.buys;
	  this.sells = builder.sells;
	}
	public static class Builder{

		private Id id;
		private Listing[] buys;
		private Listing[] sells;
		public Builder withId(Id id) {
		  this.id = id;
		  return this;
		}
		public Builder withBuys(Listing[] buys) {
		  this.buys = buys;
		  return this;
		}
		public Builder withSells(Listing[] sells) {
		  this.sells = sells;
		  return this;
		}
		public ListingItem build() {
		  return new ListingItem(this);
		}
	}
}
