package com.brijframework.ordering.rest.cart;

import com.brijframework.ordering.dto.UIComman;

public class CustCartSaleAdditional extends UIComman {

	private String field;

	private String value;

	private String type;

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
	
}
