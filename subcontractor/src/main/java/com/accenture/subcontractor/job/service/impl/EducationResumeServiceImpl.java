package com.accenture.subcontractor.job.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.accenture.subcontractor.job.domain.AchievementDesc;
import com.accenture.subcontractor.job.domain.Certificate;
import com.accenture.subcontractor.job.domain.EducationResume;
import com.accenture.subcontractor.job.persistence.EducationResumeMapper;
import com.accenture.subcontractor.job.service.AchievementDescService;
import com.accenture.subcontractor.job.service.CertificateService;
import com.accenture.subcontractor.job.service.EducationResumeService;
@Service
public class EducationResumeServiceImpl implements EducationResumeService {
	private final Logger logger =LoggerFactory.getLogger(this.getClass());
	@Resource 
	EducationResumeMapper educationResumeMapper;
	@Resource
	CertificateService certificateService;
	@Resource
	AchievementDescService achievementDescService;
	
	@Override
	public void editBatch(List<EducationResume> recordList) {

		Date date = new Date();
		List<EducationResume> insertList = new ArrayList<EducationResume>();
		List<EducationResume> updateList = new ArrayList<EducationResume>();
		List<EducationResume> deleteList = new ArrayList<EducationResume>();
		List<Certificate> insertCertificateList = new ArrayList<Certificate>();
		List<Certificate> updateCertificateList = new ArrayList<Certificate>();
		List<Certificate> deleteCertificateList = new ArrayList<Certificate>();
		List<AchievementDesc> insertAchievementDescList = new ArrayList<AchievementDesc>();
		List<AchievementDesc> updateAchievementDescList = new ArrayList<AchievementDesc>();
		List<AchievementDesc> deleteAchievementDescList = new ArrayList<AchievementDesc>();
		try {
			for (EducationResume educationResume : recordList) {
				// DeleteFlag 标记：S-软删除;N-未删除;U-更新;Y-物理删除
				if (null == educationResume.getDeleteFlag()) {
					educationResume.setDeleteFlag("N");
					educationResume.setCreateTime(date);
					String resumeId = UUID.randomUUID().toString();
					educationResume.setEducationResumeId(resumeId);
					insertList.add(educationResume);
					if (null != educationResume.getCertificateDescList() && educationResume.getCertificateDescList().size() > 0) {
						for (Certificate certificate : educationResume.getCertificateDescList()) {
							certificate.setDeleteFlag("N");
							certificate.setCertificateId(UUID.randomUUID().toString());
							certificate.setCreateTime(date);
							certificate.setEducationResumeId(resumeId);
							insertCertificateList.add(certificate);
						}
					}
					if (null != educationResume.getAchievementDescList() && educationResume.getAchievementDescList().size() > 0) {
						for (AchievementDesc item : educationResume.getAchievementDescList()) {
							item.setDeleteFlag("N");
							item.setAchievementId(UUID.randomUUID().toString());
							item.setCreateTime(date);
							item.setEducationResumeId(resumeId);
							insertAchievementDescList.add(item);
						}
					}

				} else {
					if (educationResume.getDeleteFlag().equals("Y")) {
						deleteList.add(educationResume);
						if (null != educationResume.getCertificateDescList() && educationResume.getCertificateDescList().size() > 0) {
							deleteCertificateList.addAll(educationResume.getCertificateDescList());
						}
						if (null != educationResume.getAchievementDescList() && educationResume.getAchievementDescList().size() > 0) {
							deleteAchievementDescList.addAll(educationResume.getAchievementDescList());
						}

					} else if (educationResume.getDeleteFlag().equals("U")) {
						educationResume.setDeleteFlag("N");
						educationResume.setLastUpdateTime(date);
						updateList.add(educationResume);
						if (null != educationResume.getCertificateDescList() && educationResume.getCertificateDescList().size() > 0) {
							for (Certificate certificate : educationResume.getCertificateDescList()) {
								if (null == certificate.getDeleteFlag()) {
									certificate.setCertificateId(UUID.randomUUID().toString());
									certificate.setEducationResumeId(educationResume.getEducationResumeId());
									certificate.setDeleteFlag("N");
									certificate.setCreateTime(date);
									insertCertificateList.add(certificate);
								} else {
									if (certificate.getDeleteFlag().equals("U")) {
										certificate.setDeleteFlag("N");
										certificate.setLastUpdateTime(date);
										updateCertificateList.add(certificate);
									} else if (certificate.getDeleteFlag().equals("Y")) {
										deleteCertificateList.add(certificate);
									} else if (certificate.getDeleteFlag().equals("S")) {
										certificate.setDeleteFlag("S");
										updateCertificateList.add(certificate);
									}
								}
							}
						}
						if (null != educationResume.getAchievementDescList() && educationResume.getAchievementDescList().size() > 0) {
							for (AchievementDesc item : educationResume.getAchievementDescList()) {
								if (null == item.getDeleteFlag()) {
									item.setAchievementId(UUID.randomUUID().toString());
									item.setEducationResumeId(educationResume.getEducationResumeId());
									item.setDeleteFlag("N");
									item.setCreateTime(date);
									insertAchievementDescList.add(item);
								} else {
									if (item.getDeleteFlag().equals("U")) {
										item.setDeleteFlag("N");
										item.setLastUpdateTime(date);
										updateAchievementDescList.add(item);
									} else if (item.getDeleteFlag().equals("Y")) {
										deleteAchievementDescList.add(item);
									} else if (item.getDeleteFlag().equals("S")) {
										item.setDeleteFlag("S");
										updateAchievementDescList.add(item);
									}
								}
							}
						}
					} else if (educationResume.getDeleteFlag().equals("S")) {
						educationResume.setDeleteFlag("S");
						updateList.add(educationResume);
						if(null != educationResume.getCertificateDescList() && educationResume.getCertificateDescList().size() > 0){
							for(Certificate certificate:educationResume.getCertificateDescList()){
								certificate.setDeleteFlag("S");
							}
							updateCertificateList.addAll(educationResume.getCertificateDescList());
						}
						if(null != educationResume.getAchievementDescList() && educationResume.getAchievementDescList().size() > 0){
							for(AchievementDesc achievementDesc:educationResume.getAchievementDescList()){
								achievementDesc.setDeleteFlag("S");
							}
							updateAchievementDescList.addAll(educationResume.getAchievementDescList());
						}
					}else if (educationResume.getDeleteFlag().equals("N")) {
						if (null != educationResume.getCertificateDescList() && educationResume.getCertificateDescList().size() > 0) {
							for (Certificate certificate : educationResume.getCertificateDescList()) {
								if (null == certificate.getDeleteFlag()) {
									certificate.setCertificateId(UUID.randomUUID().toString());
									certificate.setEducationResumeId(educationResume.getEducationResumeId());
									certificate.setDeleteFlag("N");
									certificate.setCreateTime(date);
									insertCertificateList.add(certificate);
								} else {
									if (certificate.getDeleteFlag().equals("U")) {
										certificate.setDeleteFlag("N");
										certificate.setLastUpdateTime(date);
										updateCertificateList.add(certificate);
									} else if (certificate.getDeleteFlag().equals("Y")) {
										deleteCertificateList.add(certificate);
									} else if (certificate.getDeleteFlag().equals("S")) {
										certificate.setDeleteFlag("S");
										updateCertificateList.add(certificate);
									}
								}
							}
						}
						if (null != educationResume.getAchievementDescList() && educationResume.getAchievementDescList().size() > 0) {
							for (AchievementDesc item : educationResume.getAchievementDescList()) {
								if (null == item.getDeleteFlag()) {
									item.setAchievementId(UUID.randomUUID().toString());
									item.setEducationResumeId(educationResume.getEducationResumeId());
									item.setDeleteFlag("N");
									item.setCreateTime(date);
									insertAchievementDescList.add(item);
								} else {
									if (item.getDeleteFlag().equals("U")) {
										item.setDeleteFlag("N");
										item.setLastUpdateTime(date);
										updateAchievementDescList.add(item);
									} else if (item.getDeleteFlag().equals("Y")) {
										deleteAchievementDescList.add(item);
									} else if (item.getDeleteFlag().equals("S")) {
										item.setDeleteFlag("S");
										updateAchievementDescList.add(item);
									}
								}
							}
						}
					}
				}
			}
			

			if(deleteAchievementDescList.size()>0){
				achievementDescService.deleteBatch(deleteAchievementDescList);
			}
			if(updateAchievementDescList.size()>0){
				achievementDescService.updateBatch(updateAchievementDescList);
			}
			if(insertAchievementDescList.size()>0){
				achievementDescService.insertBatch(insertAchievementDescList);
			}
			if(deleteCertificateList.size()>0){
				certificateService.deleteBatch(deleteCertificateList);
			}
			if(updateCertificateList.size()>0){
				certificateService.updateBatch(updateCertificateList);
			}
			if(insertCertificateList.size()>0){
				certificateService.insertBatch(insertCertificateList);
			}
			if(deleteList.size()>0){
				educationResumeMapper.deleteBatch(deleteList);
			}
			if(updateList.size()>0){
				educationResumeMapper.updateBatch(updateList);
			}
			if(insertList.size()>0){
				educationResumeMapper.insertBatch(insertList);
			}
		} catch (Exception e) {
			logger.error("WorkResumeServiceImpl>insertBatch>Exception:" + e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}
	
		
	}
	
}
