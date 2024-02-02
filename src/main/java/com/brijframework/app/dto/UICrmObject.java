package com.brijframework.app.dto;

public class UICrmObject extends UIComman{

	private Long accountId;
	
	private Boolean portalAccess;
	
	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Boolean getPortalAccess() {
		return portalAccess;
	}

	public void setPortalAccess(Boolean portalAccess) {
		this.portalAccess = portalAccess;
	}
}
