package com.accenture.subcontractor.job.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accenture.subcontractor.job.domain.Account;
import com.accenture.subcontractor.job.domain.AccountKey;

public interface AccountMapper {
    public abstract int deleteByPrimaryKey(AccountKey key);

    public abstract int insert(Account record);

    public abstract int insertSelective(Account record);

    public abstract Account selectByPrimaryKey(AccountKey key);
    
    public abstract List<Account> selectAccountByUserId(@Param("userId") String userId);
    
    public abstract int updateByPrimaryKeySelective(Account record);

    public abstract int updateByPrimaryKey(Account record);
}