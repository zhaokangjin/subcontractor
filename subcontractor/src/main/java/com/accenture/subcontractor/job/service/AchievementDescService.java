package com.accenture.subcontractor.job.service;

import java.util.List;

import com.accenture.subcontractor.job.domain.AchievementDesc;

public interface AchievementDescService {

	public abstract void deleteBatch(List<AchievementDesc> recordList) ;
	public abstract void insertBatch(List<AchievementDesc> recordList) ;
	public abstract void updateBatch(List<AchievementDesc> recordList) ;


}
