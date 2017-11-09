package com.accenture.subcontractor.job.service;

import java.util.List;

import com.accenture.subcontractor.job.domain.Skill;

public interface SkillService {

	void deleteBatch(List<Skill> recordList);

	void deleteByPrimaryKey(String id);

	void insert(Skill record);

	void insertBatch(List<Skill> recordList);

	void insertSelective(Skill record);

	Skill selectByPrimaryKey(Skill record);

	void updateBatch(Skill record);

}
