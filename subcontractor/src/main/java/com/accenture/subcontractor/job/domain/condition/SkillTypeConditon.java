package com.accenture.subcontractor.job.domain.condition;

import com.accenture.subcontractor.job.common.util.data.BaseCondition;
import com.accenture.subcontractor.job.domain.SkillType;

public class SkillTypeConditon extends BaseCondition{
	private static final long serialVersionUID = 1L;
	// 查询过滤条件
	private SkillType skillType;
	public SkillType getSkillType() {
		return skillType;
	}
	public void setSkillType(SkillType skillType) {
		this.skillType = skillType;
	}
}
