package com.accenture.subcontractor.job.persistence;

import com.accenture.subcontractor.job.domain.AddressCity;

public interface AddressCityMapper {
    int insert(AddressCity record);

    int insertSelective(AddressCity record);
}