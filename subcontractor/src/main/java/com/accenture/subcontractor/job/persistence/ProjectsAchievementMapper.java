package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.ProjectsAchievement;

public interface ProjectsAchievementMapper {
	public abstract int deleteByPrimaryKey(String projectAchievementId);

    public abstract int insert(ProjectsAchievement record);

    public abstract int insertSelective(ProjectsAchievement record);

    public abstract ProjectsAchievement selectByPrimaryKey(String projectAchievementId);

    public abstract int updateByPrimaryKeySelective(ProjectsAchievement record);

    public abstract int updateByPrimaryKey(ProjectsAchievement record);
    
	public abstract int insertBatch(List<ProjectsAchievement> recordList);

	public abstract int updateBatch(List<ProjectsAchievement> recordList);

	public abstract int deleteBatch(List<ProjectsAchievement> recordList);
}