package com.brijframework.app.rest;

import java.io.Serializable;

import com.brijframework.app.dto.UIGlobalCategoryGroup;
import com.brijframework.app.dto.UIGlobalMediaDetail;

public class GlobalCategoryResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	public long id;
	public String idenNo;
	public String name;
	public String desc;
	public String typeId;
	public UIGlobalMediaDetail globalMediaDetail;
	public UIGlobalCategoryGroup globalCategoryGroup;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdenNo() {
		return idenNo;
	}

	public void setIdenNo(String idenNo) {
		this.idenNo = idenNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public UIGlobalMediaDetail getGlobalMediaDetail() {
		return globalMediaDetail;
	}

	public void setGlobalMediaDetail(UIGlobalMediaDetail globalMediaDetail) {
		this.globalMediaDetail = globalMediaDetail;
	}

	public UIGlobalCategoryGroup getGlobalCategoryGroup() {
		return globalCategoryGroup;
	}

	public void setGlobalCategoryGroup(UIGlobalCategoryGroup globalCategoryGroup) {
		this.globalCategoryGroup = globalCategoryGroup;
	}
}
