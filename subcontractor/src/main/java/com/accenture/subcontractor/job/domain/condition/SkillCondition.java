package com.accenture.subcontractor.job.domain.condition;

import com.accenture.subcontractor.job.common.util.data.BaseCondition;
import com.accenture.subcontractor.job.domain.Skill;

public class SkillCondition extends BaseCondition {
	private static final long serialVersionUID = -1753561554429240233L;
	private Skill skill;
	public Skill getSkill() {
		return skill;
	}
	public void setSkill(Skill skill) {
		this.skill = skill;
	}
}
