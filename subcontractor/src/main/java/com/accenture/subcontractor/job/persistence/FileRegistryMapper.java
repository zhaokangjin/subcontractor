package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.FileRegistry;

public interface FileRegistryMapper {
	int deleteByPrimaryKey(String filemd5);

	int insert(FileRegistry record);

	int insertSelective(FileRegistry record);

	FileRegistry selectByPrimaryKey(String filemd5);

	int updateByPrimaryKeySelective(FileRegistry record);

	int updateByPrimaryKey(FileRegistry record);

	void insertBatch(List<FileRegistry> recordList);

	void deleteBatch(List<FileRegistry> recordList);

	void updateBatch(List<FileRegistry> recordList);
}