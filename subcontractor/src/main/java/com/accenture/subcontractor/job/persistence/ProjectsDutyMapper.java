package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.ProjectsDuty;

public interface ProjectsDutyMapper {
    int deleteByPrimaryKey(String projectResponsibilityId);

    int insert(ProjectsDuty record);

    int insertSelective(ProjectsDuty record);

    ProjectsDuty selectByPrimaryKey(String projectResponsibilityId);

    int updateByPrimaryKeySelective(ProjectsDuty record);

    int updateByPrimaryKey(ProjectsDuty record);
    
	void insertBatch(List<ProjectsDuty> recordList);

	void deleteBatch(List<ProjectsDuty> recordList);

	void updateBatch(List<ProjectsDuty> recordList);
}