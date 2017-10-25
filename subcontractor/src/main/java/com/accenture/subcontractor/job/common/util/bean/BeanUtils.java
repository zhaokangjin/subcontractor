package com.accenture.subcontractor.job.common.util.bean;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.accenture.subcontractor.job.common.util.data.Page;
import com.github.pagehelper.PageHelper;

public class BeanUtils {
	private final static Logger logger = LoggerFactory.getLogger(BeanUtils.class);

	/**
	 * 循环向上转型, 获取对象的 DeclaredMethod
	 * 
	 * @Title: getDeclaredMethod
	 * @Description: TODO
	 * @param object
	 * @param methodName
	 * @param parameterTypes
	 * @return
	 */
	public static Method getDeclaredMethod(Object object, String methodName, Class<?>... parameterTypes) {
		Method method = null;
		for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
				method = clazz.getDeclaredMethod(methodName, parameterTypes);
				return method;
			} catch (Exception e) {
				// 这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。如果这里的异常打印或者往外抛，则就不会执行clazz =
				// clazz.getSuperclass(),最后就不会进入到父类中了
			}
		}
		return null;
	}

	/**
	 * 直接调用对象方法, 而忽略修饰符(private, protected, default)
	 * 
	 * @Title: invokeMethod
	 * @Description: TODO
	 * @param object
	 * @param methodName
	 * @param parameterTypes
	 * @param parameters
	 * @return
	 * @throws Exception
	 */
	public static Object invokeMethod(Object object, String methodName, Class<?>[] parameterTypes, Object[] parameters) throws Exception {
		// 根据 对象、方法名和对应的方法参数 通过反射 调用上面的方法获取 Method 对象
		Method method = getDeclaredMethod(object, methodName, parameterTypes);
		// 抑制Java对方法进行检查,主要是针对私有方法而言
		method.setAccessible(true);
		try {
			return method.invoke(object, parameters);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			logger.error("BeanUtils>>>invokeMethod>>>error:" + e);
			throw e;
		}

	}

	/**
	 * 循环向上转型, 获取对象的 DeclaredField
	 * 
	 * @Title: getDeclaredField
	 * @Description: TODO
	 * @param object
	 * @param fieldName
	 * @return
	 */
	public static Field getDeclaredField(Object object, String fieldName) {
		Field field = null;
		Class<?> clazz = object.getClass();
		for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
				field = clazz.getDeclaredField(fieldName);
				return field;
			} catch (Exception e) {
				// 这里甚么都不要做！并且这里的异常必须这样写，不能抛出去。
				// 如果这里的异常打印或者往外抛，则就不会执行clazz =
				// clazz.getSuperclass(),最后就不会进入到父类中了
			}
		}
		return null;
	}

	/**
	 * 直接设置对象属性值, 忽略 private/protected 修饰符, 也不经过 setter
	 * @Title: setFieldValue
	 * @Description: TODO
	 * @param object
	 * @param fieldName
	 * @param value
	 * @throws Exception
	 */
	public static void setFieldValue(Object object, String fieldName, Object value) throws Exception {
		// 根据 对象和属性名通过反射 调用上面的方法获取 Field对象
		Field field = getDeclaredField(object, fieldName);
		// 抑制Java对其的检查
		field.setAccessible(true);
		try {
			// 将 object 中 field 所代表的值 设置为 value
			field.set(object, value);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			logger.error("BeanUtils>>>setFieldValue>>>error:" + e);
			throw e;
		}
	}

	/**
	 * 直接读取对象的属性值, 忽略 private/protected 修饰符, 也不经过 getter
	 * @Title: getFieldValue
	 * @Description: TODO
	 * @param object
	 * @param fieldName
	 * @return
	 * @throws Exception 
	 */
	public static Object getFieldValue(Object object, String fieldName) throws Exception {
		// 根据 对象和属性名通过反射 调用上面的方法获取 Field对象
		Field field = getDeclaredField(object, fieldName);
		// 抑制Java对其的检查
		field.setAccessible(true);
		try {
			// 获取 object 中 field 所代表的属性值
			return field.get(object);
		} catch (Exception e) {
			logger.error("BeanUtils>>>setFieldValue>>>error:" + e);
			throw e;
		}
	}
	/**
	 * 分页设置
	 * @Title: setPageByCondition   
	 * @Description: 注意：重要的规则说三遍，这个利用的是反射，没有泛型约束。所以必须严格按照以下规则，否则分页会不成功
	 * 1、前台或中台传递的Object 如果需要分页，则必须传递page属性，该属性是com.flat.paas.common.util.data.Page 对象，该对象必须包含pageNum,pageSize两个int类型的分页设置，否则会报错
	 * 2、前台或中台传递的Object 对象 fieldName 和 sort 必须同时传，也就是说要么都传，要么都不传，这个设置是指定按哪个字段进行升序或降序排序
	 * fieldName 属性必须是要查询的表（表的字段）对应的domain对象的属性，否则反射失败;sort 只有两种方式 DESC（降序 ） 或ASC（升序）
	 * @param object  前台形如：{"page":{"pageNum":1,"pageSize":6},"fieldName":"createTime","sort":"DESC"}
	 */
	public static void setPageByCondition(Object object){
		try {
			String field=(String) BeanUtils.getFieldValue(object,"fieldName");
			String sort=(String) BeanUtils.getFieldValue(object,"sort");
			String fieldValue=null;
			String sortByField="";
			if(null!=field && !field.trim().equals("") && null!=sort && !sort.trim().equals("")){
				fieldValue=field.replaceAll("[A-Z]", "_$0").toUpperCase();
				sortByField=fieldValue+" "+sort.toUpperCase();
			}
			Page page=(Page)BeanUtils.getFieldValue(object,"page");
			if(null!=page){
				int pageNum=page.getPageNum();
				int pageSize=page.getPageSize();
				if(pageNum>0 && pageSize>0){
					//分页查询
					PageHelper.startPage(pageNum, pageSize,sortByField);  
				}
			}
		} catch (Exception e) {
			logger.error("BeanUtils>>>getPageByCondition>>>error:" + e);
		}
	}

}
