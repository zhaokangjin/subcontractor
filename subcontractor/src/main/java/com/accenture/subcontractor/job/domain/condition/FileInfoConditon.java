package com.accenture.subcontractor.job.domain.condition;

import com.accenture.subcontractor.job.common.util.data.BaseCondition;
import com.accenture.subcontractor.job.domain.FileInfo;

public class FileInfoConditon extends BaseCondition{
	private static final long serialVersionUID = 2712650963027124747L;
	// 查询过滤条件
	private FileInfo FileInfo;

	public FileInfo getFileInfo() {
		return FileInfo;
	}
	public void setFileInfo(FileInfo fileInfo) {
		FileInfo = fileInfo;
	}
}
