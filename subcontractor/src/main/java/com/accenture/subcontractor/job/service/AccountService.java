package com.accenture.subcontractor.job.service;

import com.accenture.subcontractor.job.domain.Account;
import com.accenture.subcontractor.job.domain.AccountKey;

public interface AccountService {

	public abstract int deleteByPrimaryKey(AccountKey key);

	public abstract int insert(Account record);

	public abstract int insertSelective(Account record);

	public abstract Account selectByPrimaryKey(AccountKey key);

	public abstract int updateByPrimaryKeySelective(Account record);

	public abstract int updateByPrimaryKey(Account record);

}
