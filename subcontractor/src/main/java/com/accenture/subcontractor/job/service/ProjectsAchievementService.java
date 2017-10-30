package com.accenture.subcontractor.job.service;

import java.util.List;

import com.accenture.subcontractor.job.domain.ProjectsAchievement;

public interface ProjectsAchievementService {

	public abstract void deleteBatch(List<ProjectsAchievement> recordList);

	public abstract void insertBatch(List<ProjectsAchievement> recordList);

	public abstract void updateBatch(List<ProjectsAchievement> recordList);
}
