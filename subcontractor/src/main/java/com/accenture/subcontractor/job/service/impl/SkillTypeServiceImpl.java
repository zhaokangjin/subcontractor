package com.accenture.subcontractor.job.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.accenture.subcontractor.job.common.util.data.PageUtils;
import com.accenture.subcontractor.job.domain.SkillType;
import com.accenture.subcontractor.job.domain.StatusCode;
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
	public List<SkillType> selectSkillTypeByName(String skillName) {
		try {
			List<SkillType> skillTypeList=skillTypeMapper.selectSkillTypeByName(skillName);
			logger.error("SkillTypeServiceImpl>selectByPrimaryKey>skillType:"+JSON.toJSONString(skillTypeList));
			return skillTypeList;
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
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("SkillTypeServiceImpl>insertBatch>Exception:"+e);
			throw e;
		}
		
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public StatusCode insert(SkillType record) {
		try {
			skillTypeMapper.insert(record);
			StatusCode statusCode=new StatusCode();
			statusCode.setCode("OK");
			statusCode.setStatus("200");
			return statusCode;
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("SkillTypeServiceImpl>insert>Exception:"+e);
			throw e;
		}
	}

	@Override
	public List<SkillType> queryListByIds(List<SkillType> recordList) {
		logger.error("SkillTypeServiceImpl>listSkillByIDs>recordList:"+JSON.toJSONString(recordList));
		try {
			List<SkillType> list= skillTypeMapper.queryListByIds(recordList);
			return list;
		} catch (Exception e) {
			logger.error("SkillTypeServiceImpl>listSkillByIDs>Exception:"+e);
			throw e;
		}
	}
	@Override
	public List<SkillType> listChildSkill(String skillId){
		try {
			List<SkillType> list= skillTypeMapper.listChildSkill(skillId);
			return list;
		} catch (Exception e) {
			logger.error("SkillTypeServiceImpl>queryList>Exception:"+e);
			throw e;
		}
	}
	@Override
	public PageInfo<SkillType>  querySkillRootList(SkillTypeConditon skillTypeConditon){
		try {
			SkillType skillType=skillTypeConditon.getSkillTyp();
			PageUtils.setPageByCondition(skillTypeConditon);
			List<SkillType> list= skillTypeMapper.querySkillRootList(skillType);
			PageInfo<SkillType> pageData = new PageInfo<SkillType>(list);
			logger.error("SkillTypeServiceImpl>pageData>list:"+JSON.toJSONString(list));
			return pageData;
		} catch (Exception e) {
			logger.error("SkillTypeServiceImpl>queryList>Exception:"+e);
			throw e;
		}
	}
	@Override
	@Transactional
	public StatusCode insertOrUpdate(List<SkillType> recordList){
		try {
			if(null!=recordList && recordList.size()>0){
				for(SkillType record:recordList){
					if(null!=record.getSkillId()){
						skillTypeMapper.updateByPrimaryKey(record);
					}else if(null==record.getSkillId()&&null!=record.getSkillName()){
						List<SkillType> upList=skillTypeMapper.selectSkillTypeByName(record.getSkillName());
						if(null!=upList){
							int i=0;
							for(SkillType up:upList){
								if(record.getSkillName().equals(up.getSkillName())){
									i++;
									break;
								}
							}
							if(i==0){
								record.setSkillId(UUID.randomUUID().toString());
								skillTypeMapper.insert(record);
							}
						}else{
							record.setSkillId(UUID.randomUUID().toString());
							skillTypeMapper.insert(record);
						}
					}
				}	
			}
			StatusCode statusCode=new StatusCode();
			statusCode.setCode("OK");
			statusCode.setStatus("200");
			return statusCode;
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("SkillTypeServiceImpl>insertOrUpdate>Exception:"+e);
			throw e;
		}
	}
}
