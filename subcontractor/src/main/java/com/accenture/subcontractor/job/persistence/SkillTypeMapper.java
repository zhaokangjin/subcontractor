package com.accenture.subcontractor.job.persistence;

import com.accenture.subcontractor.job.domain.SkillType;

public interface SkillTypeMapper {
    int deleteByPrimaryKey(String skillId);

    int insert(SkillType record);

    int insertSelective(SkillType record);

    SkillType selectByPrimaryKey(String skillId);

    int updateByPrimaryKeySelective(SkillType record);

    int updateByPrimaryKey(SkillType record);
}