package com.brijframework.ordering.rest.sale;

import com.brijframework.ordering.dto.UIComman;

public class CustProductSalePayment extends UIComman {

	private Long custTransactionId;
	
	private Long customerId;
	
	private Boolean primaryPayment;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	public Long getCustTransactionId() {
		return custTransactionId;
	}

	public void setCustTransactionId(Long custTransactionId) {
		this.custTransactionId = custTransactionId;
	}

	public Boolean getPrimaryPayment() {
		return primaryPayment;
	}

	public void setPrimaryPayment(Boolean primaryPayment) {
		this.primaryPayment = primaryPayment;
	}
	
}
