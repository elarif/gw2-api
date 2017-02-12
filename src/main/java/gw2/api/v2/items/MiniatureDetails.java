package gw2.api.v2.items;

public class MiniatureDetails implements Details{
	public final MinipetId minipetId;

	private MiniatureDetails(Builder builder) {
	  this.minipetId = builder.minipetId;
	}

	public static class Builder{

		private MinipetId minipetId;

		public Builder withMinipetId(MinipetId minipetId) {
		  this.minipetId = minipetId;
		  return this;
		}

		public MiniatureDetails build() {
		  return new MiniatureDetails(this);
		}
	}
	
}
