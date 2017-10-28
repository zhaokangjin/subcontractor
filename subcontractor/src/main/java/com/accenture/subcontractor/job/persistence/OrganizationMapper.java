package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.Organization;

public interface OrganizationMapper {
	public abstract int deleteByPrimaryKey(String organId);

	public abstract int insert(Organization record);

	public abstract int insertSelective(Organization record);

	public abstract Organization selectByPrimaryKey(String organId);

	public abstract int updateByPrimaryKeySelective(Organization record);

	public abstract int updateByPrimaryKey(Organization record);
    
	public abstract int insertBatch(List<Organization> recordList);

	public abstract int updateBatch(List<Organization> recordList);

	public abstract int deleteBatch(List<Organization> recordList);
}