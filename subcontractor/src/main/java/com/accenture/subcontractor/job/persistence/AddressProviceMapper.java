package com.accenture.subcontractor.job.persistence;

import com.accenture.subcontractor.job.domain.AddressProvice;

public interface AddressProviceMapper {
    int insert(AddressProvice record);

    int insertSelective(AddressProvice record);
}