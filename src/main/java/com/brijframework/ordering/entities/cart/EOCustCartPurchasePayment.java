package com.brijframework.ordering.entities.cart;

import static com.brijframework.ordering.contants.TableConstants.CUST_PRODUCT_PURCHASE_ID;
import static com.brijframework.ordering.contants.TableConstants.CUST_TRANSACTION_ID;
import static com.brijframework.ordering.contants.TableConstants.EOCUST_CART_PURCHASE_PAYMENT;
import static com.brijframework.ordering.contants.TableConstants.PRIMARY_PAYMENT;
import static com.brijframework.ordering.contants.TableConstants.SUPPLIER_ID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.brijframework.ordering.entities.EOCustObject;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_CART_PURCHASE_PAYMENT)
public class EOCustCartPurchasePayment extends EOCustObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = SUPPLIER_ID, nullable = false)
	private Long supplierId;
	
	@Column(name = PRIMARY_PAYMENT, nullable = false)
	private Boolean primaryPayment;

	@JoinColumn(name = CUST_PRODUCT_PURCHASE_ID)
	@ManyToOne
	private EOCustCartPurchase custProductPurchase;

	@Column(name = CUST_TRANSACTION_ID)
	private Long custTransactionId;

	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	public Boolean getPrimaryPayment() {
		return primaryPayment;
	}

	public void setPrimaryPayment(Boolean primaryPayment) {
		this.primaryPayment = primaryPayment;
	}

	public EOCustCartPurchase getCustProductPurchase() {
		return custProductPurchase;
	}

	public void setCustProductPurchase(EOCustCartPurchase custProductPurchase) {
		this.custProductPurchase = custProductPurchase;
	}

	public Long getCustTransactionId() {
		return custTransactionId;
	}

	public void setCustTransactionId(Long custTransactionId) {
		this.custTransactionId = custTransactionId;
	}
}
