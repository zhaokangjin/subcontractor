package com.accenture.subcontractor.job.domain;

public class SkillType {
	// 技能ID >>>表字段 : SKILL_ID
	private String skillId;

	// 技能名称 >>>表字段 : SKILL_NAME
	private String skillName;

	// 颜色 >>>表字段 : COLOR
	private String color;

	// 父技能>>>表字段 : PARENT_SKILL_ID
	private String parentSkillId;

	// 层级>>>表字段 : LEVEL
	private String level;
	
	// 排序>>>表字段 : SORT
	private int sort;

	public String getSkillId() {
		return skillId;
	}

	public void setSkillId(String skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getParentSkillId() {
		return parentSkillId;
	}

	public void setParentSkillId(String parentSkillId) {
		this.parentSkillId = parentSkillId;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
}