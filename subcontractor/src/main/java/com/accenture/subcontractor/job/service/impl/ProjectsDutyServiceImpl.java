package com.accenture.subcontractor.job.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.accenture.subcontractor.job.domain.ProjectsDuty;
import com.accenture.subcontractor.job.persistence.ProjectsDutyMapper;
import com.accenture.subcontractor.job.service.ProjectsDutyService;

@Service
@Transactional
public class ProjectsDutyServiceImpl implements ProjectsDutyService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	ProjectsDutyMapper projectsDutyMapper;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertBatch(List<ProjectsDuty> recordList) {
		try {
			projectsDutyMapper.insertBatch(recordList);
		} catch (Exception e) {
			logger.error("ProjectsDutyServiceImpl>insertBatch>Exception:" + e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}
	}
}
