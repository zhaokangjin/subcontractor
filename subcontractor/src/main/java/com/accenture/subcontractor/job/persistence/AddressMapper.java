package com.accenture.subcontractor.job.persistence;

import com.accenture.subcontractor.job.domain.Address;

public interface AddressMapper {
    int insert(Address record);

    int insertSelective(Address record);
}