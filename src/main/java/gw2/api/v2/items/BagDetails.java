package gw2.api.v2.items;

public class BagDetails implements Details{
	public final Size size;
	public final NoSellOrSort noSellOrSort;
	private BagDetails(Builder builder) {
	  this.size = builder.size;
	  this.noSellOrSort = builder.noSellOrSort;
	}
	public static class Builder{

		private Size size;
		private NoSellOrSort noSellOrSort;
		public Builder withSize(Size size) {
		  this.size = size;
		  return this;
		}
		public Builder withNoSellOrSort(NoSellOrSort noSellOrSort) {
		  this.noSellOrSort = noSellOrSort;
		  return this;
		}
		public BagDetails build() {
		  return new BagDetails(this);
		}
	}
}
