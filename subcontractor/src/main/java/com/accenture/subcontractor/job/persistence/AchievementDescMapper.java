package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.AchievementDesc;

public interface AchievementDescMapper {
    int deleteByPrimaryKey(String achievementId);

    int insert(AchievementDesc record);

    int insertSelective(AchievementDesc record);

    AchievementDesc selectByPrimaryKey(String achievementId);

    int updateByPrimaryKeySelective(AchievementDesc record);

    int updateByPrimaryKey(AchievementDesc record);
    
	void insertBatch(List<AchievementDesc> recordList);

	void deleteBatch(List<AchievementDesc> recordList);

	void updateBatch(List<AchievementDesc> recordList);
}