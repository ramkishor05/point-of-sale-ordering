package com.brijframework.ordering.mapper.cart;

import static com.brijframework.ordering.contants.Constants.BUSINESS_ID_KEY;
import static com.brijframework.ordering.contants.Constants.COM_BRIJFRAMEWORK_ORDERING_MAPPER_IMPL;
import static com.brijframework.ordering.contants.Constants.CUST_BUSINESS_APP_ID_ENTITY;
import static com.brijframework.ordering.contants.Constants.CUST_BUSINESS_APP_ID_UI;
import static com.brijframework.ordering.contants.Constants.CUST_BUSINESS_ID_ENTITY;
import static com.brijframework.ordering.contants.Constants.SPRING;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.brijframework.ordering.entities.cart.EOCustCartSale;
import com.brijframework.ordering.entities.cart.EOCustCartSaleItem;
import com.brijframework.ordering.mapper.GenericMapper;
import com.brijframework.ordering.rest.cart.CustCartSaleItemResponse;
import com.brijframework.ordering.rest.cart.CustCartSaleResponse;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_ORDERING_MAPPER_IMPL)
public interface CustCartSaleResponseMapper  extends GenericMapper<EOCustCartSale, CustCartSaleResponse>{

	@Mapping(target=CUST_BUSINESS_APP_ID_ENTITY, source=CUST_BUSINESS_APP_ID_UI)
	@Override
	EOCustCartSale mapToDAO(CustCartSaleResponse uiCart);
	
	@Mapping(source=CUST_BUSINESS_APP_ID_ENTITY, target=CUST_BUSINESS_APP_ID_UI)
	@Mapping(source=CUST_BUSINESS_ID_ENTITY, target=BUSINESS_ID_KEY)
	@Override
	CustCartSaleResponse mapToDTO(EOCustCartSale eoInvCart);
	
	CustCartSaleItemResponse mapToDTO(EOCustCartSaleItem eoCustCartRetailSale);
	
	EOCustCartSaleItem mapToDAO(CustCartSaleItemResponse custCartRetailSaleResponse);
	
}
