package com.brijframework.ordering.entities.cart;

import static com.brijframework.ordering.contants.TableConstants.CUST_PRODUCT_ID;
import static com.brijframework.ordering.contants.TableConstants.CUST_CART_SALE_ID;
import static com.brijframework.ordering.contants.TableConstants.DISCOUNT;
import static com.brijframework.ordering.contants.TableConstants.EOCUST_CART_SALE_ITEM;
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
@Table(name = EOCUST_CART_SALE_ITEM)
public class EOCustCartSaleItem extends EOCustItem {

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
	private EOCustCartSaleItemPrice purchasePrice;

	// for sale cost
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = SALE_PRICE)
	private EOCustCartSaleItemPrice salePrice;

	@JoinColumn(name = CUST_CART_SALE_ID)
	@OneToOne
	private EOCustCartSale custCartSale;
	
	public EOCustCartSaleItemPrice getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(EOCustCartSaleItemPrice purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public EOCustCartSaleItemPrice getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(EOCustCartSaleItemPrice salePrice) {
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

	public EOCustCartSale getCustCartSale() {
		return custCartSale;
	}

	public void setCustCartSale(EOCustCartSale custCartSale) {
		this.custCartSale = custCartSale;
	}

}
