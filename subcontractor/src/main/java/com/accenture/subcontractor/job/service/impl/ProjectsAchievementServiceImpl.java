package com.accenture.subcontractor.job.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.accenture.subcontractor.job.domain.ProjectsAchievement;
import com.accenture.subcontractor.job.persistence.ProjectsAchievementMapper;
import com.accenture.subcontractor.job.service.ProjectsAchievementService;

@Service
@Transactional
public class ProjectsAchievementServiceImpl implements ProjectsAchievementService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	ProjectsAchievementMapper projectsAchievementMapper;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertBatch(List<ProjectsAchievement> projectsAchievementList) {
		try {
			projectsAchievementMapper.insertBatch(projectsAchievementList);
		} catch (Exception e) {
			logger.error("ProjectsAchievementServiceImpl>insertBatch>Exception:" + e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteBatch(List<ProjectsAchievement> recordList) {
		try {
			projectsAchievementMapper.deleteBatch(recordList);
		} catch (Exception e) {
			logger.error("ProjectsAchievementServiceImpl>deleteBatch>Exception:" + e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateBatch(List<ProjectsAchievement> recordList) {
		try {
			projectsAchievementMapper.updateBatch(recordList);
		} catch (Exception e) {
			e.printStackTrace();logger.error("ProjectsAchievementServiceImpl>updateBatch>Exception:" + e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}
	}

}
