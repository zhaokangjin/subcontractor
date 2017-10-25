package com.accenture.subcontractor.job.persistence;

import com.accenture.subcontractor.job.domain.AddressCounty;

public interface AddressCountyMapper {
    int insert(AddressCounty record);

    int insertSelective(AddressCounty record);
}