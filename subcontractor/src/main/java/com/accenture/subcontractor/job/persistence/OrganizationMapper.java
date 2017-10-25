package com.accenture.subcontractor.job.persistence;

import com.accenture.subcontractor.job.domain.Organization;

public interface OrganizationMapper {
    int deleteByPrimaryKey(String organId);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(String organId);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);
}