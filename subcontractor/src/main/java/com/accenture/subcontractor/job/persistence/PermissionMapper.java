package com.accenture.subcontractor.job.persistence;

import com.accenture.subcontractor.job.domain.Permission;

public interface PermissionMapper {
	public abstract int deleteByPrimaryKey(String permissionId);

    public abstract int insert(Permission record);

    public abstract int insertSelective(Permission record);

    public abstract Permission selectByPrimaryKey(String permissionId);

    public abstract int updateByPrimaryKeySelective(Permission record);

    public abstract int updateByPrimaryKey(Permission record);
    
}