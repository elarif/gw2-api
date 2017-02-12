package gw2.api.v2.items;

public class GizmoDetails implements Details {
	public final GizmoType type;

	private GizmoDetails(Builder builder) {
	  this.type = builder.type;
	}

	public static class Builder{

		private GizmoType type;

		public Builder withType(GizmoType type) {
		  this.type = type;
		  return this;
		}

		public GizmoDetails build() {
		  return new GizmoDetails(this);
		}
	}
}
