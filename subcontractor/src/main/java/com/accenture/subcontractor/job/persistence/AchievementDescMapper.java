package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.AchievementDesc;

public interface AchievementDescMapper {
    public abstract int deleteByPrimaryKey(String achievementId);

    public abstract int insert(AchievementDesc record);

    public abstract int insertSelective(AchievementDesc record);

    public abstract AchievementDesc selectByPrimaryKey(String achievementId);

    public abstract int updateByPrimaryKeySelective(AchievementDesc record);

    public abstract int updateByPrimaryKey(AchievementDesc record);
    
    public abstract int insertBatch(List<AchievementDesc> recordList);
    
    public abstract int updateBatch(List<AchievementDesc> recordList);
    
    public abstract int deleteBatch(List<AchievementDesc> recordList);
}