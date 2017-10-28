package com.accenture.subcontractor.job.persistence;

import com.accenture.subcontractor.job.domain.PermissionMatrixKey;

public interface PermissionMatrixMapper {
	public abstract int deleteByPrimaryKey(PermissionMatrixKey key);

    public abstract int insert(PermissionMatrixKey record);

    public abstract int insertSelective(PermissionMatrixKey record);

}