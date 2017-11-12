package com.accenture.subcontractor.job.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accenture.subcontractor.job.domain.Skill;

public interface SkillMapper {
    int deleteByPrimaryKey(String professionSkillId);

    int insert(Skill record);

    int insertSelective(Skill record);

    Skill selectByPrimaryKey(@Param("id")String professionSkillId);
    
    List<Skill> selectByUserId(@Param("userId")String userId);

    int updateByPrimaryKeySelective(Skill record);

    int updateByPrimaryKey(Skill record);
    
	void insertBatch(List<Skill> recordList);

	void deleteBatch(List<Skill> recordList);

	void updateBatch(List<Skill> recordList);
}