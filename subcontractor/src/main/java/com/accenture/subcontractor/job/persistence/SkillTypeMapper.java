package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.SkillType;

public interface SkillTypeMapper {
    int deleteByPrimaryKey(String skillId);

    int insert(SkillType record);

    int insertSelective(SkillType record);

    SkillType selectByPrimaryKey(String skillId);

    int updateByPrimaryKeySelective(SkillType record);

    int updateByPrimaryKey(SkillType record);
    
	void insertBatch(List<SkillType> recordList);

	void deleteBatch(List<SkillType> recordList);

	void updateBatch(List<SkillType> recordList);
}