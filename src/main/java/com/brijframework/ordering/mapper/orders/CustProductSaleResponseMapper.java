package com.brijframework.ordering.mapper.orders;

import static com.brijframework.ordering.contants.Constants.BUSINESS_ID_KEY;
import static com.brijframework.ordering.contants.Constants.COM_BRIJFRAMEWORK_ORDERING_MAPPER_IMPL;
import static com.brijframework.ordering.contants.Constants.CUST_BUSINESS_APP_ID_ENTITY;
import static com.brijframework.ordering.contants.Constants.CUST_BUSINESS_ID_ENTITY;
import static com.brijframework.ordering.contants.Constants.CUST_BUSINESS_APP_ID_UI;
import static com.brijframework.ordering.contants.Constants.SPRING;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.brijframework.ordering.entities.sales.EOCustProductSale;
import com.brijframework.ordering.entities.sales.EOCustProductSaleItem;
import com.brijframework.ordering.mapper.GenericMapper;
import com.brijframework.ordering.rest.sale.CustProductSaleItemResponse;
import com.brijframework.ordering.rest.sale.CustProductSaleResponse;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_ORDERING_MAPPER_IMPL)
public interface CustProductSaleResponseMapper  extends GenericMapper<EOCustProductSale, CustProductSaleResponse>{

	@Mapping(target=CUST_BUSINESS_APP_ID_ENTITY, source=CUST_BUSINESS_APP_ID_UI)
	@Override
	EOCustProductSale mapToDAO(CustProductSaleResponse uiProduct);
	
	@Mapping(source=CUST_BUSINESS_APP_ID_ENTITY, target=CUST_BUSINESS_APP_ID_UI)
	@Mapping(source=CUST_BUSINESS_ID_ENTITY, target=BUSINESS_ID_KEY)
	@Override
	CustProductSaleResponse mapToDTO(EOCustProductSale eoInvProduct);
	
	CustProductSaleItemResponse mapToDTO(EOCustProductSaleItem eoCustProductRetailSale);
	
	EOCustProductSaleItem mapToDAO(CustProductSaleItemResponse custProductRetailSaleResponse);
	
}
