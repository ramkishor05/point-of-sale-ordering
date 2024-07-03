package com.brijframework.ordering.entities.cart;

import static com.brijframework.ordering.contants.TableConstants.CUST_CART_PURCHASE_ID;
import static com.brijframework.ordering.contants.TableConstants.CUST_PRODUCT_ID;
import static com.brijframework.ordering.contants.TableConstants.DISCOUNT;
import static com.brijframework.ordering.contants.TableConstants.EOCUST_CART_PURCHASE_ITEM;
import static com.brijframework.ordering.contants.TableConstants.PURCHASE_PRICE;
import static com.brijframework.ordering.contants.TableConstants.PURCHASE_QNT;

import com.brijframework.ordering.entities.EOCustItem;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_CART_PURCHASE_ITEM)
public class EOCustCartPurchaseItem extends EOCustItem{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = CUST_PRODUCT_ID)
	private Long custProductId;

	@Column(name = DISCOUNT)
	private Double discount;

	@Column(name = PURCHASE_QNT)
	private Double purchaseQnt;

	// for purchase cost
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = PURCHASE_PRICE)
	private EOCustCartPurchaseItemPrice purchasePrice;
	
	@JoinColumn(name = CUST_CART_PURCHASE_ID)
	@ManyToOne
	private EOCustCartPurchase custCartPurchase;
	
	public EOCustCartPurchaseItemPrice getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(EOCustCartPurchaseItemPrice purchasePrice) {
		this.purchasePrice = purchasePrice;
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

	public Long getCustProductId() {
		return custProductId;
	}

	public void setCustProductId(Long custProductId) {
		this.custProductId = custProductId;
	}

	public EOCustCartPurchase getCustCartPurchase() {
		return custCartPurchase;
	}

	public void setCustCartPurchase(EOCustCartPurchase custCartPurchase) {
		this.custCartPurchase = custCartPurchase;
	}
}
