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

import com.accenture.subcontractor.job.domain.WorkContent;
import com.accenture.subcontractor.job.domain.WorkResume;
import com.accenture.subcontractor.job.persistence.WorkResumeMapper;
import com.accenture.subcontractor.job.service.WorkContentService;
import com.accenture.subcontractor.job.service.WorkResumeService;

@Service
@Transactional
public class WorkResumeServiceImpl implements WorkResumeService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	WorkResumeMapper workResumeMapper;
	@Resource
	WorkContentService workContentService;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void editBatch(List<WorkResume> workResumeList) {
		Date date = new Date();
		List<WorkResume> insertList = new ArrayList<WorkResume>();
		List<WorkResume> updateList = new ArrayList<WorkResume>();
		List<WorkResume> deleteList = new ArrayList<WorkResume>();
		List<WorkContent> insertChildList = new ArrayList<WorkContent>();
		List<WorkContent> updateChildList = new ArrayList<WorkContent>();
		List<WorkContent> deleteChildList = new ArrayList<WorkContent>();
		try {
			for (WorkResume workResume : workResumeList) {
				// DeleteFlag 标记：S-软删除;N-未删除;U-更新;Y-物理删除
				if (null == workResume.getDeleteFlag()) {
					workResume.setDeleteFlag("N");
					workResume.setCreateTime(date);
					String resumeId = UUID.randomUUID().toString();
					workResume.setResumeId(resumeId);
					insertList.add(workResume);
					if (null != workResume.getWorkContentList() && workResume.getWorkContentList().size() > 0) {
						for (WorkContent workContent : workResume.getWorkContentList()) {
							workContent.setDeleteFlag("N");
							workContent.setContentId(UUID.randomUUID().toString());
							workContent.setCreateTime(date);
							workContent.setResumeId(resumeId);
							insertChildList.add(workContent);
						}
					}

				} else {
					if (workResume.getDeleteFlag().equals("Y")) {
						deleteList.add(workResume);
						if (null != workResume.getWorkContentList() && workResume.getWorkContentList().size() > 0) {
							deleteChildList.addAll(workResume.getWorkContentList());
						}

					} else if (workResume.getDeleteFlag().equals("U")) {
						workResume.setDeleteFlag("N");
						workResume.setLastUpdateTime(date);
						updateList.add(workResume);
						if (null != workResume.getWorkContentList() && workResume.getWorkContentList().size() > 0) {
							for (WorkContent workContent : workResume.getWorkContentList()) {
								if (null == workContent.getDeleteFlag()) {
									workContent.setContentId(UUID.randomUUID().toString());
									workContent.setResumeId(workResume.getResumeId());
									workContent.setDeleteFlag("N");
									workContent.setCreateTime(date);
									insertChildList.add(workContent);
								} else {
									if (workContent.getDeleteFlag().equals("U")) {
										workContent.setDeleteFlag("N");
										workContent.setLastUpdateTime(date);
										updateChildList.add(workContent);
									} else if (workContent.getDeleteFlag().equals("Y")) {
										deleteChildList.add(workContent);
									} else if (workContent.getDeleteFlag().equals("S")) {
										workContent.setDeleteFlag("S");
										updateChildList.add(workContent);
									}
								}
							}
						}
					} else if (workResume.getDeleteFlag().equals("S")) {
						workResume.setDeleteFlag("S");
						if(null != workResume.getWorkContentList() && workResume.getWorkContentList().size() > 0){
							updateList.add(workResume);
						}
					}else if (workResume.getDeleteFlag().equals("N")) {
						if (null != workResume.getWorkContentList() && workResume.getWorkContentList().size() > 0) {
							for (WorkContent workContent : workResume.getWorkContentList()) {
								if (null == workContent.getDeleteFlag()) {
									workContent.setContentId(UUID.randomUUID().toString());
									workContent.setResumeId(workResume.getResumeId());
									workContent.setDeleteFlag("N");
									workContent.setCreateTime(date);
									insertChildList.add(workContent);
								} else {
									if (workContent.getDeleteFlag().equals("U")) {
										workContent.setDeleteFlag("N");
										workContent.setLastUpdateTime(date);
										updateChildList.add(workContent);
									} else if (workContent.getDeleteFlag().equals("Y")) {
										deleteChildList.add(workContent);
									} else if (workContent.getDeleteFlag().equals("S")) {
										workContent.setDeleteFlag("S");
										updateChildList.add(workContent);
									}
								}
							}
						}
					}
				}
			}
			if(deleteChildList.size()>0){
				workContentService.deleteBatch(deleteChildList);
			}
			if(updateChildList.size()>0){
				workContentService.updateBatch(updateChildList);
			}
			if(insertChildList.size()>0){
				workContentService.insertBatch(insertChildList);
			}
			if(deleteList.size()>0){
				workResumeMapper.deleteBatch(deleteList);
			}
			if(updateList.size()>0){
				workResumeMapper.updateBatch(updateList);
			}
			if(insertList.size()>0){
				workResumeMapper.insertBatch(insertList);
			}
		} catch (Exception e) {
			logger.error("WorkResumeServiceImpl>insertBatch>Exception:" + e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}
	}
}
