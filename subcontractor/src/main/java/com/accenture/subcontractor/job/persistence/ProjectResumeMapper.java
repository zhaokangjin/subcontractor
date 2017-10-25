package com.accenture.subcontractor.job.persistence;

import com.accenture.subcontractor.job.domain.ProjectResume;

public interface ProjectResumeMapper {
    int deleteByPrimaryKey(String projectResumeId);

    int insert(ProjectResume record);

    int insertSelective(ProjectResume record);

    ProjectResume selectByPrimaryKey(String projectResumeId);

    int updateByPrimaryKeySelective(ProjectResume record);

    int updateByPrimaryKey(ProjectResume record);
}