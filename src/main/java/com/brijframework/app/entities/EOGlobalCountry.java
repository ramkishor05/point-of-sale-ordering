package com.brijframework.app.entities;

import static com.brijframework.app.contants.Constants.EOGLOBAL_COUNTRY;
import static com.brijframework.app.contants.Constants.IDEN_NO;
import static com.brijframework.app.contants.Constants.NAME;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.brijframework.app.entities.EOGlobalCurrencyItem;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = EOGLOBAL_COUNTRY, uniqueConstraints = { @UniqueConstraint(columnNames = { NAME})})
public class EOGlobalCountry extends EOEntityObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = IDEN_NO)
	private String idenNo;
	
	@Column(name = NAME)
	private String name;
	
	@JoinColumn(name = "CURRENCY_ID")
	@OneToOne
	private EOGlobalCurrencyItem currency;

	public String getIdenNo() {
		return idenNo;
	}

	public void setIdenNo(String idenNo) {
		this.idenNo = idenNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public EOGlobalCurrencyItem getCurrency() {
		return currency;
	}

	public void setCurrency(EOGlobalCurrencyItem currency) {
		this.currency = currency;
	}
}
