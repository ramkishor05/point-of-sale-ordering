package com.brijframework.ordering.rest.cart;

import java.util.List;

public class CustCartSaleRequest {

	private Long id;

	private String idenNo;

	private String saleDate;

	private Double discounts;

	private Double totalPrice;

	private Double totalQnt;

	private Long custBusinessAppId;

	private Long customerId;

	private long userId;

	private List<CustCartSaleItemRequest> custCartSaleItemList;

	private List<CustCartSaleAdditional> custCartSaleAdditionalList;
	

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

	public String getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}

	public Double getDiscounts() {
		return discounts;
	}

	public void setDiscounts(Double discounts) {
		this.discounts = discounts;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Double getTotalQnt() {
		return totalQnt;
	}

	public void setTotalQnt(Double totalQnt) {
		this.totalQnt = totalQnt;
	}

	public Long getCustBusinessAppId() {
		return custBusinessAppId;
	}

	public void setCustBusinessAppId(Long custBusinessAppId) {
		this.custBusinessAppId = custBusinessAppId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	public void setUserId(long userId) {
		this.userId=userId;
	}

	public long getUserId() {
		return userId;
	}

	public List<CustCartSaleItemRequest> getCustCartSaleItemList() {
		return custCartSaleItemList;
	}

	public void setCustCartSaleItemList(List<CustCartSaleItemRequest> custCartSaleItemList) {
		this.custCartSaleItemList = custCartSaleItemList;
	}

	public List<CustCartSaleAdditional> getCustCartSaleAdditionalList() {
		return custCartSaleAdditionalList;
	}

	public void setCustCartSaleAdditionalList(List<CustCartSaleAdditional> custCartSaleAdditionalList) {
		this.custCartSaleAdditionalList = custCartSaleAdditionalList;
	}

}
