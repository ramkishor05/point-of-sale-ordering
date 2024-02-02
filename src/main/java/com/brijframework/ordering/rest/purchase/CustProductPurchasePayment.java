package com.brijframework.ordering.rest.purchase;

import com.brijframework.ordering.dto.UIComman;

public class CustProductPurchasePayment extends UIComman {
	
	private Long supplierId;
	
	private Boolean primaryPayment;
	
	private Long custTransactionId;

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Boolean getPrimaryPayment() {
		return primaryPayment;
	}

	public void setPrimaryPayment(Boolean primaryPayment) {
		this.primaryPayment = primaryPayment;
	}

	public Long getCustTransactionId() {
		return custTransactionId;
	}

	public void setCustTransactionId(Long custTransactionId) {
		this.custTransactionId = custTransactionId;
	}
	
}
