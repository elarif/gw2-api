package gw2.api.v2.items;

public class TrinketDetails implements Details{
	public final TrinketType type;
	public final InfusionSlot[] infusionSlots;
	public final InfixUpgrade infixUpgrade;
	public final SuffixItemId suffixItemId;
	public final SecondarySuffixItemId secondarySuffixItemId;
	public final StatChoice[] statChoices;
	private TrinketDetails(Builder builder) {
	  this.type = builder.type;
	  this.infusionSlots = builder.infusionSlots;
	  this.infixUpgrade = builder.infixUpgrade;
	  this.suffixItemId = builder.suffixItemId;
	  this.secondarySuffixItemId = builder.secondarySuffixItemId;
	  this.statChoices = builder.statChoices;
	}
	public static class Builder{

		private TrinketType type;
		private InfusionSlot[] infusionSlots;
		private InfixUpgrade infixUpgrade;
		private SuffixItemId suffixItemId;
		private SecondarySuffixItemId secondarySuffixItemId;
		private StatChoice[] statChoices;
		public Builder withType(TrinketType type) {
		  this.type = type;
		  return this;
		}
		public Builder withInfusionSlots(InfusionSlot[] infusionSlots) {
		  this.infusionSlots = infusionSlots;
		  return this;
		}
		public Builder withInfixUpgrade(InfixUpgrade infixUpgrade) {
		  this.infixUpgrade = infixUpgrade;
		  return this;
		}
		public Builder withSuffixItemId(SuffixItemId suffixItemId) {
		  this.suffixItemId = suffixItemId;
		  return this;
		}
		public Builder withSecondarySuffixItemId(SecondarySuffixItemId secondarySuffixItemId) {
		  this.secondarySuffixItemId = secondarySuffixItemId;
		  return this;
		}
		public Builder withStatChoices(StatChoice[] statChoices) {
		  this.statChoices = statChoices;
		  return this;
		}
		public TrinketDetails build() {
		  return new TrinketDetails(this);
		}
	}
}
