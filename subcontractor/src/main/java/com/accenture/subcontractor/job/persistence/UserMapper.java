package com.accenture.subcontractor.job.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accenture.subcontractor.job.domain.User;

public interface UserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(@Param("userId") String userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
	void insertBatch(List<User> recordList);

	void deleteBatch(List<User> recordList);

	void updateBatch(List<User> recordList);
}