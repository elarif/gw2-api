package gw2.api.v2.items;

public class BackDetails implements Details{
	public final Defense defense;
	public final InfusionSlot[]	 infusionSlots;
	public final InfixUpgrade infixUpgrade;
	public final SuffixItemId suffixItemId;
	public final SecondarySuffixItemId secondarySuffixItemId;
	public final StatChoice[] statChoices;
	private BackDetails(Builder builder) {
	  this.defense = builder.defense;
	  this.infusionSlots = builder.infusionSlots;
	  this.infixUpgrade = builder.infixUpgrade;
	  this.suffixItemId = builder.suffixItemId;
	  this.secondarySuffixItemId = builder.secondarySuffixItemId;
	  this.statChoices = builder.statChoices;
	}
	public static class Builder{

		private Defense defense;
		private InfusionSlot[] infusionSlots;
		private InfixUpgrade infixUpgrade;
		private SuffixItemId suffixItemId;
		private SecondarySuffixItemId secondarySuffixItemId;
		private StatChoice[] statChoices;
		public Builder withDefense(Defense defense) {
		  this.defense = defense;
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
		public BackDetails build() {
		  return new BackDetails(this);
		}
	}
}
