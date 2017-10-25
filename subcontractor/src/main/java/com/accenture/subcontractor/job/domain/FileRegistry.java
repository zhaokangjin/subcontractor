package com.accenture.subcontractor.job.domain;

import java.util.Date;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;

public class FileRegistry {
    // 文件MD5 >>>表字段 : FILEMD5
    private String filemd5;

    // 文件路径 >>>表字段 : FILE_PATH
    private String filePath;

    // 文件大小 >>>表字段 : FILE_SIZE
    private String fileSize;

    // 删除标记 >>>表字段 : DELETE_FLAG
    private String deleteFlag;

    // 创建人 >>>表字段 : CREATOR
    private String creator;

    // 创建时间 >>>表字段 : CREATE_TIME
    private Date createTime;
    
    @TableField(exist = true)
    private List<FileInfo> fileInfoList;
    
    public List<FileInfo> getFileInfoList() {
		return fileInfoList;
	}

	public void setFileInfoList(List<FileInfo> fileInfoList) {
		this.fileInfoList = fileInfoList;
	}

	public String getFilemd5() {
        return filemd5;
    }

    public void setFilemd5(String filemd5) {
        this.filemd5 = filemd5;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
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