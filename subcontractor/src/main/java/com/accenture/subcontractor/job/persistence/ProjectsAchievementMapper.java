package com.accenture.subcontractor.job.persistence;

import com.accenture.subcontractor.job.domain.ProjectsAchievement;

public interface ProjectsAchievementMapper {
    int deleteByPrimaryKey(String projectAchievementId);

    int insert(ProjectsAchievement record);

    int insertSelective(ProjectsAchievement record);

    ProjectsAchievement selectByPrimaryKey(String projectAchievementId);

    int updateByPrimaryKeySelective(ProjectsAchievement record);

    int updateByPrimaryKey(ProjectsAchievement record);
}