package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.FileInfo;

public interface FileInfoMapper {
	int deleteByPrimaryKey(String fileId);

	int insert(FileInfo record);

	int insertSelective(FileInfo record);

	FileInfo selectByPrimaryKey(String fileId);

	int updateByPrimaryKeySelective(FileInfo record);

	int updateByPrimaryKey(FileInfo record);

	void insertBatch(List<FileInfo> recordList);

	void deleteBatch(List<FileInfo> recordList);

	void updateBatch(List<FileInfo> recordList);
}