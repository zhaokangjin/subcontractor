package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.ProjectsDuty;

public interface ProjectsDutyMapper {
	public abstract int deleteByPrimaryKey(String projectResponsibilityId);

    public abstract int insert(ProjectsDuty record);

    public abstract int insertSelective(ProjectsDuty record);

    public abstract ProjectsDuty selectByPrimaryKey(String projectResponsibilityId);

    public abstract int updateByPrimaryKeySelective(ProjectsDuty record);

    public abstract int updateByPrimaryKey(ProjectsDuty record);
    
	public abstract int insertBatch(List<ProjectsDuty> recordList);

	public abstract int updateBatch(List<ProjectsDuty> recordList);

	public abstract int deleteBatch(List<ProjectsDuty> recordList);
}