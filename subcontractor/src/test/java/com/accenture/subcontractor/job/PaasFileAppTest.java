package com.accenture.subcontractor.job;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.accenture.subcontractor.job.controller.FileInfoController;
import com.accenture.subcontractor.job.domain.FileInfo;
import com.alibaba.fastjson.JSON;


@RunWith(SpringJUnit4ClassRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringApplicationConfiguration(classes = SubcontractorApp.class) // 指定我们SpringBoot工程的Application启动类
@WebAppConfiguration // 由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
public class PaasFileAppTest {
	@Resource
	FileInfoController fileInfoController;

	@Test
	public void insert() {
		long start = System.currentTimeMillis();
		FileInfo fileInfo = null;
		for (int i = 10; i < 20; i++) {
			fileInfo = new FileInfo();
			fileInfo.setUserId("ceshi" + i);
			fileInfo.setFilemd5("2afsdfddas" + i);
			fileInfo.setActualFileName("2afsdfddas" + i + ".xls");
			fileInfo.setDeleteFlag("N");
			fileInfo.setCreator("KANGJIN.ZHAO");
			fileInfo.setCreateTime(new Date());
			fileInfoController.insert(fileInfo);
			// System.err.println(fileInfo.getFileId());
		}
		long end = System.currentTimeMillis();
		// 10000条数据消耗时间468秒
		System.err.println((end - start) / 1000);
	}

	@Test
	public void insertList() {
		long start = System.currentTimeMillis();
		FileInfo fileInfo = null;
		List<FileInfo> list = new ArrayList<FileInfo>();
		for (int i = 10; i < 20; i++) {
			fileInfo = new FileInfo();
			fileInfo.setUserId("ceshi" + i);
			fileInfo.setFilemd5("2afsdfddas" + i);
			fileInfo.setActualFileName("2afsdfddas" + i + ".xls");
			fileInfo.setDeleteFlag("N");
			fileInfo.setCreator("KANGJIN.ZHAO");
			fileInfo.setCreateTime(new Date());
			list.add(fileInfo);
		}
		fileInfoController.insertBatch(list);
		long end = System.currentTimeMillis();
		// 10000条数据消耗时间11秒
		System.err.println((end - start) / 1000);
	}

	@Test
	public void deleteByPrimaryKey() {
		FileInfo fileInfo = new FileInfo();
		fileInfo.setFileId("1");
		fileInfoController.deleteByPrimaryKey(fileInfo);
		System.err.println(fileInfo);
	}

	@Test
	public void deleteByPrimaryKeySoft() {
		FileInfo fileInfo = new FileInfo();
		fileInfo.setFileId("2");
		fileInfoController.deleteByPrimaryKeySoft(fileInfo);
		System.err.println(fileInfo);
	}

	@Test
	public void deleteList() {
		List<FileInfo> list = new ArrayList<FileInfo>(1);
		FileInfo fileInfo = new FileInfo();
		fileInfo.setFileId("000a8c9d-94aa-11e7-9334-00163e12ae01");
		list.add(fileInfo);
		fileInfoController.deleteList(list);
	}

	@Test
	public void deleteListSoft() {
		List<FileInfo> list = new ArrayList<FileInfo>(2);
		FileInfo fileInfo = null;
		for (int i = 0; i < 2; i++) {
			fileInfo = new FileInfo();
			if (i == 0) {
				fileInfo.setFileId("000a178f-94ab-11e7-9334-00163e12ae01");
			} else {
				fileInfo.setFileId("000f0761-94ab-11e7-9334-00163e12ae01");
			}

			list.add(fileInfo);
		}
		fileInfoController.deleteListSoft(list);
	}

	@Test
	public void select() {
		FileInfo fileInfo = null;
		fileInfo = new FileInfo();
		fileInfo.setFileId("000a178f-94ab-11e7-9334-00163e12ae01");
		FileInfo nfileInfo =fileInfoController.selectByPrimaryKey(fileInfo);
		System.err.println(JSON.toJSONString(nfileInfo));
	}

	@Test
	public void selectList() {
//		FileInfoConditon fileInfoConditon=new FileInfoConditon();
//		FileInfo fileInfo = new FileInfo();
//		fileInfo.setDeleteFlag("Y");
//		fileInfoConditon.add(fileInfo);
//		fileInfoConditon.setPageNum(1);
//		fileInfoConditon.setPageSize(3);
//		fileInfoConditon.getResult();
//		PageInfo<FileInfo> pager=fileInfoController.queryList(fileInfoConditon);
//		System.err.println(JSON.toJSONString(pager));
	}
	
}
