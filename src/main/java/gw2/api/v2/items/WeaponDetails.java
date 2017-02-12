package gw2.api.v2.items;

public class WeaponDetails implements Details {
	public final WeaponType type;
	public final DamageType damageType;
	public final MinPower minPower;
	public final MaxPower maxPower;
	public final Defense defense;
	public final InfusionSlot[]	 infusionSlots;
	public final InfixUpgrade infixUpgrade;
	public final SuffixItemId suffixItemId;
	public final SecondarySuffixItemId secondarySuffixItemId;
	public final StatChoice[] statChoices;
	private WeaponDetails(Builder builder) {
	  this.type = builder.type;
	  this.damageType = builder.damageType;
	  this.minPower = builder.minPower;
	  this.maxPower = builder.maxPower;
	  this.defense = builder.defense;
	  this.infusionSlots = builder.infusionSlots;
	  this.infixUpgrade = builder.infixUpgrade;
	  this.suffixItemId = builder.suffixItemId;
	  this.secondarySuffixItemId = builder.secondarySuffixItemId;
	  this.statChoices = builder.statChoices;
	}
	public static class Builder{

		private WeaponType type;
		private DamageType damageType;
		private MinPower minPower;
		private MaxPower maxPower;
		private Defense defense;
		private InfusionSlot[] infusionSlots;
		private InfixUpgrade infixUpgrade;
		private SuffixItemId suffixItemId;
		private SecondarySuffixItemId secondarySuffixItemId;
		private StatChoice[] statChoices;
		public Builder withType(WeaponType type) {
		  this.type = type;
		  return this;
		}
		public Builder withDamageType(DamageType damageType) {
		  this.damageType = damageType;
		  return this;
		}
		public Builder withMinPower(MinPower minPower) {
		  this.minPower = minPower;
		  return this;
		}
		public Builder withMaxPower(MaxPower maxPower) {
		  this.maxPower = maxPower;
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
		public WeaponDetails build() {
		  return new WeaponDetails(this);
		}
	}
}
