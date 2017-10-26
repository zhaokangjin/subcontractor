package com.accenture.subcontractor.job.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FileInfo {
    // 文件ID >>>表字段 : FILE_ID
    private String fileId;

    // 文件MD5 >>>表字段 : FILEMD5
    private String filemd5;

    // 实际文件名 >>>表字段 : ACTUAL_FILE_NAME
    private String actualFileName;

    // 删除标记 >>>表字段 : DELETE_FLAG
    private String deleteFlag;

    // 创建人 >>>表字段 : CREATOR
    private String creator;

    // 创建时间 >>>表字段 : CREATE_TIME
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    
    //
    private String userId;

    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFilemd5() {
        return filemd5;
    }

    public void setFilemd5(String filemd5) {
        this.filemd5 = filemd5;
    }

    public String getActualFileName() {
        return actualFileName;
    }

    public void setActualFileName(String actualFileName) {
        this.actualFileName = actualFileName;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}