package com.accenture.subcontractor.job.persistence;

import com.accenture.subcontractor.job.domain.ProjectsDuty;

public interface ProjectsDutyMapper {
    int deleteByPrimaryKey(String projectResponsibilityId);

    int insert(ProjectsDuty record);

    int insertSelective(ProjectsDuty record);

    ProjectsDuty selectByPrimaryKey(String projectResponsibilityId);

    int updateByPrimaryKeySelective(ProjectsDuty record);

    int updateByPrimaryKey(ProjectsDuty record);
}