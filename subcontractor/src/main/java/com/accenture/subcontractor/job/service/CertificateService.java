package com.accenture.subcontractor.job.service;

import java.util.List;

import com.accenture.subcontractor.job.domain.Certificate;

public interface CertificateService {

	public abstract void insertBatch(List<Certificate> recordList);

}
