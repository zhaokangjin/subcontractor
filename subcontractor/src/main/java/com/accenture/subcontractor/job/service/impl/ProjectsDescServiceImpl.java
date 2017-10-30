package com.accenture.subcontractor.job.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.accenture.subcontractor.job.domain.ProjectsDesc;
import com.accenture.subcontractor.job.persistence.ProjectsDescMapper;
import com.accenture.subcontractor.job.service.ProjectsDescService;

@Service
@Transactional
public class ProjectsDescServiceImpl implements ProjectsDescService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	ProjectsDescMapper projectsDescMapper;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertBatch(List<ProjectsDesc> projectsDescList) {
		try {
			projectsDescMapper.insertBatch(projectsDescList);
		} catch (Exception e) {
			logger.error("ProjectsDescServiceImplinsertBatch>Exception:" + e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}
	}

	@Override
	public void deleteBatch(List<ProjectsDesc> recordList) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBatch(List<ProjectsDesc> recordList) {
		// TODO Auto-generated method stub
		
	}
}
