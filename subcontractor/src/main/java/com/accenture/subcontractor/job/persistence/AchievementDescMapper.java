package com.accenture.subcontractor.job.persistence;

import com.accenture.subcontractor.job.domain.AchievementDesc;

public interface AchievementDescMapper {
    int deleteByPrimaryKey(String achievementId);

    int insert(AchievementDesc record);

    int insertSelective(AchievementDesc record);

    AchievementDesc selectByPrimaryKey(String achievementId);

    int updateByPrimaryKeySelective(AchievementDesc record);

    int updateByPrimaryKey(AchievementDesc record);
}