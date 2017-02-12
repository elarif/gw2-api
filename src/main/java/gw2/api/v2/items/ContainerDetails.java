package gw2.api.v2.items;

public class ContainerDetails implements Details {
	public final ContainerType type;

	private ContainerDetails(Builder builder) {
	  this.type = builder.type;
	}

	public static class Builder{

		private ContainerType type;

		public Builder withType(ContainerType type) {
		  this.type = type;
		  return this;
		}

		public ContainerDetails build() {
		  return new ContainerDetails(this);
		}
	}
}
