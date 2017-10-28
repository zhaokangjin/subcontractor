package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.ProjectResume;

public interface ProjectResumeMapper {
	public abstract int deleteByPrimaryKey(String projectResumeId);

	public abstract int insert(ProjectResume record);

	public abstract int insertSelective(ProjectResume record);

	public abstract ProjectResume selectByPrimaryKey(String projectResumeId);

	public abstract int updateByPrimaryKeySelective(ProjectResume record);

	public abstract int updateByPrimaryKey(ProjectResume record);
    
	public abstract int insertBatch(List<ProjectResume> recordList);

	public abstract int updateBatch(List<ProjectResume> recordList);

	public abstract int deleteBatch(List<ProjectResume> recordList);
}