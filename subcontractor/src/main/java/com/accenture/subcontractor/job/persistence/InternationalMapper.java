package com.accenture.subcontractor.job.persistence;

import com.accenture.subcontractor.job.domain.International;

public interface InternationalMapper {
    int deleteByPrimaryKey(String internationalId);

    int insert(International record);

    int insertSelective(International record);

    International selectByPrimaryKey(String internationalId);

    int updateByPrimaryKeySelective(International record);

    int updateByPrimaryKey(International record);
}