package com.accenture.subcontractor.job.service;

import java.util.List;

import com.accenture.subcontractor.job.domain.SkillType;
import com.accenture.subcontractor.job.domain.StatusCode;
import com.accenture.subcontractor.job.domain.condition.SkillTypeConditon;
import com.github.pagehelper.PageInfo;

public interface SkillTypeService {
	SkillType selectByPrimaryKey(String skillId);
	List<SkillType> selectSkillTypeByName(String skillName);
	void deleteBatch(List<SkillType> recordList);
	void insertBatch(List<SkillType> recordList);
	StatusCode insert(SkillType record);
	//根据条件进行子查询
	List<SkillType> listChildSkill(String skillId);
	//一一对应批量
	List<SkillType> queryListByIds(List<SkillType> recordList);
	//技能根分页查询
	PageInfo<SkillType> querySkillRootList(SkillTypeConditon skillTypeConditon);
	
	StatusCode insertOrUpdate(List<SkillType> recordList);
}
