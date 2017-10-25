package com.accenture.subcontractor.job.persistence;

import com.accenture.subcontractor.job.domain.AddressTown;

public interface AddressTownMapper {
    int insert(AddressTown record);

    int insertSelective(AddressTown record);
}