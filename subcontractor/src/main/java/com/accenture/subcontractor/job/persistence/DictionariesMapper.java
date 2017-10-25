package com.accenture.subcontractor.job.persistence;

import com.accenture.subcontractor.job.domain.Dictionaries;

public interface DictionariesMapper {
    int deleteByPrimaryKey(String dictionaryCode);

    int insert(Dictionaries record);

    int insertSelective(Dictionaries record);

    Dictionaries selectByPrimaryKey(String dictionaryCode);

    int updateByPrimaryKeySelective(Dictionaries record);

    int updateByPrimaryKey(Dictionaries record);
}