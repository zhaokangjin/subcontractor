package com.accenture.subcontractor.job.persistence;

import com.accenture.subcontractor.job.domain.InternationalItem;

public interface InternationalItemMapper {
    int deleteByPrimaryKey(String itemId);

    int insert(InternationalItem record);

    int insertSelective(InternationalItem record);

    InternationalItem selectByPrimaryKey(String itemId);

    int updateByPrimaryKeySelective(InternationalItem record);

    int updateByPrimaryKey(InternationalItem record);
}