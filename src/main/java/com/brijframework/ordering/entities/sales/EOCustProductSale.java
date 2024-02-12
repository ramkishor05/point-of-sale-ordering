package com.brijframework.ordering.entities.sales;

import static com.brijframework.ordering.contants.TableConstants.CUSTOMER_ID;
import static com.brijframework.ordering.contants.TableConstants.CUST_BUSINESS_APP_ID;
import static com.brijframework.ordering.contants.EntityConstants.CUST_PRODUCT_SALE;
import static com.brijframework.ordering.contants.TableConstants.DISCOUNTS;
import static com.brijframework.ordering.contants.TableConstants.EOCUST_PRODUCT_SALE;
import static com.brijframework.ordering.contants.TableConstants.SALE_DATE;
import static com.brijframework.ordering.contants.TableConstants.TOTAL_PRICE;
import static com.brijframework.ordering.contants.TableConstants.TOTAL_QNT;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.brijframework.ordering.entities.EOCustBusinessApp;
import com.brijframework.ordering.entities.EOCustItem;


@Entity
@Table(name = EOCUST_PRODUCT_SALE)
public class EOCustProductSale extends EOCustItem {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = DISCOUNTS)
	private Double discounts;

	@Column(name = TOTAL_PRICE)
	private Double totalPrice;

	@Column(name = TOTAL_QNT)
	private Double totalQnt;

	@Column(name = SALE_DATE)
	@Temporal(TemporalType.TIMESTAMP)
	private Date  saleDate;
	
	@Column(name = CUSTOMER_ID, nullable = false)
	private Long customerId;
	
	@JoinColumn(name = CUST_BUSINESS_APP_ID, nullable = false)
	@ManyToOne
	private EOCustBusinessApp custBusinessApp;

	@OneToMany(mappedBy = CUST_PRODUCT_SALE, cascade = CascadeType.ALL)
	private List<EOCustProductSaleItem> custProductSaleItemList;
	
	@OneToMany(mappedBy = CUST_PRODUCT_SALE, cascade = CascadeType.ALL)
	private List<EOCustProductSaleAdditional> custProductSaleAdditionalList;
	
	private long userId;

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

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setUserId(long userId) {
		this.userId=userId;
	}
	
	public long getUserId() {
		return userId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public EOCustBusinessApp getCustBusinessApp() {
		return custBusinessApp;
	}

	public void setCustBusinessApp(EOCustBusinessApp custBusinessApp) {
		this.custBusinessApp = custBusinessApp;
	}

	public List<EOCustProductSaleItem> getCustProductSaleItemList() {
		return custProductSaleItemList;
	}

	public void setCustProductSaleItemList(List<EOCustProductSaleItem> custProductSaleItemList) {
		this.custProductSaleItemList = custProductSaleItemList;
	}

	public List<EOCustProductSaleAdditional> getCustProductSaleAdditionalList() {
		return custProductSaleAdditionalList;
	}

	public void setCustProductSaleAdditionalList(List<EOCustProductSaleAdditional> custProductSaleAdditionalList) {
		this.custProductSaleAdditionalList = custProductSaleAdditionalList;
	}

}
