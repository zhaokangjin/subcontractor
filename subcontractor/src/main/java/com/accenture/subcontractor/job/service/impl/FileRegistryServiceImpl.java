package com.accenture.subcontractor.job.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.accenture.subcontractor.job.common.util.data.PageUtils;
import com.accenture.subcontractor.job.domain.FileRegistry;
import com.accenture.subcontractor.job.domain.condition.FileRegistryConditon;
import com.accenture.subcontractor.job.persistence.FileInfoMapper;
import com.accenture.subcontractor.job.persistence.FileRegistryMapper;
import com.accenture.subcontractor.job.service.FileRegistryService;
import com.github.pagehelper.PageInfo;
@Service
public class FileRegistryServiceImpl implements FileRegistryService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	FileInfoMapper fileInfoMapper;
	@Resource
	FileRegistryMapper fileRegistryMapper;
	
	@Override
	public void insert(FileRegistry record){
		try {
			fileRegistryMapper.insert(record);
		} catch (Exception e) {
			logger.error("FileInfoServiceImpl>>>insert>>>error:"+e.getMessage());
			throw e;
		}
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void insertSelective(FileRegistry record){
		try {
			fileRegistryMapper.insertSelective(record);
		} catch (Exception e) {
			logger.error("FileInfoServiceImpl>>>insertSelective>>>error:"+e.getMessage());
			throw e;
		}
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void insertBatch(List<FileRegistry> record) {
		try {
			fileRegistryMapper.insertBatch(record);
		} catch (Exception e) {
			logger.error("FileInfoServiceImpl>>>insertBatch>>>error:"+e);
			//异常回滚
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}
	}	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteByPrimaryKey(String id){
		try {
			fileRegistryMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("FileInfoServiceImpl>>>deleteByPrimaryKey>>>error:"+e.getMessage());
			throw e;
		}
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteByPrimaryKeySoft(String id) {
		try {
			fileRegistryMapper.deleteByPrimaryKeySoft(id);
		} catch (Exception e) {
			logger.error("FileInfoServiceImpl>>>deleteByPrimaryKey>>>error:"+e.getMessage());
			throw e;
		}	
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteList(List<FileRegistry> record) {
		try {
			fileRegistryMapper.deleteList(record);
		} catch (Exception e) {
			logger.error("FileInfoServiceImpl>>>insertBatch>>>error:"+e);
			throw e;
		}
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteListSoft(List<FileRegistry> record) {
		try {
			fileRegistryMapper.deleteListSoft(record);
		} catch (Exception e) {
			logger.error("FileInfoServiceImpl>>>insertBatch>>>error:"+e);
			throw e;
		}
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public void updateByPrimaryKey(FileRegistry fileInfo) {
		try {
			fileRegistryMapper.updateByPrimaryKey(fileInfo);
		} catch (Exception e) {
			logger.error("FileInfoServiceImpl>>>updateByPrimaryKey>>>error:"+e.getMessage());
			throw e;
		}
		
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void updateByPrimaryKeySelective(FileRegistry fileInfo) {
		try {
			fileRegistryMapper.updateByPrimaryKeySelective(fileInfo);
		} catch (Exception e) {
			logger.error("FileInfoServiceImpl>>>updateByPrimaryKeySelective>>>error:"+e.getMessage());
			throw e;
		}
		
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void updateList(List<FileRegistry> record) {
		if(null==record || record.size()==0){
			return;
		}
		try {
			fileRegistryMapper.updateList(record);
		} catch (Exception e) {
			logger.error("FileInfoServiceImpl>>>updateBatch>>>error:"+e.getMessage());
			throw e;
		}
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public FileRegistry selectByPrimaryKey(String primaryKey) {
		try {
			return fileRegistryMapper.selectByPrimaryKey(primaryKey);
		} catch (Exception e) {
			logger.error("FileInfoServiceImpl>>>selectByPrimaryKey>>>error:"+e.getMessage());
			throw e;
		}
	}
	@Override
	public PageInfo<FileRegistry> queryList(FileRegistryConditon  recordConditon) throws Exception {
		try {
			FileRegistry fileInfo=recordConditon.getFileRegistry();
			//设置分页
			PageUtils.setPageByCondition(recordConditon);
			List<FileRegistry> list= fileRegistryMapper.queryList(fileInfo);
			PageInfo<FileRegistry> pageData = new PageInfo<FileRegistry>(list);
			return pageData;
		} catch (Exception e) {
			logger.error("FileInfoServiceImpl>>>queryList>>>error:"+e.getMessage());
			throw e;
		}
	}

}
