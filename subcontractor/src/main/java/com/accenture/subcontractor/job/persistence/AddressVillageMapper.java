package com.accenture.subcontractor.job.persistence;

import com.accenture.subcontractor.job.domain.AddressVillage;

public interface AddressVillageMapper {
    int insert(AddressVillage record);

    int insertSelective(AddressVillage record);
}