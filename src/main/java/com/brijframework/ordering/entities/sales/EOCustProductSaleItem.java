package com.brijframework.ordering.entities.sales;

import static com.brijframework.ordering.contants.TableConstants.CUST_PRODUCT_ID;
import static com.brijframework.ordering.contants.TableConstants.CUST_PRODUCT_SALE_ID;
import static com.brijframework.ordering.contants.TableConstants.DISCOUNT;
import static com.brijframework.ordering.contants.TableConstants.EOCUST_PRODUCT_SALE_ITEM;
import static com.brijframework.ordering.contants.TableConstants.PURCHASE_PRICE;
import static com.brijframework.ordering.contants.TableConstants.SALE_PRICE;
import static com.brijframework.ordering.contants.TableConstants.SALE_QTN;
import static com.brijframework.ordering.contants.TableConstants.SALE_TYPE;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import com.brijframework.ordering.entities.EOCustItem;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_PRODUCT_SALE_ITEM)
public class EOCustProductSaleItem extends EOCustItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Column(name = CUST_PRODUCT_ID)
	private Long custProductId;

	@Column(name = SALE_QTN)
	private Long saleQnt;

	@Column(name = DISCOUNT)
	private Double discount;
	
	@Column(name = SALE_TYPE)
	private String saleType;

	// for purchase cost
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = PURCHASE_PRICE)
	private EOCustProductSaleItemPrice purchasePrice;

	// for sale cost
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = SALE_PRICE)
	private EOCustProductSaleItemPrice salePrice;

	@JoinColumn(name = CUST_PRODUCT_SALE_ID)
	@OneToOne
	private EOCustProductSale custProductSale;
	
	public EOCustProductSaleItemPrice getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(EOCustProductSaleItemPrice purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public EOCustProductSaleItemPrice getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(EOCustProductSaleItemPrice salePrice) {
		this.salePrice = salePrice;
	}

	public Long getSaleQnt() {
		return saleQnt;
	}

	public void setSaleQnt(Long saleQnt) {
		this.saleQnt = saleQnt;
	}

	public String getSaleType() {
		return saleType;
	}

	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	
	public Long getCustProductId() {
		return custProductId;
	}

	public void setCustProductId(Long custProductId) {
		this.custProductId = custProductId;
	}

	public EOCustProductSale getCustProductSale() {
		return custProductSale;
	}

	public void setCustProductSale(EOCustProductSale custProductSale) {
		this.custProductSale = custProductSale;
	}

}
