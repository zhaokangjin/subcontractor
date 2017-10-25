package com.accenture.subcontractor.job.persistence;

import com.accenture.subcontractor.job.domain.Industry;

public interface IndustryMapper {
    int deleteByPrimaryKey(String tradeId);

    int insert(Industry record);

    int insertSelective(Industry record);

    Industry selectByPrimaryKey(String tradeId);

    int updateByPrimaryKeySelective(Industry record);

    int updateByPrimaryKey(Industry record);
}