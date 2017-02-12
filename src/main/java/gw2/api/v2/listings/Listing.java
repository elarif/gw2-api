package gw2.api.v2.listings;

import gw2.api.v2.items.Id;

public class Listing {
	public final Id id;
	public final Buy[] buys;
	public final Sell[] sells;
	private Listing(Builder builder) {
	  this.id = builder.id;
	  this.buys = builder.buys;
	  this.sells = builder.sells;
	}
	public static class Builder{

		private Id id;
		private Buy[] buys;
		private Sell[] sells;
		public Builder withId(Id id) {
		  this.id = id;
		  return this;
		}
		public Builder withBuys(Buy[] buys) {
		  this.buys = buys;
		  return this;
		}
		public Builder withSells(Sell[] sells) {
		  this.sells = sells;
		  return this;
		}
		public Listing build() {
		  return new Listing(this);
		}
	}
}
