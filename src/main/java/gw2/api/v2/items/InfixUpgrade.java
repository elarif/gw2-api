package gw2.api.v2.items;

import com.google.common.base.Preconditions;

public class InfixUpgrade {
	public final Id id;
	public final AttributeBonus[] attributes;
	public final Buff buff;
	private InfixUpgrade(Builder builder) {
	  this.id = builder.id;
	  this.attributes = builder.attributes;
	  this.buff = builder.buff;
	}
	public static class Builder{

		private Id id;
		private AttributeBonus[] attributes;
		private Buff buff;
		public Builder withId(Id id) {
		  this.id = id;
		  return this;
		}
		public Builder withAttributes(AttributeBonus[] attributes) {
		  this.attributes = attributes;
		  return this;
		}
		public Builder withBuff(Buff buff) {
		  this.buff = buff;
		  return this;
		}
		public InfixUpgrade build() {
		  return new InfixUpgrade(this);
		}
	}
	
}
