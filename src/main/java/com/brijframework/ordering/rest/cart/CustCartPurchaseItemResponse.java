package com.brijframework.ordering.rest.cart;

import com.brijframework.ordering.dto.UICustProductPrice;

public class CustCartPurchaseItemResponse {

	private Long id;
	private String idenNo;
	private Double purchaseQnt;
	private Double discount;
	private UICustProductPrice purchasePrice;
	private Long custProductId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdenNo() {
		return idenNo;
	}

	public void setIdenNo(String idenNo) {
		this.idenNo = idenNo;
	}

	public Double getPurchaseQnt() {
		return purchaseQnt;
	}

	public void setPurchaseQnt(Double purchaseQnt) {
		this.purchaseQnt = purchaseQnt;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public UICustProductPrice getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(UICustProductPrice purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Long getCustProductId() {
		return custProductId;
	}

	public void setCustProductId(Long custProductId) {
		this.custProductId = custProductId;
	}
	
}
