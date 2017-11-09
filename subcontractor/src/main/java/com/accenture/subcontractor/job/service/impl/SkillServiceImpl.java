package com.accenture.subcontractor.job.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.accenture.subcontractor.job.domain.Skill;
import com.accenture.subcontractor.job.persistence.SkillMapper;
import com.accenture.subcontractor.job.service.SkillService;

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
}