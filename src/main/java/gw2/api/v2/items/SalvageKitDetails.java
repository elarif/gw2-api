package gw2.api.v2.items;

public class SalvageKitDetails implements Details{
	public final SalvageKitType type;
	public final Charges charges;
	private SalvageKitDetails(Builder builder) {
	  this.type = builder.type;
	  this.charges = builder.charges;
	}
	public static class Builder{

		private SalvageKitType type;
		private Charges charges;
		public Builder withType(SalvageKitType type) {
		  this.type = type;
		  return this;
		}
		public Builder withCharges(Charges charges) {
		  this.charges = charges;
		  return this;
		}
		public SalvageKitDetails build() {
		  return new SalvageKitDetails(this);
		}
	}
	
}
