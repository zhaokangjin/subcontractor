package com.accenture.subcontractor.job.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.accenture.subcontractor.job.domain.AchievementDesc;
import com.accenture.subcontractor.job.domain.Certificate;
import com.accenture.subcontractor.job.domain.EducationResume;
import com.accenture.subcontractor.job.persistence.EducationResumeMapper;
import com.accenture.subcontractor.job.service.AchievementDescService;
import com.accenture.subcontractor.job.service.CertificateService;
import com.accenture.subcontractor.job.service.EducationResumeService;

@Service
@Transactional
public class EducationResumeServiceImpl implements EducationResumeService {
	private static Logger logger = LoggerFactory.getLogger(EducationResumeServiceImpl.class);
	@Resource
	EducationResumeMapper educationResumeMapper;
	@Resource
	CertificateService certificateService;
	@Resource
	AchievementDescService achievementDescService;

	@Override
	@Transactional(rollbackFor=Exception.class)
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
					insertOwnAndSon(date, insertList, insertCertificateList, insertAchievementDescList,
							educationResume);
				} else {
					if (educationResume.getDeleteFlag().equals("Y")) {
						deleteOwnAndSon(deleteList, deleteCertificateList, deleteAchievementDescList, educationResume);

					} else if (educationResume.getDeleteFlag().equals("U")) {
						updateOwnAndSon(date, updateList, insertCertificateList, updateCertificateList,
								deleteCertificateList, insertAchievementDescList, updateAchievementDescList,
								deleteAchievementDescList, educationResume);
					} else if (educationResume.getDeleteFlag().equals("S")) {
						softDeleteOwnAndSon(updateList, updateCertificateList, updateAchievementDescList,
								educationResume);
					} else if (educationResume.getDeleteFlag().equals("N")) {
						updateOnlySon(date, insertCertificateList, updateCertificateList, deleteCertificateList,
								insertAchievementDescList, updateAchievementDescList, deleteAchievementDescList,
								educationResume);
					}
				}
			}
			editOwnAndSon(insertList, updateList, deleteList, insertCertificateList, updateCertificateList,
					deleteCertificateList, insertAchievementDescList, updateAchievementDescList,
					deleteAchievementDescList);
		} catch (Exception e) {
			logger.error("WorkResumeServiceImpl>insertBatch>Exception:" + e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}
	}

	/*
	 * 最后批量更新，目的提高大数据更新的效率
	 */
	private void editOwnAndSon(
			List<EducationResume> insertList, 
			List<EducationResume> updateList,
			List<EducationResume> deleteList, 
			List<Certificate> insertCertificateList,
			List<Certificate> updateCertificateList, 
			List<Certificate> deleteCertificateList,
			List<AchievementDesc> insertAchievementDescList, 
			List<AchievementDesc> updateAchievementDescList,
			List<AchievementDesc> deleteAchievementDescList) {
		if (deleteAchievementDescList.size() > 0) {
			achievementDescService.deleteBatch(deleteAchievementDescList);
		}
		if (updateAchievementDescList.size() > 0) {
			achievementDescService.updateBatch(updateAchievementDescList);
		}
		if (insertAchievementDescList.size() > 0) {
			achievementDescService.insertBatch(insertAchievementDescList);
		}
		if (deleteCertificateList.size() > 0) {
			certificateService.deleteBatch(deleteCertificateList);
		}
		if (updateCertificateList.size() > 0) {
			certificateService.updateBatch(updateCertificateList);
		}
		if (insertCertificateList.size() > 0) {
			certificateService.insertBatch(insertCertificateList);
		}
		if (deleteList.size() > 0) {
			educationResumeMapper.deleteBatch(deleteList);
		}
		if (updateList.size() > 0) {
			educationResumeMapper.updateBatch(updateList);
		}
		if (insertList.size() > 0) {
			educationResumeMapper.insertBatch(insertList);
		}
	}

	/*
	 * 当前记录不变，调用子表，依次分类检查子记录，并编辑自己录
	 */
	private void updateOnlySon(
			Date date, 
			List<Certificate> insertCertificateList,
			List<Certificate> updateCertificateList, 
			List<Certificate> deleteCertificateList,
			List<AchievementDesc> insertAchievementDescList, 
			List<AchievementDesc> updateAchievementDescList,
			List<AchievementDesc> deleteAchievementDescList, 
			EducationResume educationResume) {
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

	/*
	 * 当前记录软删除，业务规则所属子记录全部软删除
	 */
	private void softDeleteOwnAndSon(
			List<EducationResume> updateList, 
			List<Certificate> updateCertificateList,
			List<AchievementDesc> updateAchievementDescList, 
			EducationResume educationResume) {
		educationResume.setDeleteFlag("S");
		updateList.add(educationResume);
		if (null != educationResume.getCertificateDescList() && educationResume.getCertificateDescList().size() > 0) {
			for (Certificate certificate : educationResume.getCertificateDescList()) {
				certificate.setDeleteFlag("S");
			}
			updateCertificateList.addAll(educationResume.getCertificateDescList());
		}
		if (null != educationResume.getAchievementDescList() && educationResume.getAchievementDescList().size() > 0) {
			for (AchievementDesc achievementDesc : educationResume.getAchievementDescList()) {
				achievementDesc.setDeleteFlag("S");
			}
			updateAchievementDescList.addAll(educationResume.getAchievementDescList());
		}
	}

	/*
	 * 更新当前记录，直接子表所有记录一起更新
	 */
	private void updateOwnAndSon(
			Date date, List<EducationResume> updateList, 
			List<Certificate> insertCertificateList,
			List<Certificate> updateCertificateList, 
			List<Certificate> deleteCertificateList,
			List<AchievementDesc> insertAchievementDescList, 
			List<AchievementDesc> updateAchievementDescList,
			List<AchievementDesc> deleteAchievementDescList, 
			EducationResume educationResume) {
		educationResume.setDeleteFlag("N");
		educationResume.setLastUpdateTime(date);
		updateList.add(educationResume);
		updateOnlySon(date, insertCertificateList, updateCertificateList, deleteCertificateList,
				insertAchievementDescList, updateAchievementDescList, deleteAchievementDescList, educationResume);
	}

	/*
	 * 物理删除当前记录，则所有直接关联的子记录也物理删除
	 */
	private void deleteOwnAndSon(
			List<EducationResume> deleteList, 
			List<Certificate> deleteCertificateList,
			List<AchievementDesc> deleteAchievementDescList, 
			EducationResume educationResume) {
		deleteList.add(educationResume);
		if (null != educationResume.getCertificateDescList() && educationResume.getCertificateDescList().size() > 0) {
			deleteCertificateList.addAll(educationResume.getCertificateDescList());
		}
		if (null != educationResume.getAchievementDescList() && educationResume.getAchievementDescList().size() > 0) {
			deleteAchievementDescList.addAll(educationResume.getAchievementDescList());
		}
	}

	/*
	 * 插入一条心记录，则所有的子记录也一起插入
	 */
	private void insertOwnAndSon(
			Date date, 
			List<EducationResume> insertList, 
			List<Certificate> insertCertificateList,
			List<AchievementDesc> insertAchievementDescList, 
			EducationResume educationResume) {
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
	}

}
