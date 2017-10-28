package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.SkillType;
import com.accenture.subcontractor.job.domain.User;

public interface UserMapper {
	public abstract int deleteByPrimaryKey(String userId);

	public abstract int insert(User record);

	public abstract String insertUserChildren(User record);

	public abstract int insertSelective(User record);

	public abstract User selectByPrimaryKey(String userId);

	public abstract User getUserAndChildren(String userId);

	public abstract int updateByPrimaryKeySelective(User record);

	public abstract int updateUserChildren(User record);

	public abstract int updateByPrimaryKey(User record);
	
	public abstract int insertBatch(List<User> recordList);

	public abstract int updateBatch(List<User> recordList);

	public abstract int deleteBatch(List<User> recordList);

}