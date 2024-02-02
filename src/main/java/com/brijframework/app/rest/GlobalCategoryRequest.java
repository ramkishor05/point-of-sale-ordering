package com.brijframework.app.rest;

import java.io.Serializable;

public class GlobalCategoryRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	public long id;
	public String idenNo;
	public String name;
	public String desc;
	public String typeId;
	public long glbImageDetailId;
	public long glbCategoryGroupId;

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

	public long getGlbImageDetailId() {
		return glbImageDetailId;
	}

	public void setGlbImageDetailId(long glbImageDetailId) {
		this.glbImageDetailId = glbImageDetailId;
	}

	public long getGlbCategoryGroupId() {
		return glbCategoryGroupId;
	}

	public void setGlbCategoryGroupId(long glbCategoryGroupId) {
		this.glbCategoryGroupId = glbCategoryGroupId;
	}

}
