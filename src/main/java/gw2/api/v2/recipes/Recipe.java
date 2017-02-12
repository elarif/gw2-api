package gw2.api.v2.recipes;

import gw2.api.v2.items.ChatLink;
import gw2.api.v2.items.DurationMs;
import gw2.api.v2.items.Id;

public class Recipe {
	public final Id id;
	public final RecipeType type;
	public final Id outputItemId;
	public final Count outputItemCount;
	public final DurationMs timeToCraftMs  ;
	public final CraftingDiscipline[] disciplines;
	public final MinRating minRating;
	public final RecipeFlag[] flags;
	public final Ingredient[] ingredients;
	public final GuildIngredient[] guildIngredients;
	public final Id outputUpgradeId;
	public final ChatLink chatLink;
	private Recipe(Builder builder) {
	  this.id = builder.id;
	  this.type = builder.type;
	  this.outputItemId = builder.outputItemId;
	  this.outputItemCount = builder.outputItemCount;
	  this.timeToCraftMs = builder.timeToCraftMs;
	  this.disciplines = builder.disciplines;
	  this.minRating = builder.minRating;
	  this.flags = builder.flags;
	  this.ingredients = builder.ingredients;
	  this.guildIngredients = builder.guildIngredients;
	  this.outputUpgradeId = builder.outputUpgradeId;
	  this.chatLink = builder.chatLink;
	}
	public static class Builder{

		private Id id;
		private RecipeType type;
		private Id outputItemId;
		private Count outputItemCount;
		private DurationMs timeToCraftMs;
		private CraftingDiscipline[] disciplines;
		private MinRating minRating;
		private RecipeFlag[] flags;
		private Ingredient[] ingredients;
		private GuildIngredient[] guildIngredients;
		private Id outputUpgradeId;
		private ChatLink chatLink;
		public Builder withId(Id id) {
		  this.id = id;
		  return this;
		}
		public Builder withType(RecipeType type) {
		  this.type = type;
		  return this;
		}
		public Builder withOutputItemId(Id outputItemId) {
		  this.outputItemId = outputItemId;
		  return this;
		}
		public Builder withOutputItemCount(Count outputItemCount) {
		  this.outputItemCount = outputItemCount;
		  return this;
		}
		public Builder withTimeToCraftMs(DurationMs timeToCraftMs) {
		  this.timeToCraftMs = timeToCraftMs;
		  return this;
		}
		public Builder withDisciplines(CraftingDiscipline[] disciplines) {
		  this.disciplines = disciplines;
		  return this;
		}
		public Builder withMinRating(MinRating minRating) {
		  this.minRating = minRating;
		  return this;
		}
		public Builder withFlags(RecipeFlag[] flags) {
		  this.flags = flags;
		  return this;
		}
		public Builder withIngredients(Ingredient[] ingredients) {
		  this.ingredients = ingredients;
		  return this;
		}
		public Builder withGuildIngredients(GuildIngredient[] guildIngredients) {
		  this.guildIngredients = guildIngredients;
		  return this;
		}
		public Builder withOutputUpgradeId(Id outputUpgradeId) {
		  this.outputUpgradeId = outputUpgradeId;
		  return this;
		}
		public Builder withChatLink(ChatLink chatLink) {
		  this.chatLink = chatLink;
		  return this;
		}
		public Recipe build() {
		  return new Recipe(this);
		}
	}
	
}
