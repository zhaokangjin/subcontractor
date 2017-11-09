package com.accenture.subcontractor.job.domain.condition;

import com.accenture.subcontractor.job.common.util.data.BaseCondition;
import com.accenture.subcontractor.job.domain.SkillType;

public class SkillTypeConditon extends BaseCondition{
	private static final long serialVersionUID = 1L;
	// 查询过滤条件
	private SkillType skillTyp;
	public SkillType getSkillTyp() {
		return skillTyp;
	}
	public void setSkillTyp(SkillType skillTyp) {
		this.skillTyp = skillTyp;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
