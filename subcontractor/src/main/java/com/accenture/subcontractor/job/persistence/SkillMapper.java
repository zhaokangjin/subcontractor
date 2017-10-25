package com.accenture.subcontractor.job.persistence;

import com.accenture.subcontractor.job.domain.Skill;

public interface SkillMapper {
    int deleteByPrimaryKey(String professionSkillId);

    int insert(Skill record);

    int insertSelective(Skill record);

    Skill selectByPrimaryKey(String professionSkillId);

    int updateByPrimaryKeySelective(Skill record);

    int updateByPrimaryKey(Skill record);
}