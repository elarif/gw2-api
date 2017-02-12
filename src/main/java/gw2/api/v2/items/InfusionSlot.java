package gw2.api.v2.items;

public class InfusionSlot {
	public final InfusionSlotFlag[] flags;
	public final InfusionSlotItemId itemId;
	private InfusionSlot(Builder builder) {
	  this.flags = builder.flags;
	  this.itemId = builder.itemId;
	}
	public static class Builder{

		private InfusionSlotFlag[] flags;
		private InfusionSlotItemId itemId;
		public Builder withFlags(InfusionSlotFlag[] flags) {
		  this.flags = flags;
		  return this;
		}
		public Builder withItemId(InfusionSlotItemId itemId) {
		  this.itemId = itemId;
		  return this;
		}
		public InfusionSlot build() {
		  return new InfusionSlot(this);
		}
	}
}
