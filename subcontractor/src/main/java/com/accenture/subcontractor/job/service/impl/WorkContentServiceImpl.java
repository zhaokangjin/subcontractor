package com.accenture.subcontractor.job.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.accenture.subcontractor.job.domain.WorkContent;
import com.accenture.subcontractor.job.persistence.WorkContentMapper;
import com.accenture.subcontractor.job.service.WorkContentService;

@Service
@Transactional
public class WorkContentServiceImpl implements WorkContentService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	WorkContentMapper workContentMapper;
	@Override
	public void deleteBatch(List<WorkContent> recordList) {
		workContentMapper.deleteBatch(recordList);
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void insertBatch(List<WorkContent> recordList) {
		try {
			workContentMapper.insertBatch(recordList);
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			logger.error("WorkContentServiceImpl>insertBatch>Exception:"+e);
			throw e;
		}
	}
	@Override
	public void updateBatch(List<WorkContent> recordList) {
		workContentMapper.insertBatch(recordList);
	}

}
