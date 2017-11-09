package com.accenture.subcontractor.job.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.accenture.subcontractor.job.domain.User;
import com.accenture.subcontractor.job.persistence.EducationResumeMapper;
import com.accenture.subcontractor.job.persistence.UserMapper;
import com.accenture.subcontractor.job.service.AccountService;
import com.accenture.subcontractor.job.service.SkillService;
import com.accenture.subcontractor.job.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	UserMapper userMapper;
	@Resource
	EducationResumeMapper educationResumeMapper;
	@Resource
	AccountService accountService;
	@Resource
	SkillService skillService;
	
	
	
//	@Override
//	public User getUserAndChildren(User user) {
//		String userId=user.getUserId();
//		if(StringUtils.isEmpty(userId)){
//			return userMapper.getUserAndChildren(userId);
//		}else{
//			throw new NullPointerException("UserServiceImpl>getUserAndChildren>userId:userId is null");
//		}
//	}
	
//	@Transactional(rollbackFor=Exception.class)
//	@Override
//	public String saveOrUpdateUser(User user) {
//		try {
//			String userId="";
//			String id=user.getUserId();
//			if(StringUtils.isEmpty(id)){
//				userId=userMapper.insertUserChildren(user);
//			}else{
//				List<Account> accountList=accountService.selectAccountByUserId(id);
//				for(Account account:accountList){
//					//如果是微信类型的用户走下面的更新策略
//					if(null!=account.getAccountNumberType()&& account.getAccountNumberType().equals("W")){
//						userMapper.updateUserChildren(user);
//						List<EducationResume> educationResumeList=user.getEducationResumeList();
//						if(null!=educationResumeList&&educationResumeList.size()>0){
//							List<EducationResume> newEducationResumeList=new ArrayList<EducationResume>();
//							List<EducationResume> oldEducationResumeList=new ArrayList<EducationResume>();
//							for(EducationResume educationResume:educationResumeList){
//								if(null!=educationResume.getEducationResumeId()){
//									newEducationResumeList.add(educationResume);
//								}else{
//									oldEducationResumeList.add(educationResume);
//								}
//							}
//							
//						}
//						user.setAccountList(accountList);
//						userId=user.getUserId();
//					}
//				}
//			}
//			return userId;
//		} catch (Exception e) {
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//			logger.error("UserServiceImpl>saveUser>Exception"+e.getMessage());
//			throw e;
//		}
//		
//	}

	@Override
	public int deleteByPrimaryKey(String userId) {
		
		return userMapper.deleteByPrimaryKey(userId);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int insert(User record) {
		try {
			if(null!=record.getSkillList() && record.getSkillList().size()>0){
				skillService.insertBatch(record.getSkillList());
			}
			userMapper.insert(record);
			return 1;
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("UserServiceImpl>insert>Exception"+e);
			throw e;
		}
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

//	@Override
//	public int updateUserChildren(User record) {
//		return userMapper.updateUserChildren(record);
//	}

	@Override
	public int updateByPrimaryKey(User record) {
		
		return userMapper.updateByPrimaryKey(record);
	}

	@Override
	public User getUserAndChildren(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveOrUpdateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insertUserChildren(User record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateUserChildren(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User getUserByKey(String userId) {
		return userMapper.selectByPrimaryKey(userId);
	}
}
