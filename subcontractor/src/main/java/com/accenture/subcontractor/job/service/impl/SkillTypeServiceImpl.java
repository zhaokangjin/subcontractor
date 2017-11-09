package com.accenture.subcontractor.job.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.subcontractor.job.common.util.data.PageUtils;
import com.accenture.subcontractor.job.domain.SkillType;
import com.accenture.subcontractor.job.domain.condition.SkillTypeConditon;
import com.accenture.subcontractor.job.persistence.SkillTypeMapper;
import com.accenture.subcontractor.job.service.SkillTypeService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class SkillTypeServiceImpl implements SkillTypeService {
	private static Logger logger = LoggerFactory.getLogger(SkillTypeServiceImpl.class);
	@Resource
	SkillTypeMapper skillTypeMapper;
	
	@Override
	public SkillType selectByPrimaryKey(String skillId) {
		try {
			SkillType skillType=skillTypeMapper.selectByPrimaryKey(skillId);
			logger.error("SkillTypeServiceImpl>selectByPrimaryKey>skillType:"+JSON.toJSONString(skillType));
			return skillType;
		} catch (Exception e) {
			logger.error("SkillTypeServiceImpl>selectByPrimaryKey>Exception:"+e);
			throw e;
		}
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void deleteBatch(List<SkillType> recordList) {
		try {
			skillTypeMapper.deleteBatch(recordList);
		} catch (Exception e) {
			logger.error("SkillTypeServiceImpl>deleteBatch>Exception:"+e);
			throw e;
		}
		
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void insertBatch(List<SkillType> recordList) {
		try {
			skillTypeMapper.insertBatch(recordList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void insert(SkillType record) {
		skillTypeMapper.insert(record);
		
	}
	@Override
	public PageInfo<SkillType> queryList(SkillTypeConditon skillTypeConditon){
		try {
			SkillType skillType=skillTypeConditon.getSkillTyp();
			PageUtils.setPageByCondition(skillTypeConditon);
			List<SkillType> list= skillTypeMapper.queryList(skillType);
			PageInfo<SkillType> pageData = new PageInfo<SkillType>(list);
			logger.error("SkillTypeServiceImpl>pageData>list:"+JSON.toJSONString(list));
			return pageData;
		} catch (Exception e) {
			logger.error("SkillTypeServiceImpl>queryList>Exception:"+e);
			throw e;
		}
	}
//	public PageInfo<FileInfo> queryList(FileInfoConditon  fileInfoConditon) throws Exception {
//	try {
//		FileInfo fileInfo=fileInfoConditon.getFileInfo();
//		PageUtils.setPageByCondition(fileInfoConditon);
//		List<FileInfo> list= fileInfoMapper.queryList(fileInfo);
//		PageInfo<FileInfo> pageData = new PageInfo<FileInfo>(list);
//		return pageData;
//	} catch (Exception e) {
//		logger.error("FileInfoServiceImpl>>>queryList>>>error:"+e.getMessage());
//		throw e;
//	}
//}
}
