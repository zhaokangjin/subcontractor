package com.accenture.subcontractor.job.service;

import com.accenture.subcontractor.job.domain.User;

public interface UserService {

	public abstract User getUserAndChildren(User user);
	
	public abstract String saveOrUpdateUser(User user);

	public abstract int deleteByPrimaryKey(String userId);

	public abstract int insert(User record);
    
	public abstract String insertUserChildren(User record);

	public abstract int insertSelective(User record);

	public abstract User selectByPrimaryKey(String userId);

	public abstract int updateByPrimaryKeySelective(User record);
    
	public abstract int updateUserChildren(User record);

	public abstract int updateByPrimaryKey(User record);	
}
