package com.accenture.subcontractor.job.service;

import java.util.List;

import com.accenture.subcontractor.job.domain.Skill;
import com.accenture.subcontractor.job.domain.condition.SkillCondition;
import com.github.pagehelper.PageInfo;

public interface SkillService {

	void deleteBatch(List<Skill> recordList);

	void deleteByPrimaryKey(String id);

	void insert(Skill record);
	
	PageInfo<Skill> selectByUserId(SkillCondition skillCondition);

	void insertBatch(List<Skill> recordList);

	void insertSelective(Skill record);

	Skill selectByPrimaryKey(Skill record);

	void updateBatch(Skill record);

	void insertOrUpdate(List<Skill> recordList);
}
