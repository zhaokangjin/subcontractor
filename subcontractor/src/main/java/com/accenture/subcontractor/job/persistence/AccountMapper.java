package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.Account;
import com.accenture.subcontractor.job.domain.AccountKey;

public interface AccountMapper {
    int deleteByPrimaryKey(AccountKey key);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(AccountKey key);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
    
	void insertBatch(List<Account> recordList);

	void deleteBatch(List<Account> recordList);

	void updateBatch(List<Account> recordList);
}