package gw2.api.v2.items;

public class GizmoDetails implements Details {
	public final GizmoType type;
	public final Id guild_upgrade_id;
	private GizmoDetails(Builder builder) {
		  this.type = builder.type;
		
	  this.guild_upgrade_id = builder.guild_upgrade_id;
	}
	public static class Builder{

		private GizmoType type;
		private Id guild_upgrade_id;

		public Builder withType(GizmoType type) {
		  this.type = type;
		  return this;
		}

		public Builder withGuild_upgrade_id(Id guild_upgrade_id) {
		  this.guild_upgrade_id = guild_upgrade_id;
		  return this;
		}

		public GizmoDetails build() {
		  return new GizmoDetails(this);
		}
	}
}
