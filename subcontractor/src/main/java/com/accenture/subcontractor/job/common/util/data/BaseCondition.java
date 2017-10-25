package com.accenture.subcontractor.job.common.util.data;

import java.io.Serializable;

public class BaseCondition implements Serializable{
	/**   
	 * @Fields: serialVersionUID  
	 */ 
	private static final long serialVersionUID = 3813388848148269909L;
	// 分页对象
	private Page page;
	// 排序 升序或降序
	private String sort;
	// 排序字段
	private String fieldName;
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

}
