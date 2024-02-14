package com.brijframework.ordering.rest.cart;

import java.util.List;

public class CustCartPurchaseRequest {

	private Long id;

	private String idenNo;

	private String purchaseDate;

	private Double discounts;

	private Double totalPrice;

	private Double totalQnt;

	private Long supplierId;
	
	private Long userId;
	
	private Long custBusinessAppId;

	private List<CustCartPurchaseItemRequest> custCartPurchaseItemList;

	private List<CustCartPurchaseAdditional> custCartPurchaseAdditionalList;

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

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
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

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCustBusinessAppId() {
		return custBusinessAppId;
	}

	public void setCustBusinessAppId(Long custBusinessAppId) {
		this.custBusinessAppId = custBusinessAppId;
	}

	public List<CustCartPurchaseItemRequest> getCustCartPurchaseItemList() {
		return custCartPurchaseItemList;
	}

	public void setCustCartPurchaseItemList(List<CustCartPurchaseItemRequest> custCartPurchaseItemList) {
		this.custCartPurchaseItemList = custCartPurchaseItemList;
	}

	public List<CustCartPurchaseAdditional> getCustCartPurchaseAdditionalList() {
		return custCartPurchaseAdditionalList;
	}

	public void setCustCartPurchaseAdditionalList(
			List<CustCartPurchaseAdditional> custCartPurchaseAdditionalList) {
		this.custCartPurchaseAdditionalList = custCartPurchaseAdditionalList;
	}
}
