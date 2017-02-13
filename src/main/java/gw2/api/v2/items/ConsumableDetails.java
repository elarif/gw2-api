package gw2.api.v2.items;

public class ConsumableDetails implements Details {
	public final ConsumableType type;
	public final Description description;
	public final DurationMs durationMs;
	public final UnlockType unlockType;
	public final ColorId colorId;
	public final RecipeId recipeId;
	public final ApplyCount applyCount;
	public final Name name;
	public final Icon icon;
	public final Id[] skins;
	public final Id guild_upgrade_id;
	public final Id[] extra_recipe_ids;
	private ConsumableDetails(Builder builder) {
		  this.type = builder.type;
		  this.description = builder.description;
		  this.durationMs = builder.durationMs;
		  this.unlockType = builder.unlockType;
		  this.colorId = builder.colorId;
		  this.recipeId = builder.recipeId;
		  this.applyCount = builder.applyCount;
		  this.name = builder.name;
		  this.icon = builder.icon;
		  this.skins = builder.skins;
		  this.guild_upgrade_id = builder.guild_upgrade_id;
		
	  this.extra_recipe_ids = builder.extra_recipe_ids;
	}
	public static class Builder{

		private ConsumableType type;
		private Description description;
		private DurationMs durationMs;
		private UnlockType unlockType;
		private ColorId colorId;
		private RecipeId recipeId;
		private ApplyCount applyCount;
		private Name name;
		private Icon icon;
		private Id[] skins;
		private Id guild_upgrade_id;
		private Id[] extra_recipe_ids;
		public Builder withType(ConsumableType type) {
		  this.type = type;
		  return this;
		}
		public Builder withDescription(Description description) {
		  this.description = description;
		  return this;
		}
		public Builder withDurationMs(DurationMs durationMs) {
		  this.durationMs = durationMs;
		  return this;
		}
		public Builder withUnlockType(UnlockType unlockType) {
		  this.unlockType = unlockType;
		  return this;
		}
		public Builder withColorId(ColorId colorId) {
		  this.colorId = colorId;
		  return this;
		}
		public Builder withRecipeId(RecipeId recipeId) {
		  this.recipeId = recipeId;
		  return this;
		}
		public Builder withApplyCount(ApplyCount applyCount) {
		  this.applyCount = applyCount;
		  return this;
		}
		public Builder withName(Name name) {
		  this.name = name;
		  return this;
		}
		public Builder withIcon(Icon icon) {
		  this.icon = icon;
		  return this;
		}
		public Builder withSkins(Id[] skins) {
		  this.skins = skins;
		  return this;
		}
		public Builder withGuild_upgrade_id(Id guild_upgrade_id) {
		  this.guild_upgrade_id = guild_upgrade_id;
		  return this;
		}
		public Builder withExtra_recipe_ids(Id[] extra_recipe_ids) {
		  this.extra_recipe_ids = extra_recipe_ids;
		  return this;
		}
		public ConsumableDetails build() {
		  return new ConsumableDetails(this);
		}
	}
}
