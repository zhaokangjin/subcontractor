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
	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	@Resource
	WorkResumeMapper workResumeMapper;
	@Resource
	WorkContentService workContentService;
	@Override
	@Transactional(rollbackFor=Exception.class)
	public void insertBatch(List<WorkResume> workResumeList) {
		try {
			List<WorkResume> insertList=new ArrayList<WorkResume>();
			List<WorkResume> updateList=new ArrayList<WorkResume>();
			List<WorkResume> deleteList=new ArrayList<WorkResume>();
			for(WorkResume workResume:workResumeList){
				if(null==workResume.getDeleteFlag()){
					workResume.setDeleteFlag("N");
					workResume.setCreateTime(new Date());
					workResume.setResumeId(UUID.randomUUID().toString());
					insertList.add(workResume);
					for(WorkContent workContent:workResume.getWorkContentList()){
						
					}
				}
				if(null!=workResume.getDeleteFlag()&&workResume.getDeleteFlag().equals("Y")){
					deleteList.add(workResume);
				}
				if(null!=workResume.getDeleteFlag()&&workResume.getDeleteFlag().equals("U")){
					updateList.add(workResume);
				}
			}
			
			workResumeMapper.insertBatch(workResumeList);
			List<WorkContent> insertChildList=new ArrayList<WorkContent>();
			List<WorkContent> updateChildList=new ArrayList<WorkContent>();
			List<WorkContent> deleteChildList=new ArrayList<WorkContent>();
			WorkResume workResume=null;
			for(int i=0;i<workResumeList.size();i++){
//				workResumeList.get(i).getd
			}
		} catch (Exception e) {
			logger.error("WorkResumeServiceImpl>insertBatch>Exception:"+e);
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			throw e;
		}
	}
}
