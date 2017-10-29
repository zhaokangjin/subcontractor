package com.accenture.subcontractor.job.service;

import java.util.List;

import com.accenture.subcontractor.job.domain.Certificate;

public interface CertificateService {

	public abstract void deleteBatch(List<Certificate> recordList) ;
	public abstract void insertBatch(List<Certificate> recordList) ;
	public abstract void updateBatch(List<Certificate> recordList) ;

}
