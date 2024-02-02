package com.brijframework.app.entities;

import static com.brijframework.app.contants.Constants.DETAIL;
import static com.brijframework.app.contants.Constants.EOGLOBAL_MEDIA_DETAIL;
import static com.brijframework.app.contants.Constants.TYPE;
import static com.brijframework.app.contants.Constants.URL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.brijframework.app.entities.EOEntityObject;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOGLOBAL_MEDIA_DETAIL)
public class EOGlobalMediaDetail extends EOEntityObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name=TYPE)
	public String type;
	
	@Column(name=URL)
	public String url;
	
	@Column(name=DETAIL)
	@Lob
	public byte[] detail;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public byte[] getDetail() {
		return detail;
	}

	public void setDetail(byte[] detail) {
		this.detail = detail;
	}
	
	
	
}
