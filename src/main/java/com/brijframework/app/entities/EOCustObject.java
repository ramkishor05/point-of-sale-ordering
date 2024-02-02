package com.brijframework.app.entities;

import static com.brijframework.app.contants.Constants.ACTIVE;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

@MappedSuperclass
public abstract class EOCustObject extends EOEntityObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = ACTIVE)
	private Boolean active;
	
	@PrePersist
	public void init() {
		this.active=true;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
