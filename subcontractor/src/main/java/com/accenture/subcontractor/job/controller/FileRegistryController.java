package com.accenture.subcontractor.job.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.subcontractor.job.domain.FileRegistry;
import com.accenture.subcontractor.job.domain.condition.FileRegistryConditon;
import com.accenture.subcontractor.job.service.FileInfoService;
import com.accenture.subcontractor.job.service.FileRegistryService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

import oracle.net.aso.e;
@RestController
@RequestMapping("fileRegistry")
public class FileRegistryController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	FileInfoService fileInfoService;
	@Resource
	FileRegistryService fileRegistryService;
	/**
	 * 新增单条记录
	 * 
	 * @Title: insert
	 * @Description: TODO
	 * @param record
	 *            {"originalFile":"我的个爷端
	 *            ","filemd5":"2afsdfddas19","actualFileName":"康进测试新增.xls","deleteFlag":"Y","creator":"KANGJIN.ZHAO"}
	 * @return String "051cd8ed-95cd-11e7-9334-00163e12ae01"
	 */
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(@RequestBody FileRegistry record) {
		try {
			logger.info("FileRegistryController>>>insert>>>record:" + JSON.toJSONString(record));
			record.setCreateTime(new Date());
			fileRegistryService.insert(record);
			return record.getFilemd5();
		} catch (Exception e) {
			logger.error("FileRegistryController>>>insert>>>error:" + e.getMessage());
			throw e;
		}
	}

	/**
	 * 批量插入记录
	 * 
	 * @Title: insertBatch
	 * @Description: 批量插入记录，返回插入后的结果
	 * @param record
	 *            [{"fileId":"aa28b1d7-6fc1-449d-9ffe-884ea0c09df5","originalFile":"我的个爷端
	 *            ","filemd5":"2afsdfddas19","actualFileName":"康进测试新增0.xls","deleteFlag":"Y","creator":"KANGJIN.ZHAO","createTime":1505009563195},{"fileId":"22c4d950-1838-4e95-abaf-a59f1bb6988b","originalFile":"我的个爷端
	 *            ","filemd5":"2afsdfddas19","actualFileName":"康进测试新增1.xls","deleteFlag":"Y","creator":"KANGJIN.ZHAO","createTime":1505009563197},{"fileId":"69d2f565-9543-4503-8f32-3f18978d5a92","originalFile":"我的个爷端
	 *            ","filemd5":"2afsdfddas19","actualFileName":"康进测试新增2.xls","deleteFlag":"Y","creator":"KANGJIN.ZHAO","createTime":1505009563197}]
	 * @return [{"fileId":"aa28b1d7-6fc1-449d-9ffe-884ea0c09df5","originalFile":"我的个爷端
	 *         ","filemd5":"2afsdfddas19","actualFileName":"康进测试新增0.xls","deleteFlag":"Y","creator":"KANGJIN.ZHAO","createTime":1505009563195},{"fileId":"22c4d950-1838-4e95-abaf-a59f1bb6988b","originalFile":"我的个爷端
	 *         ","filemd5":"2afsdfddas19","actualFileName":"康进测试新增1.xls","deleteFlag":"Y","creator":"KANGJIN.ZHAO","createTime":1505009563197},{"fileId":"69d2f565-9543-4503-8f32-3f18978d5a92","originalFile":"我的个爷端
	 *         ","filemd5":"2afsdfddas19","actualFileName":"康进测试新增2.xls","deleteFlag":"Y","creator":"KANGJIN.ZHAO","createTime":1505009563197}]
	 */
	@RequestMapping(value = "insertBatch", method = RequestMethod.POST)
	public List<FileRegistry> insertBatch(@RequestBody List<FileRegistry> record) {
		try {
			logger.info("FileRegistryController>>>insertBatch>>>record:" + JSON.toJSONString(record));
			for (int i = 0; i < record.size(); i++) {
				record.get(i).setCreateTime(new Date());
			}
			fileRegistryService.insertBatch(record);
			return record;
		} catch (Exception e) {
			logger.error("FileRegistryController>>>insertBatch>>>error:" + e.getMessage());
			throw e;
		}
	}

	/**
	 * 物理删除指定主键的记录
	 * 
	 * @Title: deleteByPrimaryKey
	 * @Description: 删除指定主键的记录
	 * @param record
	 *            {"fileId":"aa28b1d7-6fc1-449d-9ffe-884ea0c09df5"}
	 * @return 1
	 * @exception e
	 */
	@RequestMapping(value = "deleteByPrimaryKey", method = RequestMethod.POST)
	public int deleteByPrimaryKey(@RequestBody FileRegistry record) {
		try {
			logger.info("FileRegistryController>>>deleteByPrimaryKey>>>record:" + JSON.toJSONString(record));
			fileRegistryService.deleteByPrimaryKey(record.getFilemd5());
			return 1;
		} catch (Exception e) {
			logger.error("FileRegistryController>>>deleteByPrimaryKey>>>error:" + e.getMessage());
			throw e;
		}
	}

	/**
	 * 依据主键修改删除标记
	 * 
	 * @Title: deleteByPrimaryKeySoft
	 * @Description: 依据主键修改删除标记
	 * @param record
	 *            {"fileId":"22c4d950-1838-4e95-abaf-a59f1bb6988b"}
	 * @return 1
	 * @exception e
	 */
	@RequestMapping(value = "deleteByPrimaryKeySoft", method = RequestMethod.POST)
	public int deleteByPrimaryKeySoft(@RequestBody FileRegistry record) {
		try {
			logger.info("FileRegistryController>>>deleteByPrimaryKeySoft>>>record:" + JSON.toJSONString(record));
			fileRegistryService.deleteByPrimaryKeySoft(record.getFilemd5());
			return 1;
		} catch (Exception e) {
			logger.error("FileRegistryController>>>deleteByPrimaryKeySoft>>>error:" + e.getMessage());
			throw e;
		}
	}

	/**
	 * 依据主键，批量物理删除记录
	 * @Title: deleteList
	 * @Description: 依据主键，批量物理删除记录
	 * @param record
	 * [{"fileId":"aa28b1d7-6fc1-449d-9ffe-884ea0c09df5"},{"fileId":"22c4d950-1838-4e95-abaf-a59f1bb6988b"},{"fileId":"69d2f565-9543-4503-8f32-3f18978d5a92"}]
	 * @return 1
	 * @exception
	 */
	@RequestMapping(value = "deleteList", method = RequestMethod.POST)
	public int deleteList(@RequestBody List<FileRegistry> record) {
		try {
			logger.info("FileRegistryController>>>deleteList>>>record:" + JSON.toJSONString(record));
			fileRegistryService.deleteList(record);
			return 1;
		} catch (Exception e) {
			logger.error("FileRegistryController>>>deleteList>>>error:" + e.getMessage());
			throw e;
		}
	}

	/**
	 * 批量软删除
	 * @Title: deleteListSoft
	 * @Description: 批量软删除
	 * @param record
	 * [{"fileId":"aa28b1d7-6fc1-449d-9ffe-884ea0c09df5"},{"fileId":"22c4d950-1838-4e95-abaf-a59f1bb6988b"},{"fileId":"69d2f565-9543-4503-8f32-3f18978d5a92"}]
	 * @return 1
	 * @exception e
	 */
	@RequestMapping(value = "deleteListSoft", method = RequestMethod.POST)
	public int deleteListSoft(@RequestBody List<FileRegistry> fileInfoList) {
		try {
			logger.info("FileRegistryController>>>deleteListSoft>>>deleteListSoft:" + JSON.toJSONString(fileInfoList));
			fileRegistryService.deleteListSoft(fileInfoList);
			return 1;
		} catch (Exception e) {
			logger.error("FileRegistryController>>>deleteListSoft>>>error:" + e.getMessage());
			throw e;
		}
	}

	/**
	 * 根据主键全量更新整条数据
	 * @Title: updateByPrimaryKey
	 * @Description: TODO
	 * @param record
	 * {"actualFileName":"2afsdfddas19.xls","createTime":1504936602000,"creator":"KANGJIN.ZHAO","deleteFlag":"Y","fileId":"ac93f6e4-9523-11e7-9334-00163e12ae01","filemd5":"2afsdfddas19","originalFile":"ceshi19"}
	 * @return 1
	 * @exception e
	 */
	@RequestMapping(value = "updateByPrimaryKey", method = RequestMethod.POST)
	public int updateByPrimaryKey(@RequestBody FileRegistry fileInfo) {
		try {
			logger.info("FileRegistryController>>>updateByPrimaryKey>>>record:" + JSON.toJSONString(fileInfo));
			fileRegistryService.updateByPrimaryKey(fileInfo);
			return 1;
		} catch (Exception e) {
			logger.error("FileRegistryController>>>updateByPrimaryKey>>>error:" + e.getMessage());
			throw e;
		}
	}

	/**
	 * 根据主键全量更新部分数据
	 * 
	 * @Title: updateByPrimaryKeySelective
	 * @Description: 根据主键局部更新某些字段
	 * @param record
	 * 例如
	 * {"actualFileName":"测试更新.xls","createTime":1504936602000,"fileId":"ac93f6e4-9523-11e7-9334-00163e12ae01","filemd5":"2afsdfddas19","originalFile":"的端到端 "}
	 * @return 1
	 * @exception e
	 */
	@RequestMapping(value = "updateByPrimaryKeySelective", method = RequestMethod.POST)
	public int updateByPrimaryKeySelective(@RequestBody FileRegistry record) {
		try {
			logger.info("FileRegistryController>>>updateByPrimaryKeySelective>>>record:" + JSON.toJSONString(record));
			fileRegistryService.updateByPrimaryKeySelective(record);
			return 1;
		} catch (Exception e) {
			logger.error("FileRegistryController>>>updateByPrimaryKeySelective>>>error:" + e.getMessage());
			throw e;
		}
	}

	/**
	 * 对于前台传入的集合，可能是新增，可能是删除，可能是更新，那么此接口会批量执行此动作，以达到最佳执行效率
	 * @Title: updateBatch
	 * @Description: 【新增】与【更新 与删除（软删除）】 是根据主键来区别的
	 * @param record 更新集合
	 * [{"fileId":"ac93f6e4-9523-11e7-9334-00163e12ae01","originalFile":"的端到端","filemd5":"2afsdfddas19","actualFileName":"康进测试更新.xls","deleteFlag":"1","creator":"KANGJIN.ZHAO","createTime":1504936602000},{"fileId":"2","originalFile":"1","filemd5":"1","actualFileName":"1","deleteFlag":"1","creator":"1","createTime":1514736000000},{"fileId":"000f0761-94ab-11e7-9334-00163e12ae01","originalFile":"ceshi31544","filemd5":"2afsdfddas31544","actualFileName":"2afsdfddas31544.xls","deleteFlag":"1","creator":"KANGJIN.ZHAO","createTime":1504884773000},{"fileId":"000a178f-94ab-11e7-9334-00163e12ae01","originalFile":"ceshi31543","filemd5":"2afsdfddas31543","actualFileName":"2afsdfddas31543.xls","deleteFlag":"1","creator":"KANGJIN.ZHAO","createTime":1504884773000}]
	 * @return 1
	 * @exception e
	 */
	@RequestMapping(value = "updateOrInsertBatch", method = RequestMethod.POST)
	public int updateOrInsertBatch(@RequestBody List<FileRegistry> record) {
		try {
			logger.info("FileRegistryController>>>updateOrInsertBatch>>>record:" + JSON.toJSONString(record));
			fileRegistryService.updateList(record);
			return record.size();
		} catch (Exception e) {
			logger.error("FileRegistryController>>>updateOrInsertBatch>>>error:" + e.getMessage());
			throw e;
		}
	}

	/**
	 * 根据映射文件ID查询真实文件的基本信息
	 * @Title: selectByPrimaryKey
	 * @Description: 一个相同的文件可能被多个人引用或共享，可以用此信息查询文件的基本信息
	 * @param record  fileMd5="7febf904-71f3-41b1-82c8-b8fc049c"
	 * 例如：{"fileMd5":"7febf904-71f3-41b1-82c8-b8fc049c"}
	 * @return FileInfo fileInfo 例如：
	 * {"createTime":1505032114000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileInfoList":[{"actualFileName":"测试注册文件服务319","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"09ed13c0-0ed8-457b-a20d-5aecb381e48f","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗319"},{"actualFileName":"测试注册文件服务696","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"0ad15ada-9011-440e-9d06-c96517edec3d","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗696"},{"actualFileName":"测试注册文件服务551","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"0bc3feac-31a0-4024-99dd-2654094b5f7b","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗551"},{"actualFileName":"测试注册文件服务203","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"24c9911f-2106-424e-b7e7-a934d4e098ff","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗203"},{"actualFileName":"测试注册文件服务116","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"307fc4d5-ba7f-46cf-85f9-4d26c2118676","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗116"},{"actualFileName":"测试注册文件服务261","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"37428293-f48c-4a31-b540-da9e8d989426","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗261"},{"actualFileName":"测试注册文件服务406","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"3cabb7dd-e5a1-44dc-a3c7-d4991f2fa438","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗406"},{"actualFileName":"测试注册文件服务174","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"40127401-1317-42b6-9ba6-451901d7922e","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗174"},{"actualFileName":"测试注册文件服务812","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"4b933050-0bd3-42fe-824c-b04f66092a6d","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗812"},{"actualFileName":"测试注册文件服务667","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"4fa80e09-b283-4336-bad8-701c6c37a5ce","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗667"},{"actualFileName":"测试注册文件服务290","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"5ad3112f-473e-4ba7-85d3-6693c82c6f9a","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗290"},{"actualFileName":"测试注册文件服务609","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"68b68c83-ee42-4e63-8158-c54d020e3dfc","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗609"},{"actualFileName":"测试注册文件服务435","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"6905f2b5-9872-4de1-8edb-4890b97e14c4","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗435"},{"actualFileName":"测试注册文件服务522","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"7b5411ea-f76c-41bd-86ba-03ab3e37d9b5","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗522"},{"actualFileName":"测试注册文件服务638","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"8732f1f5-c81f-46ac-adbb-7afded143ce4","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗638"},{"actualFileName":"测试注册文件服务29","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"89a09a97-ab2c-4dfb-a327-c530aad4d44f","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗29"},{"actualFileName":"测试注册文件服务145","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"92185b5a-5de9-49d4-95c7-c8a83b921269","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗145"},{"actualFileName":"测试注册文件服务58","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"9f4f0cbc-ba5f-4e32-8efc-ef6701f58802","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗58"},{"actualFileName":"测试注册文件服务348","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"a1d76a2b-6c9f-4b3f-b6db-169ef5697c5b","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗348"},{"actualFileName":"测试注册文件服务377","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"a570fec9-d995-4755-a278-5f1b7c90304a","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗377"},{"actualFileName":"测试注册文件服务783","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"b108779b-d497-4948-94db-bfc66424e169","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗783"},{"actualFileName":"测试注册文件服务232","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"b25da426-c30a-4f97-bb20-1996bc50baed","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗232"},{"actualFileName":"测试注册文件服务464","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"b9f53807-1857-4593-9762-b137ed5c13c2","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗464"},{"actualFileName":"测试注册文件服务725","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"bf2972d6-d482-4bb3-b014-04df2a5296d0","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗725"},{"actualFileName":"测试注册文件服务87","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"c823643e-9107-4bd6-9eb7-41992fd9ab68","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗87"},{"actualFileName":"测试注册文件服务841","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"c90b3776-6af0-45ad-95db-ef571b586db1","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗841"},{"actualFileName":"测试注册文件服务493","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"ccefd613-af9c-4f74-ae30-d79620638af1","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗493"},{"actualFileName":"测试注册文件服务754","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"d40efb21-78a6-4946-9984-a62fa368a90b","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗754"},{"actualFileName":"测试注册文件服务580","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"dc7d1843-4737-490e-8a02-18451edab70f","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗580"},{"actualFileName":"测试注册文件服务0","createTime":1505032115000,"creator":"kangjin.zhao@accenture","deleteFlag":"N","fileId":"ef9d8271-5958-43e6-806b-1197194d76c2","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c","originalFile":"原文件名是这样的吗0"}],"filePath":"image/office","fileSize":"5M","filemd5":"7febf904-71f3-41b1-82c8-b8fc049c"}
	 * @exception e
	 */
	@RequestMapping(value = "selectByPrimaryKey", method = RequestMethod.POST)
	public FileRegistry selectByPrimaryKey(@RequestBody FileRegistry record) {
		logger.info("FileRegistryController>>>selectByPrimaryKey>>>record:" + JSON.toJSONString(record));
		try {
			FileRegistry fileRegistry=fileRegistryService.selectByPrimaryKey(record.getFilemd5());
			return fileRegistry;
		} catch (Exception e) {
			logger.error("FileRegistryController>>>selectByPrimaryKey>>>error:" + e.getMessage());
			throw e;
		}
	}

	/**
	 * 分页查询接口
	 * @Title: queryList
	 * @Description: 规范：所有需要分页查询的接口,条件对象必须继承page对象，前台参数必须给定。需要按指定字段排序的，必须给出该字段对应的属性以及升序还是降序规则
	 * @param recordConditon
	 *  例如: 7febf904-71f3-41b1-82c8-b8fc049c
	 * {"fileInfo":{"deleteFlag":"Y"},"page":{"pageNum":"1","pageSize":"30"},"fieldName":"file","sort":"desc"}
	 *  【注意：】fieldName 执行需要排序的列;sort 指定升序还是降序(DESC降序,ASC升序);page 分页查询条件对象 pageNum 查询当前页，pageSize查出当前页面大小
	 * @return PageInfo<FileInfo>
	 * {"pageNum":2,"pageSize":3,"size":3,"startRow":4,"endRow":6,"total":30165,"pages":10055,"list":[{"fileId":"5c50580d-9548-11e7-9334-00163e12ae01","originalFile":"ceshi14","filemd5":"2afsdfddas14","actualFileName":"2afsdfddas14.xls","deleteFlag":"N","creator":"KANGJIN.ZHAO","createTime":1504952358000},{"fileId":"5c5b4e75-9548-11e7-9334-00163e12ae01","originalFile":"ceshi15","filemd5":"2afsdfddas15","actualFileName":"2afsdfddas15.xls","deleteFlag":"N","creator":"KANGJIN.ZHAO","createTime":1504952358000},{"fileId":"5c6663b6-9548-11e7-9334-00163e12ae01","originalFile":"ceshi16","filemd5":"2afsdfddas16","actualFileName":"2afsdfddas16.xls","deleteFlag":"N","creator":"KANGJIN.ZHAO","createTime":1504952358000}],"firstPage":1,"prePage":1,"nextPage":3,"lastPage":8,"isFirstPage":false,"isLastPage":false,"hasPreviousPage":true,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3,4,5,6,7,8]}
	 * 返回带有分页参数的对象,如果入参不带page对象,那么将会查询全部数据，且不带排序功能。当数据量很大的时候，会给前台带来严重的压力，请慎用
	 * @throws Exception 
	 */
	@RequestMapping(value = "queryList", method = RequestMethod.POST)
	public PageInfo<FileRegistry> queryList(@RequestBody FileRegistryConditon recordConditon) throws Exception {
		try {
			logger.info("FileRegistryController>>>queryList>>>recordConditon:" + JSON.toJSONString(recordConditon));
			return fileRegistryService.queryList(recordConditon);
		} catch (Exception e) {
			logger.error("FileRegistryController>>>queryList>>>error:" + e.getMessage());
			throw e;
		}
	}

}
