package gw2.api.v2.items;

public class GatheringToolDetails implements Details{
	public final GatheringToolType type;

	private GatheringToolDetails(Builder builder) {
	  this.type = builder.type;
	}

	public static class Builder{

		private GatheringToolType type;

		public Builder withType(GatheringToolType type) {
		  this.type = type;
		  return this;
		}

		public GatheringToolDetails build() {
		  return new GatheringToolDetails(this);
		}
	}
}
