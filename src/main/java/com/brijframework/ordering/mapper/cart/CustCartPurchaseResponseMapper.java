package com.brijframework.ordering.mapper.cart;

import static com.brijframework.ordering.contants.Constants.BUSINESS_ID_KEY;
import static com.brijframework.ordering.contants.Constants.COM_BRIJFRAMEWORK_ORDERING_MAPPER_IMPL;
import static com.brijframework.ordering.contants.Constants.CUST_BUSINESS_APP_ID_ENTITY;
import static com.brijframework.ordering.contants.Constants.CUST_BUSINESS_APP_ID_UI;
import static com.brijframework.ordering.contants.Constants.CUST_BUSINESS_ID_ENTITY;
import static com.brijframework.ordering.contants.Constants.SPRING;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.brijframework.ordering.entities.cart.EOCustCartPurchase;
import com.brijframework.ordering.entities.cart.EOCustCartPurchaseItem;
import com.brijframework.ordering.mapper.GenericMapper;
import com.brijframework.ordering.rest.cart.CustCartPurchaseItemResponse;
import com.brijframework.ordering.rest.cart.CustCartPurchaseResponse;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_ORDERING_MAPPER_IMPL)
public interface CustCartPurchaseResponseMapper  extends GenericMapper<EOCustCartPurchase, CustCartPurchaseResponse>{

	@Mapping(target=CUST_BUSINESS_APP_ID_ENTITY, source=CUST_BUSINESS_APP_ID_UI)
	@Override
	EOCustCartPurchase mapToDAO(CustCartPurchaseResponse uiCart);
	
	@Mapping(source=CUST_BUSINESS_APP_ID_ENTITY, target=CUST_BUSINESS_APP_ID_UI)
	@Mapping(source=CUST_BUSINESS_ID_ENTITY, target=BUSINESS_ID_KEY)
	@Override
	CustCartPurchaseResponse mapToDTO(EOCustCartPurchase eoInvCart);
	
	CustCartPurchaseItemResponse mapToDTO(EOCustCartPurchaseItem eoCustCartRetailPurchase);
	
	EOCustCartPurchaseItem mapToDAO(CustCartPurchaseItemResponse custCartRetailPurchaseResponse);
	
	
}
