package com.accenture.subcontractor.job.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;

import com.accenture.subcontractor.job.domain.User;
import com.accenture.subcontractor.job.persistence.UserMapper;
import com.accenture.subcontractor.job.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	UserMapper userMapper;

	@Override
	public User getUserAndChildren(User user) {
		String userId=user.getUserId();
		if(StringUtils.isEmpty(userId)){
			return userMapper.getUserAndChildren(userId);
		}else{
			throw new NullPointerException("UserServiceImpl>getUserAndChildren>userId:userId is null");
		}
	}
	
	@Transactional(rollbackFor=Exception.class)
	@Override
	public String saveOrUpdateUser(User user) {
		try {
			String userId="";
			String id=user.getUserId();
			if(StringUtils.isEmpty(id)){
				userId=userMapper.insertUserChildren(user);
			}else{
				userMapper.updateUserChildren(user);
				userId=user.getUserId();
			}
			return userId;
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("UserServiceImpl>saveUser>Exception"+e.getMessage());
			throw e;
		}
		
	}

	@Override
	public int deleteByPrimaryKey(String userId) {
		
		return userMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public int insert(User record) {
		
		return userMapper.insert(record);
	}

	@Override
	public String insertUserChildren(User record) {
		return userMapper.insertUserChildren(record);
	}

	@Override
	public int insertSelective(User record) {
		return userMapper.insertSelective(record);
	}

	@Override
	public User selectByPrimaryKey(String userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		return userMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateUserChildren(User record) {
		return userMapper.updateUserChildren(record);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		
		return userMapper.updateByPrimaryKey(record);
	}
}
