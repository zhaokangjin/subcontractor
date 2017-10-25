package com.accenture.subcontractor.job.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accenture.subcontractor.job.domain.FileInfo;
/**
 * 该接口提供单条、批量查询;单条、批量插入;单条、批量软删除;单条、批量硬删除;单条、批量更新12个服务
 * @ClassName: FileInfoMapper   
 * @Description: 单条、批量查询;单条、批量插入;单条、批量软删除;单条、批量硬删除;单条、批量更新  
 * @author: kangjin.zhao  
 * @date:2017年9月8日 上午8:42:00
 */
public interface FileInfoMapper {
	/**
	 * 该接口提供单条新增服务
	 * @Title: insert
	 * @Description: 单条新增
	 * @param record
	 * @return
	 */
	int insert(FileInfo record);
	
	/**
	 * 该接口条件单条新增服务
	 * @Title: insertSelective
	 * @Description: 单条新增
	 * @param record
	 * @return
	 */
	int insertSelective(FileInfo record);
	
	/**
	 * 该接口提供批量新增服务
	 * @Title: insertByBatch   
	 * @Description: 批量新增 
	 * @param record
	 * @return
	 */
	int insertBatch(List<FileInfo> record);
	
	/**
	 * 该接口提供单条物理删除服务
	 * @Title: deleteByPrimaryKey
	 * @Description: 单条物理删除
	 * @param fileId
	 * @return
	 */
	int deleteByPrimaryKey(@Param("primaryKey")String primaryKey);
	/**
	 * 该接口提供物理批量删除服务
	 * @Title: deleteList   
	 * @Description: 物理批量删除 
	 * @param record
	 * @return
	 */
	int deleteList(List<FileInfo> record);
	
	/**
	 * 该接口提供单条软删除服务
	 * @Title: softDelete   
	 * @Description: 单条软删除  
	 * @param record
	 */
	void deleteByPrimaryKeySoft (@Param("primaryKey")String primaryKey);
	
	/**
	 * 该接口提供批量软删除服务
	 * @Title: softDeleteList   
	 * @Description: 批量软删除 
	 * @param record
	 */
	void deleteListSoft(List<FileInfo> record);
	
	/**
	 * 该接口提供有条件单条更新服务
	 * @Title: updateByPrimaryKey
	 * @Description: 有条件单条更新
	 * @param record
	 * @return
	 */
	int updateByPrimaryKey(FileInfo record);
	
	/**
	 * 该接口提供单条更新服务
	 * @Title: updateByPrimaryKeySelective
	 * @Description: 提供单条更新
	 * @param record
	 * @return
	 */
	void updateByPrimaryKeySelective(FileInfo record);

	/**
	 * 该接口提供批量更新服务
	 * @Title: updateBatch   
	 * @Description: 批量更新 
	 * @param record
	 * @return
	 */
	void updateList(List<FileInfo> record);
	/**
	 * 该接口提供单条查询服务
	 * @Title: selectByPrimaryKey
	 * @Description: 单条查询
	 * @param record
	 * @return
	 */
	FileInfo selectByPrimaryKey(@Param("primaryKey")String primaryKey);
	
	/**
	 * 该接口提供批量查询服务
	 * @Title: queryList
	 * @Description: 批量查询
	 * @param record
	 * @return
	 */
	List<FileInfo> queryList(FileInfo record);	
}