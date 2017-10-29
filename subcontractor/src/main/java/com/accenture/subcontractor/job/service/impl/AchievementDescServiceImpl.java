package com.accenture.subcontractor.job.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.accenture.subcontractor.job.domain.AchievementDesc;
import com.accenture.subcontractor.job.persistence.AchievementDescMapper;
import com.accenture.subcontractor.job.service.AchievementDescService;

@Service
@Transactional
public class AchievementDescServiceImpl implements AchievementDescService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	AchievementDescMapper achievementDescMapper;

	@Override
	public void insertBatch(List<AchievementDesc> recordList) {
		try {
			achievementDescMapper.insertBatch(recordList);
		} catch (Exception e) {
			logger.error("AchievementDescServiceImpl>insertBatch>Exception:" + e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}
	}

	@Override
	public void deleteBatch(List<AchievementDesc> recordList) {
		try {
			achievementDescMapper.deleteBatch(recordList);
		} catch (Exception e) {
			logger.error("AchievementDescServiceImpl>insertBatch>Exception:" + e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}
	}

	@Override
	public void updateBatch(List<AchievementDesc> recordList) {
		try {
			achievementDescMapper.updateBatch(recordList);
		} catch (Exception e) {
			logger.error("AchievementDescServiceImpl>insertBatch>Exception:" + e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}
	}
}
