package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.ProjectsDuty;
import com.accenture.subcontractor.job.domain.Skill;

public interface SkillMapper {
	public abstract int deleteByPrimaryKey(String professionSkillId);

    public abstract int insert(Skill record);

    public abstract int insertSelective(Skill record);

    public abstract Skill selectByPrimaryKey(String professionSkillId);

    public abstract int updateByPrimaryKeySelective(Skill record);

    public abstract int updateByPrimaryKey(Skill record);
    
	public abstract int insertBatch(List<Skill> recordList);

	public abstract int updateBatch(List<Skill> recordList);

	public abstract int deleteBatch(List<Skill> recordList);
}