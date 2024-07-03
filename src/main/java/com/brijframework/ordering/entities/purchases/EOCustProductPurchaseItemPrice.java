package com.brijframework.ordering.entities.purchases;

import static com.brijframework.ordering.contants.TableConstants.CURRENCY;
import static com.brijframework.ordering.contants.TableConstants.CUST_PURCHASE_ITEM_ID;
import static com.brijframework.ordering.contants.TableConstants.EOCUST_PRODUCT_PURCHASE_ITEM_PRICE;
import static com.brijframework.ordering.contants.TableConstants.PRICE;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.brijframework.ordering.entities.EOCustObject;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_PRODUCT_PURCHASE_ITEM_PRICE)
public class EOCustProductPurchaseItemPrice extends EOCustObject{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// for purchase cost
	@Column(name = PRICE)
	private Double price;
	
	@Column(name = CURRENCY)
	private Long currency;

	@ManyToOne
	@JoinColumn(name = CUST_PURCHASE_ITEM_ID)
	public EOCustProductPurchaseItem custProductPurchaseItem;

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getCurrency() {
		return currency;
	}

	public void setCurrency(Long currency) {
		this.currency = currency;
	}

	public EOCustProductPurchaseItem getCustProductPurchaseItem() {
		return custProductPurchaseItem;
	}

	public void setCustProductPurchaseItem(EOCustProductPurchaseItem custProductPurchaseItem) {
		this.custProductPurchaseItem = custProductPurchaseItem;
	}
}
