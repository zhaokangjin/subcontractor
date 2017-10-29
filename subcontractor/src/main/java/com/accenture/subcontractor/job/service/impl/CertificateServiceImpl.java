package com.accenture.subcontractor.job.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.accenture.subcontractor.job.domain.Certificate;
import com.accenture.subcontractor.job.persistence.CertificateMapper;
import com.accenture.subcontractor.job.service.CertificateService;

@Service
@Transactional
public class CertificateServiceImpl implements CertificateService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	CertificateMapper certificateMapper;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertBatch(List<Certificate> recordList) {
		try {
			certificateMapper.insertBatch(recordList);
		} catch (Exception e) {
			logger.error("CertificateServiceImpl>insertBatch>Exception:" + e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}
	}

	@Override
	public void deleteBatch(List<Certificate> recordList) {
		try {
			certificateMapper.deleteBatch(recordList);
		} catch (Exception e) {
			logger.error("CertificateServiceImpl>deleteBatch>Exception:" + e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}
	}

	@Override
	public void updateBatch(List<Certificate> recordList) {
		try {
			certificateMapper.updateBatch(recordList);
		} catch (Exception e) {
			logger.error("CertificateServiceImpl>updateBatch>Exception:" + e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}
	}
}
