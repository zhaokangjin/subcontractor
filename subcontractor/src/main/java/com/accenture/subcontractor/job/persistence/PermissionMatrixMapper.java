package com.accenture.subcontractor.job.persistence;

import com.accenture.subcontractor.job.domain.PermissionMatrixKey;

public interface PermissionMatrixMapper {
    int deleteByPrimaryKey(PermissionMatrixKey key);

    int insert(PermissionMatrixKey record);

    int insertSelective(PermissionMatrixKey record);
}