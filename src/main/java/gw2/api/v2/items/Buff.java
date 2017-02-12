package gw2.api.v2.items;

public class Buff {
	public final SkillId skillId;
	public final Description description;
	private Buff(Builder builder) {
	  this.skillId = builder.skillId;
	  this.description = builder.description;
	}
	public static class Builder{

		private SkillId skillId;
		private Description description;
		public Builder withSkillId(SkillId skillId) {
		  this.skillId = skillId;
		  return this;
		}
		public Builder withDescription(Description description) {
		  this.description = description;
		  return this;
		}
		public Buff build() {
		  return new Buff(this);
		}
	}
}
