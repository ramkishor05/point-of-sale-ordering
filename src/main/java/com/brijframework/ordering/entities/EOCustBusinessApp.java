package com.brijframework.ordering.entities;
import static com.brijframework.ordering.contants.TableConstants.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_BUSINESS_APP, uniqueConstraints = {@UniqueConstraint (columnNames = {APP_ID, CUST_ID, BUSINESS_ID })})
public class EOCustBusinessApp extends EOCustObject {

	private static final long serialVersionUID = 1L;
	
	@Column(name = APP_ID, nullable = false)
	private long appId;

	@Column(name = CUST_ID, nullable = false)
	private long custId;

	@Column(name = BUSINESS_ID, nullable = false)
	private long businessId;
	
	public EOCustBusinessApp() {
		// TODO Auto-generated constructor stub
	}

	public EOCustBusinessApp(long appId, long custId, long businessId) {
		super();
		this.appId = appId;
		this.custId = custId;
		this.businessId = businessId;
	}

	public long getAppId() {
		return appId;
	}

	public void setAppId(long appId) {
		this.appId = appId;
	}

	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(long businessId) {
		this.businessId = businessId;
	}
	
}
