package gw2.api.v2.items;

public class ArmorDetails implements Details{
	public final ArmorSlotType type;
	public final WeightClass weightClass;
	public final Defense defense;
	public final InfusionSlot[]	 infusionSlots;
	public final InfixUpgrade infixUpgrade;
	public final SuffixItemId suffixItemId;
	public final SecondarySuffixItemId secondarySuffixItemId;
	public final StatChoice[] statChoices;
	private ArmorDetails(Builder builder) {
	  this.type = builder.type;
	  this.weightClass = builder.weightClass;
	  this.defense = builder.defense;
	  this.infusionSlots = builder.infusionSlots;
	  this.infixUpgrade = builder.infixUpgrade;
	  this.suffixItemId = builder.suffixItemId;
	  this.secondarySuffixItemId = builder.secondarySuffixItemId;
	  this.statChoices = builder.statChoices;
	}
	public static class Builder{

		private ArmorSlotType type;
		private WeightClass weightClass;
		private Defense defense;
		private InfusionSlot[] infusionSlots;
		private InfixUpgrade infixUpgrade;
		private SuffixItemId suffixItemId;
		private SecondarySuffixItemId secondarySuffixItemId;
		private StatChoice[] statChoices;
		public Builder withType(ArmorSlotType type) {
		  this.type = type;
		  return this;
		}
		public Builder withWeightClass(WeightClass weightClass) {
		  this.weightClass = weightClass;
		  return this;
		}
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
		public ArmorDetails build() {
		  return new ArmorDetails(this);
		}
	}
	
}
