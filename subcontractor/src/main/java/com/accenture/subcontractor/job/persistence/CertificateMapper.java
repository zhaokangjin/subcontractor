package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.Certificate;

public interface CertificateMapper {
	int deleteByPrimaryKey(String certificateId);

	int insert(Certificate record);

	int insertSelective(Certificate record);

	Certificate selectByPrimaryKey(String certificateId);

	int updateByPrimaryKeySelective(Certificate record);

	int updateByPrimaryKey(Certificate record);

	void insertBatch(List<Certificate> recordList);

	void deleteBatch(List<Certificate> recordList);

	void updateBatch(List<Certificate> recordList);
}