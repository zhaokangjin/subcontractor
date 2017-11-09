package com.accenture.subcontractor.job.service;

import java.util.List;

import com.accenture.subcontractor.job.domain.SkillType;
import com.accenture.subcontractor.job.domain.condition.SkillTypeConditon;
import com.github.pagehelper.PageInfo;

public interface SkillTypeService {
	SkillType selectByPrimaryKey(String skillId);
	void deleteBatch(List<SkillType> recordList);
	void insertBatch(List<SkillType> recordList);
	void insert(SkillType record);
	PageInfo<SkillType> queryList(SkillTypeConditon skillTypeConditon);
}
