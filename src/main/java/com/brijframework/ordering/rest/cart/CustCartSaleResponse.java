package com.brijframework.ordering.rest.cart;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	
	private List<CustCartSaleItemResponse> custCartSaleItemList;

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

	public List<CustCartSaleItemResponse> getCustCartSaleItemList() {
		if(custCartSaleItemList==null) {
			custCartSaleItemList=new ArrayList<CustCartSaleItemResponse>();
		}
		return custCartSaleItemList;
	}

	public void setCustCartSaleItemList(List<CustCartSaleItemResponse> custCartSaleItemList) {
		this.custCartSaleItemList = custCartSaleItemList;
	}

	public List<CustCartSaleAdditional> getCustCartSaleAdditionalList() {
		if(custCartSaleAdditionalList==null) {
			custCartSaleAdditionalList=new ArrayList<CustCartSaleAdditional>();
		}
		return custCartSaleAdditionalList;
	}

	public void setCustCartSaleAdditionalList(List<CustCartSaleAdditional> custCartSaleAdditionalList) {
		this.custCartSaleAdditionalList = custCartSaleAdditionalList;
	}

}
