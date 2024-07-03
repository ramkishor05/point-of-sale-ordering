package com.brijframework.ordering.entities.purchases;

import static com.brijframework.ordering.contants.TableConstants.CUST_PRODUCT_PURCHASE_ID;
import static com.brijframework.ordering.contants.TableConstants.EOCUST_PRODUCT_PURCHASE_ADDITIONAL;
import static com.brijframework.ordering.contants.TableConstants.FIELD;
import static com.brijframework.ordering.contants.TableConstants.TYPE;
import static com.brijframework.ordering.contants.TableConstants.VALUE;

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
@Table(name = EOCUST_PRODUCT_PURCHASE_ADDITIONAL)
public class EOCustProductPurchaseAdditional extends EOCustObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = FIELD)
	private String field;

	@Column(name = VALUE)
	private String value;

	// for purchase cost
	@Column(name = TYPE)
	private String type;

	@JoinColumn(name = CUST_PRODUCT_PURCHASE_ID)
	@ManyToOne
	private EOCustProductPurchase custProductPurchase;

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public EOCustProductPurchase getCustProductPurchase() {
		return custProductPurchase;
	}

	public void setCustProductPurchase(EOCustProductPurchase custProductPurchase) {
		this.custProductPurchase = custProductPurchase;
	}
}
