package gw2.api.v2.items;

public class UpgradeComponentDetails implements Details {
	public final UpgradeComponentType type;
	public final UpgradeComponentFlag[] flags;
	public final InfusionUpgradeFlag[] infusionUpgradeFlags;
	public final Suffix suffix;
	public final InfixUpgrade infixUpgrade;
	public final Bonus[] bonuses;
	private UpgradeComponentDetails(Builder builder) {
	  this.type = builder.type;
	  this.flags = builder.flags;
	  this.infusionUpgradeFlags = builder.infusionUpgradeFlags;
	  this.suffix = builder.suffix;
	  this.infixUpgrade = builder.infixUpgrade;
	  this.bonuses = builder.bonuses;
	}
	public static class Builder{

		private UpgradeComponentType type;
		private UpgradeComponentFlag[] flags;
		private InfusionUpgradeFlag[] infusionUpgradeFlags;
		private Suffix suffix;
		private InfixUpgrade infixUpgrade;
		private Bonus[] bonuses;
		public Builder withType(UpgradeComponentType type) {
		  this.type = type;
		  return this;
		}
		public Builder withFlags(UpgradeComponentFlag[] flags) {
		  this.flags = flags;
		  return this;
		}
		public Builder withInfusionUpgradeFlags(InfusionUpgradeFlag[] infusionUpgradeFlags) {
		  this.infusionUpgradeFlags = infusionUpgradeFlags;
		  return this;
		}
		public Builder withSuffix(Suffix suffix) {
		  this.suffix = suffix;
		  return this;
		}
		public Builder withInfixUpgrade(InfixUpgrade infixUpgrade) {
		  this.infixUpgrade = infixUpgrade;
		  return this;
		}
		public Builder withBonuses(Bonus[] bonuses) {
		  this.bonuses = bonuses;
		  return this;
		}
		public UpgradeComponentDetails build() {
		  return new UpgradeComponentDetails(this);
		}
	}
}
