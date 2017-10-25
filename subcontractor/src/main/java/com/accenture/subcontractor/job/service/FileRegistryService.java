package com.accenture.subcontractor.job.service;

import java.util.List;

import com.accenture.subcontractor.job.domain.FileRegistry;
import com.accenture.subcontractor.job.domain.condition.FileRegistryConditon;
import com.github.pagehelper.PageInfo;

public interface FileRegistryService {

	/**
	 * @Title: insert
	 * @Description: TODO
	 * @param FileRegistry
	 * @return
	 */
	void insert(FileRegistry record);

	/**
	 * @Title: insertSelective
	 * @Description: TODO
	 * @param FileRegistry
	 * @return
	 */
	void insertSelective(FileRegistry record);

	/**
	 * 
	 * @Title: insertBatch
	 * @Description: TODO
	 * @param record
	 */
	void insertBatch(List<FileRegistry> record);

	/**
	 * @Title: deleteByPrimaryKey
	 * @Description: TODO
	 * @param fileId
	 */
	void deleteByPrimaryKey(String id);

	/**
	 * 
	 * @Title: deleteByPrimaryKeyS
	 * @Description: TODO
	 * @param id
	 */
	void deleteByPrimaryKeySoft(String id);

	/**
	 * 
	 * @Title: deleteList
	 * @Description: TODO
	 * @param record
	 */
	void deleteList(List<FileRegistry> record);

	/**
	 * 
	 * @Title: deleteListSoft
	 * @Description: TODO
	 * @param record
	 */
	void deleteListSoft(List<FileRegistry> record);

	/**
	 * @Title: updateByPrimaryKey
	 * @Description: TODO
	 * @param FileRegistry
	 */
	void updateByPrimaryKey(FileRegistry record);

	/**
	 * @Title: updateByPrimaryKeySelective
	 * @Description: TODO
	 * @param FileRegistry
	 */
	void updateByPrimaryKeySelective(FileRegistry record);

	/**
	 * 
	 * @Title: updateBatch
	 * @Description: TODO
	 * @param record
	 */
	void updateList(List<FileRegistry> record);

	/**
	 * @Title: selectByPrimaryKey
	 * @Description: TODO
	 * @param fileId
	 * @return
	 */
	FileRegistry selectByPrimaryKey(String id);

	/**
	 * @Title: queryList
	 * @Description: TODO
	 * @param FileRegistry
	 * @return
	 * @throws Exception
	 */
	PageInfo<FileRegistry> queryList(FileRegistryConditon FileRegistryConditon) throws Exception;
}
