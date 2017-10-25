package com.accenture.subcontractor.job.persistence;

import com.accenture.subcontractor.job.domain.ProjectsDesc;

public interface ProjectsDescMapper {
    int deleteByPrimaryKey(String projectDescrId);

    int insert(ProjectsDesc record);

    int insertSelective(ProjectsDesc record);

    ProjectsDesc selectByPrimaryKey(String projectDescrId);

    int updateByPrimaryKeySelective(ProjectsDesc record);

    int updateByPrimaryKey(ProjectsDesc record);
}