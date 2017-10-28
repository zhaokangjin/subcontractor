package com.accenture.subcontractor.job.persistence;

import com.accenture.subcontractor.job.domain.Role;

public interface RoleMapper {
	public abstract int deleteByPrimaryKey(String roleId);

	public abstract int insert(Role record);

	public abstract int insertSelective(Role record);

	public abstract Role selectByPrimaryKey(String roleId);

	public abstract int updateByPrimaryKeySelective(Role record);

	public abstract int updateByPrimaryKey(Role record);
}