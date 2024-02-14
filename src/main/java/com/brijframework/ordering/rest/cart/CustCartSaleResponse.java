package com.brijframework.ordering.rest.cart;

import java.io.Serializable;
import java.util.List;

import com.brijframework.ordering.rest.sale.CustProductSaleAdditional;
import com.brijframework.ordering.rest.sale.CustProductSaleItemResponse;

public class CustCartSaleResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String idenNo;

	private Double discounts;

	private String  saleDate;
	
	private long customerId;
	
	private long userId;
	
	private Double totalPrice;
	
	private Double totalQnt;
	
	private Long custBusinessAppId;
	
	private Long businessId;
	
	private List<CustProductSaleItemResponse> custProductSaleItemList;

	private List<CustProductSaleAdditional> custProductSaleAdditionalList;

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

	public Double getDiscounts() {
		return discounts;
	}

	public void setDiscounts(Double discounts) {
		this.discounts = discounts;
	}

	public String getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
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

	public List<CustProductSaleItemResponse> getCustProductSaleItemList() {
		return custProductSaleItemList;
	}

	public void setCustProductSaleItemList(List<CustProductSaleItemResponse> custProductSaleItemList) {
		this.custProductSaleItemList = custProductSaleItemList;
	}

	public List<CustProductSaleAdditional> getCustProductSaleAdditionalList() {
		return custProductSaleAdditionalList;
	}

	public void setCustProductSaleAdditionalList(List<CustProductSaleAdditional> custProductSaleAdditionalList) {
		this.custProductSaleAdditionalList = custProductSaleAdditionalList;
	}

}
