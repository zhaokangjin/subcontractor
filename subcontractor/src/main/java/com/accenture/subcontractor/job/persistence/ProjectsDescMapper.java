package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.ProjectsDesc;

public interface ProjectsDescMapper {
	public abstract int deleteByPrimaryKey(String projectDescrId);

    public abstract int insert(ProjectsDesc record);

    public abstract int insertSelective(ProjectsDesc record);

    public abstract ProjectsDesc selectByPrimaryKey(String projectDescrId);

    public abstract int updateByPrimaryKeySelective(ProjectsDesc record);

    public abstract int updateByPrimaryKey(ProjectsDesc record);
    
	public abstract int insertBatch(List<ProjectsDesc> recordList);

	public abstract int updateBatch(List<ProjectsDesc> recordList);

	public abstract int deleteBatch(List<ProjectsDesc> recordList);
}