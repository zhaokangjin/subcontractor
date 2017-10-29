package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.PermissionMatrix;
import com.accenture.subcontractor.job.domain.PermissionMatrixKey;

public interface PermissionMatrixMapper {
    int deleteByPrimaryKey(PermissionMatrixKey key);

    int insert(PermissionMatrix record);

    int insertSelective(PermissionMatrix record);

    PermissionMatrix selectByPrimaryKey(PermissionMatrixKey key);

    int updateByPrimaryKeySelective(PermissionMatrix record);

    int updateByPrimaryKey(PermissionMatrix record);
    
	void insertBatch(List<PermissionMatrix> recordList);

	void deleteBatch(List<PermissionMatrix> recordList);

	void updateBatch(List<PermissionMatrix> recordList);
}