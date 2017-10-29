package com.accenture.subcontractor.job.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.accenture.subcontractor.job.domain.Account;
import com.accenture.subcontractor.job.domain.AccountKey;
import com.accenture.subcontractor.job.domain.User;
import com.accenture.subcontractor.job.persistence.AccountMapper;
import com.accenture.subcontractor.job.service.AccountService;
import com.accenture.subcontractor.job.service.UserService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	AccountMapper accountMapper;
	@Resource
	UserService userService;

	@Override
	public int deleteByPrimaryKey(AccountKey key) {
		try {
			return accountMapper.deleteByPrimaryKey(key);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("AccountServiceImpl>deleteByPrimaryKey>Exception:" + e);
			throw e;
		}
	}

	@Override
	public void register(Account record) {
		try {

			
			Account account=accountMapper.selectByPrimaryKey(record);
			if(null!=account){
				accountMapper.updateByPrimaryKey(record);
			}else{
				User user = new User();
				String userId = UUID.randomUUID().toString();
				user.setUserId(userId);
				user.setCreateTime(new Date());
				user.setDeleteFlag("N");
				userService.insert(user);
				record.setUserId(userId);
				accountMapper.insert(record);
			}
			
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("AccountServiceImpl>insert>Exception:" + e);
			throw e;
		}
	}

	@Override
	public int insertSelective(Account record) {
		try {
			return accountMapper.insertSelective(record);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("AccountServiceImpl>insertSelective>Exception:" + e);
			throw e;
		}
	}

	@Override
	public Account selectByPrimaryKey(AccountKey key) {
		try {
			return accountMapper.selectByPrimaryKey(key);
		} catch (Exception e) {
			logger.error("AccountServiceImpl>selectByPrimaryKey>Exception:" + e);
			throw e;
		}
	}
	// @Override
	// public List<Account> selectAccountByUserId(String userId) {
	// try {
	// return accountMapper.selectAccountByUserId(userId);
	// } catch (Exception e) {
	// logger.error("AccountServiceImpl>selectAccountByUserId>Exception:"+e);
	// throw e;
	// }
	// }

	@Override
	public int updateByPrimaryKeySelective(Account record) {
		try {
			return accountMapper.updateByPrimaryKey(record);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("AccountServiceImpl>updateByPrimaryKeySelective>Exception:" + e);
			throw e;
		}
	}

	@Override
	public int updateByPrimaryKey(Account record) {
		try {
			return accountMapper.updateByPrimaryKey(record);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("AccountServiceImpl>updateByPrimaryKey>Exception:" + e);
			throw e;
		}
	}

	@Override
	public List<Account> selectAccountByUserId(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
