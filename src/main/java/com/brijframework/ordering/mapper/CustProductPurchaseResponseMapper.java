package com.brijframework.ordering.mapper;

import static com.brijframework.ordering.contants.Constants.BUSINESS_ID_KEY;
import static com.brijframework.ordering.contants.Constants.COM_BRIJFRAMEWORK_ORDERING_MAPPER_IMPL;
import static com.brijframework.ordering.contants.Constants.CUST_BUSINESS_APP_ID_ENTITY;
import static com.brijframework.ordering.contants.Constants.CUST_BUSINESS_APP_ID_UI;
import static com.brijframework.ordering.contants.Constants.CUST_BUSINESS_ID_ENTITY;
import static com.brijframework.ordering.contants.Constants.SPRING;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.brijframework.ordering.entities.purchases.EOCustProductPurchase;
import com.brijframework.ordering.entities.purchases.EOCustProductPurchaseItem;
import com.brijframework.ordering.rest.purchase.CustProductPurchaseItemResponse;
import com.brijframework.ordering.rest.purchase.CustProductPurchaseResponse;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_ORDERING_MAPPER_IMPL)
public interface CustProductPurchaseResponseMapper  extends GenericMapper<EOCustProductPurchase, CustProductPurchaseResponse>{

	@Mapping(target=CUST_BUSINESS_APP_ID_ENTITY, source=CUST_BUSINESS_APP_ID_UI)
	@Override
	EOCustProductPurchase mapToDAO(CustProductPurchaseResponse uiProduct);
	
	@Mapping(source=CUST_BUSINESS_APP_ID_ENTITY, target=CUST_BUSINESS_APP_ID_UI)
	@Mapping(source=CUST_BUSINESS_ID_ENTITY, target=BUSINESS_ID_KEY)
	@Override
	CustProductPurchaseResponse mapToDTO(EOCustProductPurchase eoInvProduct);
	
	CustProductPurchaseItemResponse mapToDTO(EOCustProductPurchaseItem eoCustProductRetailPurchase);
	
	EOCustProductPurchaseItem mapToDAO(CustProductPurchaseItemResponse custProductRetailPurchaseResponse);
	
	
}
