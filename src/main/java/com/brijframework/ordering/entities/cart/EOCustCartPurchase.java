package com.brijframework.ordering.entities.cart;

import static com.brijframework.ordering.contants.TableConstants.CUST_BUSINESS_APP_ID;
import static com.brijframework.ordering.contants.EntityConstants.CUST_CART_PURCHASE;
import static com.brijframework.ordering.contants.TableConstants.DISCOUNTS;
import static com.brijframework.ordering.contants.TableConstants.EOCUST_CART_PURCHASE;
import static com.brijframework.ordering.contants.TableConstants.PURCHASE_DATE;
import static com.brijframework.ordering.contants.TableConstants.SUPPLIER_ID;
import static com.brijframework.ordering.contants.TableConstants.TOTAL_PRICE;
import static com.brijframework.ordering.contants.TableConstants.TOTAL_QNT;
import static com.brijframework.ordering.contants.TableConstants.USER_ID;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import com.brijframework.ordering.entities.EOCustBusinessApp;
import com.brijframework.ordering.entities.EOCustItem;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOCUST_CART_PURCHASE)
public class EOCustCartPurchase extends EOCustItem {


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
	
	@Column(name = PURCHASE_DATE)
	@Temporal(TemporalType.TIMESTAMP)
	private Date  purchaseDate;
	
	@Column(name = SUPPLIER_ID)
	private Long supplierId;
	
	@Column(name = USER_ID, nullable = false)
	private Long userId;
	
	@JoinColumn(name = CUST_BUSINESS_APP_ID, nullable = false)
	@ManyToOne
	private EOCustBusinessApp custBusinessApp;

	@OneToMany(mappedBy = CUST_CART_PURCHASE, cascade = CascadeType.ALL)
	private List<EOCustCartPurchaseItem> custProductPurchaseItemList;

	@OneToMany(mappedBy = CUST_CART_PURCHASE, cascade = CascadeType.ALL)
	private List<EOCustCartPurchaseAdditional> custProductPurchaseAdditionalList;
	
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

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
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

	public EOCustBusinessApp getCustBusinessApp() {
		return custBusinessApp;
	}

	public void setCustBusinessApp(EOCustBusinessApp custBusinessApp) {
		this.custBusinessApp = custBusinessApp;
	}

	public List<EOCustCartPurchaseItem> getCustProductPurchaseItemList() {
		return custProductPurchaseItemList;
	}

	public void setCustProductPurchaseItemList(List<EOCustCartPurchaseItem> custProductPurchaseItemList) {
		this.custProductPurchaseItemList = custProductPurchaseItemList;
	}

	public List<EOCustCartPurchaseAdditional> getCustProductPurchaseAdditionalList() {
		return custProductPurchaseAdditionalList;
	}

	public void setCustProductPurchaseAdditionalList(
			List<EOCustCartPurchaseAdditional> custProductPurchaseAdditionalList) {
		this.custProductPurchaseAdditionalList = custProductPurchaseAdditionalList;
	}

}
