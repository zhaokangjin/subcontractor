package com.accenture.subcontractor.job.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accenture.subcontractor.job.domain.SkillType;

public interface SkillTypeMapper {
	int deleteByPrimaryKey(String skillId);

	int insert(SkillType record);

	int insertSelective(SkillType record);

	SkillType selectByPrimaryKey(@Param("skillId") String skillId);
	
	List<SkillType> selectSkillTypeByName(@Param("skillName") String skillName);

	int updateByPrimaryKeySelective(SkillType record);
	
	int updateByName(SkillType record);
	
	int updateByPrimaryKey(SkillType record);

	void insertBatch(List<SkillType> recordList);

	void deleteBatch(List<SkillType> recordList);

	void updateBatch(List<SkillType> recordList);
	//根据条件进行子查询
	List<SkillType> listChildSkill(@Param("skillId") String skillId);
	//根条件分页查询
	List<SkillType> querySkillRootList(SkillType skillType);
	//一一对应批量查询
	List<SkillType> queryListByIds(List<SkillType> recordList);
}