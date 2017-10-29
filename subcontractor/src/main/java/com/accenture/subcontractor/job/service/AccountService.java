package com.accenture.subcontractor.job.service;

import java.util.List;

import com.accenture.subcontractor.job.domain.Account;
import com.accenture.subcontractor.job.domain.AccountKey;

public interface AccountService {

	public abstract int deleteByPrimaryKey(AccountKey key);

	public abstract void register(Account record);

	public abstract int insertSelective(Account record);

	public abstract Account selectByPrimaryKey(AccountKey key);
	
	public abstract List<Account> selectAccountByUserId(String key);

	public abstract int updateByPrimaryKeySelective(Account record);

	public abstract int updateByPrimaryKey(Account record);


}
