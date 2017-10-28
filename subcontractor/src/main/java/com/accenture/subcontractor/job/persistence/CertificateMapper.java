package com.accenture.subcontractor.job.persistence;

import java.util.List;

import com.accenture.subcontractor.job.domain.Certificate;

public interface CertificateMapper {
	public abstract int deleteByPrimaryKey(String certificateId);

	public abstract int insert(Certificate record);

	public abstract int insertSelective(Certificate record);

	public abstract Certificate selectByPrimaryKey(String certificateId);

	public abstract int updateByPrimaryKeySelective(Certificate record);

	public abstract int updateByPrimaryKey(Certificate record);

	public abstract int insertBatch(List<Certificate> recordList);

	public abstract int updateBatch(List<Certificate> recordList);

	public abstract int deleteBatch(List<Certificate> recordList);
}