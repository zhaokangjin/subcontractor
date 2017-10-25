package com.accenture.subcontractor.job.persistence;

import com.accenture.subcontractor.job.domain.DictionariesItem;

public interface DictionariesItemMapper {
    int deleteByPrimaryKey(String itemCode);

    int insert(DictionariesItem record);

    int insertSelective(DictionariesItem record);

    DictionariesItem selectByPrimaryKey(String itemCode);

    int updateByPrimaryKeySelective(DictionariesItem record);

    int updateByPrimaryKey(DictionariesItem record);
}