package com.brijframework.app.dto;

import java.io.Serializable;

public class UIGlobalCountFreq implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String typeId;
	private String name;
	private String desc;
	private boolean active;
	private float displayOrder;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
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

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public float getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(float displayOrder) {
		this.displayOrder = displayOrder;
	}

}
