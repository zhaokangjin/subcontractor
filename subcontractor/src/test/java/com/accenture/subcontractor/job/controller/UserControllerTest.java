package com.accenture.subcontractor.job.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.accenture.subcontractor.job.SubcontractorApp;
import com.accenture.subcontractor.job.domain.Account;
import com.accenture.subcontractor.job.domain.AchievementDesc;
import com.accenture.subcontractor.job.domain.Certificate;
import com.accenture.subcontractor.job.domain.EducationResume;
import com.accenture.subcontractor.job.domain.ProjectResume;
import com.accenture.subcontractor.job.domain.ProjectsAchievement;
import com.accenture.subcontractor.job.domain.ProjectsDesc;
import com.accenture.subcontractor.job.domain.ProjectsDuty;
import com.accenture.subcontractor.job.domain.Skill;
import com.accenture.subcontractor.job.domain.User;
import com.accenture.subcontractor.job.domain.WorkResume;
@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringApplicationConfiguration(classes = SubcontractorApp.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
public class UserControllerTest {
@Resource
UserController userController;
	@Test
	public void testSave() {
//		String userId="2741b517-e901-4ca1-8560-02195e2bb5ae";
//		User user=new User();
//		user.setCreateTime(new Date());
//		user.setDomicile("深圳市");
//		user.setIntroduction("我是一个很勤快的码农我是一个很勤快的码农我是一个很勤快的码农我是一个很勤快的码农我是一个很勤快的码农我是一个很勤快的码农我是一个很勤快的码农我是一个很勤快的码农我是一个很勤快的码农我是一个很勤快的码农我是一个很勤快的码农我是一个很勤快的码农我是一个很勤快的码农我是一个很勤快的码农我是一个很勤快的码农");
//		user.setIdentityCard("324545674895068806");
//		user.setMail("34556@qq.com");
//		user.setMobile("13456775445");
//		user.setName("张珊");
//		user.setNativePlace("汉族");
//		user.setOrganId("honglikeji");
//		user.setPassword("22222");
//		user.setPermissionId("777");
//		user.setPhone("23894009");
//		user.setTradeId("IT");
//		user.setRoleId("weixin");
//		user.setSex("M");
//		user.setUserId(userId);
//		List<Account> accountList=new ArrayList<Account>();
//		user.setAccountList(accountList);
//		List<EducationResume> educationResumeList = setEducation(userId);
//		user.setEducationResumeList(educationResumeList);
//		List<ProjectResume> projectResumeList = setProjectResume(userId);
//		user.setProjectResumeList(projectResumeList);
//		List<Skill> skillList=new ArrayList<Skill>();
//		user.setSkillList(skillList);
//		List<WorkResume> workResumeList=new ArrayList<WorkResume>();
//		user.setWorkResumeList(workResumeList);
//		userController.saveUserAndChildren(user);
	}

//	private List<ProjectResume> setProjectResume(String userId) {
//		List<ProjectResume> projectResumeList =new ArrayList<ProjectResume>();
//		ProjectResume projectResume1=new ProjectResume();
//		projectResume1.setUserId(userId);
//		projectResume1.setCreateTime(new Date());
//		projectResume1.setEndDate(new Date(2016,1,1));
//		projectResume1.setStartDate(new Date(2015,9,1));
//		projectResume1.setProjectName("点睛榜帮");
//		String uid1=UUID.randomUUID().toString();
//		projectResume1.setProjectResumeId(uid1);
//		List<ProjectsAchievement> projectsAchievementList1=new ArrayList<ProjectsAchievement>();
//		ProjectsAchievement projectsAchievement11=new ProjectsAchievement();
//		ProjectsAchievement projectsAchievement12=new ProjectsAchievement();
//		projectsAchievementList1.add(projectsAchievement11);
//		projectsAchievementList1.add(projectsAchievement12);
//		projectResume1.setProjectsAchievementList(projectsAchievementList1);
//		
//		List<ProjectsDuty> projectsDutyList1=new ArrayList<ProjectsDuty>();
//		ProjectsDuty projectsDuty11=new ProjectsDuty();
//		projectsDuty11.setCreateTime(new Date());
//		projectsDuty11.setDepartment("技术部");
//		projectsDuty11.setStartDate(new Date(2017,1,1));
//		projectsDuty11.setEndDate(new Date(2017,3,1));
//		projectsDuty11.setPost("技术员");
//		projectsDuty11.setProjectResponsibilityId(UUID.randomUUID().toString());
//		projectsDuty11.setProjectResumeId(uid1);
//		projectsDuty11.setResponsibilityDescr("巴拉巴拉");
//		ProjectsDuty ProjectsDuty12=new ProjectsDuty();
//		ProjectsDuty12.setCreateTime(new Date());
//		ProjectsDuty12.setDepartment("市场部");
//		ProjectsDuty12.setStartDate(new Date(2017,1,1));
//		ProjectsDuty12.setEndDate(new Date(2017,3,1));
//		ProjectsDuty12.setPost("技术员");
//		ProjectsDuty12.setProjectResponsibilityId(UUID.randomUUID().toString());
//		ProjectsDuty12.setProjectResumeId(uid1);
//		ProjectsDuty12.setResponsibilityDescr("巴哔哩哔哩拉巴拉");
//		projectsDutyList1.add(projectsDuty11);
//		projectsDutyList1.add(ProjectsDuty12);
//		projectResume1.setProjectsDutyList(projectsDutyList1);
//		
//		List<ProjectsDesc> projectsDescList1=new ArrayList<ProjectsDesc>();
//		ProjectsDesc projectsDesc11=new ProjectsDesc();
//		ProjectsDesc projectsDesc12=new ProjectsDesc();
//		projectsDescList1.add(projectsDesc11);
//		projectsDescList1.add(projectsDesc12);
//		projectResume1.setProjectsDescList(projectsDescList1);
//		
//		ProjectResume projectResume2=new ProjectResume();
//		projectResume2.setUserId(userId);
//		projectResume2.setCreateTime(new Date());
//		projectResume2.setEndDate(new Date(2016,3,1));
//		projectResume2.setStartDate((new Date(2016,1,1)));
//		projectResume2.setProjectName("点睛榜帮");
//		String uid2=UUID.randomUUID().toString();
//		projectResume2.setProjectResumeId(uid2);
//		List<ProjectsAchievement> projectsAchievementList2=new ArrayList<ProjectsAchievement>();
//		ProjectsAchievement projectsAchievement21=new ProjectsAchievement();
//		ProjectsAchievement projectsAchievement22=new ProjectsAchievement();
//		projectsAchievementList2.add(projectsAchievement21);
//		projectsAchievementList2.add(projectsAchievement22);
//		List<ProjectsDuty> projectsDutyList2=new ArrayList<ProjectsDuty>();
//		List<ProjectsDesc> projectsDescList2=new ArrayList<ProjectsDesc>();
//		projectResume2.setProjectsAchievementList(projectsAchievementList2);
//		projectResume2.setProjectsDutyList(projectsDutyList2);
//		projectResume2.setProjectsDescList(projectsDescList2);
//		
//		ProjectResume projectResume3=new ProjectResume();
//		projectResume3.setUserId(userId);
//		projectResume3.setCreateTime(new Date());
//		projectResume3.setEndDate(new Date(2016,6,1));
//		projectResume3.setStartDate((new Date(2016,3,1)));
//		projectResume3.setProjectName("点睛榜帮");
//		String uid3=UUID.randomUUID().toString();
//		projectResume3.setProjectResumeId(uid3);
//		List<ProjectsAchievement> projectsAchievementList3=new ArrayList<ProjectsAchievement>();
//		ProjectsAchievement projectsAchievement31=new ProjectsAchievement();
//		ProjectsAchievement projectsAchievement32=new ProjectsAchievement();
//		projectsAchievementList1.add(projectsAchievement31);
//		projectsAchievementList1.add(projectsAchievement32);
//		List<ProjectsDuty> projectsDutyList3=new ArrayList<ProjectsDuty>();
//		List<ProjectsDesc> projectsDescList3=new ArrayList<ProjectsDesc>();
//		projectResume3.setProjectsAchievementList(projectsAchievementList3);
//		projectResume3.setProjectsDutyList(projectsDutyList3);
//		projectResume3.setProjectsDescList(projectsDescList3);
//		
//		ProjectResume projectResume4=new ProjectResume();
//		projectResume4.setUserId(userId);
//		projectResume4.setCreateTime(new Date());
//		projectResume4.setEndDate(new Date(2016,9,1));
//		projectResume4.setStartDate((new Date(2016,6,1)));
//		projectResume4.setProjectName("点睛榜帮");
//		String uid4=UUID.randomUUID().toString();
//		projectResume4.setProjectResumeId(uid4);
//		List<ProjectsAchievement> projectsAchievementList4=new ArrayList<ProjectsAchievement>();
//		ProjectsAchievement ProjectsAchievement41=new ProjectsAchievement();
//		ProjectsAchievement ProjectsAchievement42=new ProjectsAchievement();
//		projectsAchievementList1.add(ProjectsAchievement41);
//		projectsAchievementList1.add(ProjectsAchievement42);
//		List<ProjectsDuty> projectsDutyList4=new ArrayList<ProjectsDuty>();
//		List<ProjectsDesc> projectsDescList4=new ArrayList<ProjectsDesc>();
//		projectResume4.setProjectsAchievementList(projectsAchievementList4);
//		projectResume4.setProjectsDutyList(projectsDutyList4);
//		projectResume4.setProjectsDescList(projectsDescList4);
//		
//		
//		projectResumeList.add(projectResume1);
//		projectResumeList.add(projectResume2);
//		projectResumeList.add(projectResume3);
//		projectResumeList.add(projectResume4);
//		return projectResumeList;
//	}
//
//	private List<EducationResume> setEducation(String userId) {
//		List<EducationResume> educationResumeList=new ArrayList<EducationResume>();
//			EducationResume educationResume1=new EducationResume();
//			educationResume1.setCreateTime(new Date());
//			educationResume1.setEducationCode("H");
//			String educationResumeId=UUID.randomUUID().toString();
//			educationResume1.setEducationResumeId(educationResumeId);
//			educationResume1.setEnrolDate(new Date(2012,9,1));
//			educationResume1.setGraduationDate(new Date(2016,6,30));
//			educationResume1.setProfessionCode("H");
//			educationResume1.setUniversitiesCode("10001");
//			educationResume1.setUserId(userId);
//				List<Certificate> certificateList=new ArrayList<Certificate>();
//				Certificate certificate1=new Certificate();
//				certificate1.setAwardDate(new Date(2015,6,30));
//				certificate1.setAwardOrgan("清华大学");
//				certificate1.setCertificateCode("jyb00010001001101");
//				certificate1.setCertificateId(UUID.randomUUID().toString());
//				certificate1.setCertificateName("优秀学生干部");
//				certificate1.setCertificateType("奖状");
//				certificate1.setCreateTime(new Date());
//				certificate1.setEducationResumeId(educationResumeId);
//				certificateList.add(certificate1);
//				Certificate certificate2=new Certificate();
//				certificate2.setAwardDate(new Date(2016,6,30));
//				certificate2.setAwardOrgan("清华大学");
//				certificate2.setCertificateCode("qh000100010011023");
//				certificate2.setCertificateId(UUID.randomUUID().toString());
//				certificate2.setCertificateName("学位证");
//				certificate2.setCertificateType("学位证");
//				certificate2.setCreateTime(new Date());
//				certificate2.setEducationResumeId(educationResumeId);
//				certificateList.add(certificate2);
//				educationResume1.setCertificateList(certificateList);
//			List<AchievementDesc> achievementDescList=new ArrayList<AchievementDesc>();
//				AchievementDesc achievementDesc=new AchievementDesc();
//				achievementDesc.setAchievementDescr("获得三好学生，优秀学生干部获得三好学生，优秀学生干部获得三好学生，优秀学生干部获得三好学生，优秀学生干部获得三好学生，优秀学生干部获得三好学生，优秀学生干部获得三好学生，优秀学生干部获得三好学生，优秀学生干部获得三好学生，优秀学生干部获得三好学生，优秀学生干部获得三好学生，优秀学生干部获得三好学生，优秀学生干部获得三好学生，优秀学生干部获得三好学生，优秀学生干部获得三好学生，优秀学生干部获得三好学生，优秀学生干部获得三好学生，优秀学生干部获得三好学生，优秀学生干部获得三好学生，优秀学生干部获得三好学生，优秀学生干部获得三好学生，优秀学生干部获得三好学生，优秀学生干部获得三好学生，优秀学生干部获得三好学生，优秀学生干部获得三好学生，优秀学生干部获得三好学生，优秀学生干部获得三好学生，优秀学生干部");
//				achievementDesc.setAchievementId(UUID.randomUUID().toString());
//				achievementDesc.setEducationResumeId(educationResumeId);				achievementDesc.setEducationResumeId(educationResumeId);
//				
//				educationResume1.setAchievementDescList(achievementDescList);
//			educationResumeList.add(educationResume1);
//			
//			EducationResume educationResume2=new EducationResume();
//			educationResume2.setCreateTime(new Date());
//			educationResume2.setEducationCode("9");
//			String educationResume2Id=UUID.randomUUID().toString();
//			educationResume2.setEducationResumeId(educationResume2Id);
//			educationResume2.setEnrolDate(new Date(2009,9,1));
//			educationResume2.setGraduationDate(new Date(2012,6,30));
//			educationResume2.setProfessionCode("9");
//			educationResume2.setUniversitiesCode("竹山一中");
//			educationResume2.setUserId(userId);
//				List<Certificate> certificate1List=new ArrayList<Certificate>();
//				Certificate certificate3=new Certificate();
//				certificate3.setAwardDate(new Date(2015,6,30));
//				certificate3.setAwardOrgan("清华大学");
//				certificate3.setCertificateCode("jyb00010001001101");
//				certificate3.setCertificateId(UUID.randomUUID().toString());
//				certificate3.setCertificateName("优秀学生干部");
//				certificate3.setCertificateType("奖状");
//				certificate3.setCreateTime(new Date());
//				certificate3.setEducationResumeId(educationResumeId);
//				certificate1List.add(certificate3);
//				educationResume2.setCertificateList(certificate1List);
//			educationResumeList.add(educationResume2);
//		return educationResumeList;
//	}

}
