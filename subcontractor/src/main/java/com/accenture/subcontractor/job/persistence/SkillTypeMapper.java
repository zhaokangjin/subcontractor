package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.SkillType;

public interface SkillTypeMapper {
	public abstract int deleteByPrimaryKey(String skillId);

    public abstract int insert(SkillType record);

    public abstract int insertSelective(SkillType record);

    public abstract SkillType selectByPrimaryKey(String skillId);

    public abstract int updateByPrimaryKeySelective(SkillType record);

    public abstract int updateByPrimaryKey(SkillType record);
    
	public abstract int insertBatch(List<SkillType> recordList);

	public abstract int updateBatch(List<SkillType> recordList);

	public abstract int deleteBatch(List<SkillType> recordList);
}