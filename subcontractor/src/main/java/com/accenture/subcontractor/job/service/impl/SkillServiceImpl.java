package com.accenture.subcontractor.job.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.accenture.subcontractor.job.common.util.data.PageUtils;
import com.accenture.subcontractor.job.domain.Skill;
import com.accenture.subcontractor.job.domain.condition.SkillCondition;
import com.accenture.subcontractor.job.persistence.SkillMapper;
import com.accenture.subcontractor.job.service.SkillService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {
	public static Logger logger = LoggerFactory.getLogger(SkillServiceImpl.class);
	@Resource
	SkillMapper skillMapper;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteBatch(List<Skill> recordList) {
		try {
			skillMapper.deleteBatch(recordList);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("SkillServiceImpl>deleteBatch>Exception:"+e);
			throw e;
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteByPrimaryKey(String id) {
		try {
			skillMapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("SkillServiceImpl>deleteByPrimaryKey>Exception:"+e);
			throw e;
		}

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insert(Skill record) {
		try {
			skillMapper.insert(record);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("SkillServiceImpl>insert>Exception:"+e);
			throw e;
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertBatch(List<Skill> recordList) {
		try {
			skillMapper.insertBatch(recordList);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("SkillServiceImpl>insertBatch>Exception:"+e);
			throw e;
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertSelective(Skill record) {
		try {
			skillMapper.insertSelective(record);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("SkillServiceImpl>insertSelective>Exception:"+e);
			throw e;
		}
	}

	@Override
	public Skill selectByPrimaryKey(Skill record) {
		try {
			skillMapper.updateByPrimaryKeySelective(record);
		} catch (Exception e) {
			logger.error("SkillServiceImpl>selectByPrimaryKey>Exception:"+e);
			throw e;
		}
		return null;
	}
	@Override
	public PageInfo<Skill> selectByUserId(SkillCondition skillCondition){
		try {
			PageUtils.setPageByCondition(skillCondition);
			List<Skill> list= skillMapper.selectByUserId(skillCondition.getSkill().getUserId());
			PageInfo<Skill> pageData = new PageInfo<Skill>(list);
			logger.error("SkillTypeServiceImpl>pageData>list:"+JSON.toJSONString(list));
			return pageData;
		} catch (Exception e) {
			logger.error("SkillServiceImpl>selectByUserId>Exception:"+e);
			throw e;
		}
	}
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateBatch(Skill record) {
		try {
			skillMapper.updateByPrimaryKeySelective(record);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("SkillServiceImpl>updateBatch>Exception:"+e);
			throw e;
		}
	}
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertOrUpdate(List<Skill> recordList) {
		try {
			if(null!=recordList){
				Date date=new Date();
				List<Skill> deleteRecords=new ArrayList<Skill>();
				List<Skill> insertRecords=new ArrayList<Skill>();
				List<Skill> updateRecords=new ArrayList<Skill>();
				for(Skill record:recordList){
					if(null!=record.getDeleteFlag()&& record.getDeleteFlag().equals("Y")){
						deleteRecords.add(record);
					}else if(null!=record.getDeleteFlag()&& record.getDeleteFlag().equals("U")&&null!=record.getUserId()){
						record.setDeleteFlag("N");
						record.setLastUpdateTime(date);
						updateRecords.add(record);
					}else if(null==record.getDeleteFlag()){
						record.setDeleteFlag("N");
						record.setProfessionSkillId(UUID.randomUUID().toString());
						record.setCreateTime(date);
						insertRecords.add(record);
					}
				}
				if(deleteRecords.size()>0){
					skillMapper.deleteBatch(deleteRecords);
				}
				if(insertRecords.size()>0){
					skillMapper.insertBatch(insertRecords);
				}
				if(updateRecords.size()>0){
					skillMapper.updateBatch(updateRecords);
				}
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("SkillServiceImpl>updateBatch>Exception:"+e);
			throw e;
		}
	}
}
