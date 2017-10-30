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

import com.accenture.subcontractor.job.domain.ProjectResume;
import com.accenture.subcontractor.job.domain.ProjectsAchievement;
import com.accenture.subcontractor.job.domain.ProjectsDesc;
import com.accenture.subcontractor.job.domain.ProjectsDuty;
import com.accenture.subcontractor.job.persistence.ProjectResumeMapper;
import com.accenture.subcontractor.job.service.ProjectsAchievementService;
import com.accenture.subcontractor.job.service.ProjectsDescService;
import com.accenture.subcontractor.job.service.ProjectsDutyService;

@Service
@Transactional
public class ProjectResumeService implements com.accenture.subcontractor.job.service.ProjectResumeService {
	private static Logger logger = LoggerFactory.getLogger(ProjectResumeService.class);
	@Resource
	ProjectResumeMapper projectResumeMapper;
	@Resource
	ProjectsAchievementService projectsAchievementService;
	@Resource
	ProjectsDescService projectsDescService;
	@Resource
	ProjectsDutyService projectsDutyService;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void editBatch(List<ProjectResume> recordList) {

		Date date = new Date();
		List<ProjectResume> insertList = new ArrayList<ProjectResume>();
		List<ProjectResume> updateList = new ArrayList<ProjectResume>();
		List<ProjectResume> deleteList = new ArrayList<ProjectResume>();
		List<ProjectsAchievement> insertProjectsAchievementList = new ArrayList<ProjectsAchievement>();
		List<ProjectsAchievement> updateProjectsAchievementList = new ArrayList<ProjectsAchievement>();
		List<ProjectsAchievement> deleteProjectsAchievementList = new ArrayList<ProjectsAchievement>();
		List<ProjectsDesc> insertProjectsDescList = new ArrayList<ProjectsDesc>();
		List<ProjectsDesc> updateProjectsDescList = new ArrayList<ProjectsDesc>();
		List<ProjectsDesc> deleteProjectsDescList = new ArrayList<ProjectsDesc>();
		List<ProjectsDuty> insertProjectsDutyList = new ArrayList<ProjectsDuty>();
		List<ProjectsDuty> updateProjectsDutyList = new ArrayList<ProjectsDuty>();
		List<ProjectsDuty> deleteProjectsDutyList = new ArrayList<ProjectsDuty>();
		try {
			for (ProjectResume projectResume : recordList) {
				// DeleteFlag 标记：S-软删除;N-未删除;U-更新;Y-物理删除
				if (null == projectResume.getDeleteFlag()) {
					insertOwnAndSon(date, insertList, insertProjectsAchievementList, insertProjectsDescList,
							insertProjectsDutyList, projectResume);
				} else {
					if (projectResume.getDeleteFlag().equals("Y")) {
						deleteOwnAndSon(deleteList, deleteProjectsAchievementList, deleteProjectsDescList,
								deleteProjectsDutyList, projectResume);
					} else if (projectResume.getDeleteFlag().equals("U")) {
						updateOwnAndSon(date, updateList, insertProjectsAchievementList, updateProjectsAchievementList,
								deleteProjectsAchievementList, insertProjectsDescList, updateProjectsDescList,
								deleteProjectsDescList, insertProjectsDutyList, updateProjectsDutyList,
								deleteProjectsDutyList, projectResume);
					} else if (projectResume.getDeleteFlag().equals("S")) {
						softDeleteOwnAndSon(updateList, updateProjectsAchievementList, updateProjectsDescList,
								updateProjectsDutyList, projectResume);
					} else if (projectResume.getDeleteFlag().equals("N")) {
						updateOnlySon(date, insertProjectsAchievementList, updateProjectsAchievementList,
								deleteProjectsAchievementList, insertProjectsDescList, updateProjectsDescList,
								deleteProjectsDescList, insertProjectsDutyList, updateProjectsDutyList,
								deleteProjectsDutyList, projectResume);
					}
				}
			}
			editOwnAndSon(insertList, updateList, deleteList, insertProjectsAchievementList, updateProjectsAchievementList,
					deleteProjectsAchievementList, insertProjectsDescList, updateProjectsDescList,
					deleteProjectsDescList,insertProjectsDutyList,updateProjectsDutyList,deleteProjectsDutyList);
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
			List<ProjectResume> insertList,
			List<ProjectResume> updateList, 
			List<ProjectResume> deleteList,
			List<ProjectsAchievement> insertProjectsAchievementList,
			List<ProjectsAchievement> updateProjectsAchievementList,
			List<ProjectsAchievement> deleteProjectsAchievementList,
			List<ProjectsDesc> insertProjectsDescList, 
			List<ProjectsDesc> updateProjectsDescList, 
			List<ProjectsDesc> deleteProjectsDescList,
			List<ProjectsDuty> insertProjectsDutyList,
			List<ProjectsDuty> updateProjectsDutyList, 
			List<ProjectsDuty> deleteProjectsDutyList
			) {
		if (insertProjectsAchievementList.size() > 0) {
			projectsAchievementService.deleteBatch(insertProjectsAchievementList);
		}
		if (updateProjectsAchievementList.size() > 0) {
			projectsAchievementService.updateBatch(updateProjectsAchievementList);
		}
		if (deleteProjectsAchievementList.size() > 0) {
			projectsAchievementService.insertBatch(insertProjectsAchievementList);
		}
		if (deleteList.size() > 0) {
			projectsDescService.deleteBatch(deleteProjectsDescList);
		}
		if (updateList.size() > 0) {
			projectsDescService.updateBatch(updateProjectsDescList);
		}
		if (insertList.size() > 0) {
			projectsDescService.insertBatch(insertProjectsDescList);
		}
		if (deleteList.size() > 0) {
			projectsDutyService.deleteBatch(deleteProjectsDutyList);
		}
		if (updateList.size() > 0) {
			projectsDutyService.updateBatch(updateProjectsDutyList);
		}
		if (insertList.size() > 0) {
			projectsDutyService.insertBatch(insertProjectsDutyList);
		}
		if (insertList.size() > 0) {
			projectResumeMapper.deleteBatch(insertList);
		}
		if (updateList.size() > 0) {
			projectResumeMapper.updateBatch(updateList);
		}
		if (deleteList.size() > 0) {
			projectResumeMapper.insertBatch(insertList);
		}
	}

	/*
	 * 当前记录不变，调用子表，依次分类检查子记录，并编辑自己录
	 */
	private void updateOnlySon(Date date, List<ProjectsAchievement> insertProjectsAchievementList,
			List<ProjectsAchievement> updateProjectsAchievementList,
			List<ProjectsAchievement> deleteProjectsAchievementList, List<ProjectsDesc> insertProjectsDescList,
			List<ProjectsDesc> updateProjectsDescList, List<ProjectsDesc> deleteProjectsDescList,
			List<ProjectsDuty> insertProjectsDutyList, List<ProjectsDuty> updateProjectsDutyList,
			List<ProjectsDuty> deleteProjectsDutyList, ProjectResume projectResume) {
		if (null != projectResume.getProjectsAchievementlist()
				&& projectResume.getProjectsAchievementlist().size() > 0) {
			for (ProjectsAchievement item : projectResume.getProjectsAchievementlist()) {
				if (null == item.getDeleteFlag()) {
					item.setProjectAchievementId(UUID.randomUUID().toString());
					item.setProjectResumeId(projectResume.getProjectResumeId());
					item.setDeleteFlag("N");
					item.setCreateTime(date);
					insertProjectsAchievementList.add(item);
				} else {
					if (item.getDeleteFlag().equals("U")) {
						item.setDeleteFlag("N");
						item.setLastUpdateTime(date);
						updateProjectsAchievementList.add(item);
					} else if (item.getDeleteFlag().equals("Y")) {
						deleteProjectsAchievementList.add(item);
					} else if (item.getDeleteFlag().equals("S")) {
						item.setDeleteFlag("S");
						updateProjectsAchievementList.add(item);
					}
				}
			}
		}
		if (null != projectResume.getProjectsDesclist() && projectResume.getProjectsDesclist().size() > 0) {
			for (ProjectsDesc item : projectResume.getProjectsDesclist()) {
				if (null == item.getDeleteFlag()) {
					item.setProjectDescrId(UUID.randomUUID().toString());
					item.setProjectResumeId(projectResume.getProjectResumeId());
					item.setDeleteFlag("N");
					item.setCreateTime(date);
					insertProjectsDescList.add(item);
				} else {
					if (item.getDeleteFlag().equals("U")) {
						item.setDeleteFlag("N");
						item.setLastUpdateTime(date);
						updateProjectsDescList.add(item);
					} else if (item.getDeleteFlag().equals("Y")) {
						deleteProjectsDescList.add(item);
					} else if (item.getDeleteFlag().equals("S")) {
						item.setDeleteFlag("S");
						updateProjectsDescList.add(item);
					}
				}
			}
		}
		if (null != projectResume.getProjectsDutylist() && projectResume.getProjectsDutylist().size() > 0) {
			for (ProjectsDuty item : projectResume.getProjectsDutylist()) {
				if (null == item.getDeleteFlag()) {
					item.setProjectResponsibilityId(UUID.randomUUID().toString());
					item.setProjectResumeId(projectResume.getProjectResumeId());
					item.setDeleteFlag("N");
					item.setCreateTime(date);
					insertProjectsDutyList.add(item);
				} else {
					if (item.getDeleteFlag().equals("U")) {
						item.setDeleteFlag("N");
						item.setLastUpdateTime(date);
						updateProjectsDutyList.add(item);
					} else if (item.getDeleteFlag().equals("Y")) {
						deleteProjectsDutyList.add(item);
					} else if (item.getDeleteFlag().equals("S")) {
						item.setDeleteFlag("S");
						updateProjectsDutyList.add(item);
					}
				}
			}
		}
	}

	/*
	 * 当前记录软删除，业务规则所属子记录全部软删除
	 */
	private void softDeleteOwnAndSon(List<ProjectResume> updateList,
			List<ProjectsAchievement> updateProjectsAchievementList, List<ProjectsDesc> updateProjectsDescList,
			List<ProjectsDuty> updateProjectsDutyList, ProjectResume projectResume) {
		projectResume.setDeleteFlag("S");
		updateList.add(projectResume);
		if (null != projectResume.getProjectsAchievementlist()
				&& projectResume.getProjectsAchievementlist().size() > 0) {
			for (ProjectsAchievement item : projectResume.getProjectsAchievementlist()) {
				item.setDeleteFlag("S");
			}
			updateProjectsAchievementList.addAll(projectResume.getProjectsAchievementlist());
		}
		if (null != projectResume.getProjectsDesclist() && projectResume.getProjectsDesclist().size() > 0) {
			for (ProjectsDesc item : projectResume.getProjectsDesclist()) {
				item.setDeleteFlag("S");
			}
			updateProjectsDescList.addAll(projectResume.getProjectsDesclist());
		}
		if (null != projectResume.getProjectsDutylist() && projectResume.getProjectsDutylist().size() > 0) {
			for (ProjectsDuty item : projectResume.getProjectsDutylist()) {
				item.setDeleteFlag("S");
			}
			updateProjectsDutyList.addAll(projectResume.getProjectsDutylist());
		}
	}

	/*
	 * 更新当前记录，直接子表所有记录一起更新
	 */
	private void updateOwnAndSon(Date date, List<ProjectResume> updateList,
			List<ProjectsAchievement> insertProjectsAchievementList,
			List<ProjectsAchievement> updateProjectsAchievementList,
			List<ProjectsAchievement> deleteProjectsAchievementList, List<ProjectsDesc> insertProjectsDescList,
			List<ProjectsDesc> updateProjectsDescList, List<ProjectsDesc> deleteProjectsDescList,
			List<ProjectsDuty> insertProjectsDutyList, List<ProjectsDuty> updateProjectsDutyList,
			List<ProjectsDuty> deleteProjectsDutyList, ProjectResume projectResume) {
		projectResume.setDeleteFlag("N");
		projectResume.setLastUpdateTime(date);
		updateList.add(projectResume);
		updateOnlySon(date, insertProjectsAchievementList, updateProjectsAchievementList, deleteProjectsAchievementList,
				insertProjectsDescList, updateProjectsDescList, deleteProjectsDescList, insertProjectsDutyList,
				updateProjectsDutyList, deleteProjectsDutyList, projectResume);
	}

	/*
	 * 物理删除当前记录，则所有直接关联的子记录也物理删除 List<ProjectResume> insertList
	 * List<ProjectResume> updateList List<ProjectResume> deleteList
	 * List<ProjectsAchievement> insertProjectsAchievementList
	 * List<ProjectsAchievement> updateProjectsAchievementList
	 * List<ProjectsAchievement> deleteProjectsAchievementList
	 * List<ProjectsDesc> insertProjectsDescList List<ProjectsDesc>
	 * updateProjectsDescList List<ProjectsDesc> deleteProjectsDescList
	 * List<ProjectsDuty> insertProjectsDutyList List<ProjectsDuty>
	 * updateProjectsDutyList List<ProjectsDuty> deleteProjectsDutyList
	 */
	private void deleteOwnAndSon(List<ProjectResume> deleteList,
			List<ProjectsAchievement> deleteProjectsAchievementList, List<ProjectsDesc> deleteProjectsDescList,
			List<ProjectsDuty> deleteProjectsDutyList, ProjectResume projectResume) {
		deleteList.add(projectResume);
		if (null != projectResume.getProjectsAchievementlist()
				&& projectResume.getProjectsAchievementlist().size() > 0) {
			deleteProjectsAchievementList.addAll(projectResume.getProjectsAchievementlist());
		}
		if (null != projectResume.getProjectsDesclist() && projectResume.getProjectsDesclist().size() > 0) {
			deleteProjectsDescList.addAll(projectResume.getProjectsDesclist());
		}
		if (null != projectResume.getProjectsDutylist() && projectResume.getProjectsDutylist().size() > 0) {
			deleteProjectsDutyList.addAll(projectResume.getProjectsDutylist());
		}
	}

	/*
	 * 插入一条心记录，则所有的子记录也一起插入 List<ProjectResume> insertList
	 * List<ProjectsAchievement> insertProjectsAchievementList
	 * List<ProjectsDesc> insertProjectsDescList List<ProjectsDuty>
	 * insertProjectsDutyList
	 */
	private void insertOwnAndSon(Date date, List<ProjectResume> insertList,
			List<ProjectsAchievement> insertProjectsAchievementList, List<ProjectsDesc> insertProjectsDescList,
			List<ProjectsDuty> insertProjectsDutyList, ProjectResume projectResume) {
		projectResume.setDeleteFlag("N");
		projectResume.setCreateTime(date);
		String resumeId = UUID.randomUUID().toString();
		projectResume.setProjectResumeId(resumeId);
		insertList.add(projectResume);
		if (null != projectResume.getProjectsAchievementlist()
				&& projectResume.getProjectsAchievementlist().size() > 0) {
			for (ProjectsAchievement item : projectResume.getProjectsAchievementlist()) {
				item.setDeleteFlag("N");
				item.setProjectAchievementId(UUID.randomUUID().toString());
				item.setCreateTime(date);
				item.setProjectResumeId(resumeId);
				insertProjectsAchievementList.add(item);
			}
		}
		if (null != projectResume.getProjectsDesclist() && projectResume.getProjectsDesclist().size() > 0) {
			for (ProjectsDesc item : projectResume.getProjectsDesclist()) {
				item.setDeleteFlag("N");
				item.setProjectDescrId(UUID.randomUUID().toString());
				item.setCreateTime(date);
				item.setProjectResumeId(resumeId);
				insertProjectsDescList.add(item);
			}
		}
		if (null != projectResume.getProjectsDutylist() && projectResume.getProjectsDutylist().size() > 0) {
			for (ProjectsDuty item : projectResume.getProjectsDutylist()) {
				item.setDeleteFlag("N");
				item.setProjectResponsibilityId(UUID.randomUUID().toString());
				item.setCreateTime(date);
				item.setProjectResumeId(resumeId);
				insertProjectsDutyList.add(item);
			}
		}
	}
}
