package gw2.api.v2.items;

public class AttributeBonus {
	public final Attribute attribute;
	public final Modifier modifier;
	private AttributeBonus(Builder builder) {
	  this.attribute = builder.attribute;
	  this.modifier = builder.modifier;
	}
	public static class Builder{

		private Attribute attribute;
		private Modifier modifier;
		public Builder withAttribute(Attribute attribute) {
		  this.attribute = attribute;
		  return this;
		}
		public Builder withModifier(Modifier modifier) {
		  this.modifier = modifier;
		  return this;
		}
		public AttributeBonus build() {
		  return new AttributeBonus(this);
		}
	}
}
