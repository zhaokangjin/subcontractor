package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.Organization;

public interface OrganizationMapper {
    int deleteByPrimaryKey(String organId);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(String organId);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);
    
	void insertBatch(List<Organization> recordList);

	void deleteBatch(List<Organization> recordList);

	void updateBatch(List<Organization> recordList);
}