package com.brijframework.ordering.mapper;

import static com.brijframework.ordering.contants.Constants.COM_BRIJFRAMEWORK_ORDERING_MAPPER_IMPL;
import static com.brijframework.ordering.contants.Constants.CUST_BUSINESS_APP_ID_ENTITY;
import static com.brijframework.ordering.contants.Constants.CUST_BUSINESS_APP_ID_UI;
import static com.brijframework.ordering.contants.Constants.SPRING;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.brijframework.ordering.entities.purchases.EOCustProductPurchase;
import com.brijframework.ordering.entities.purchases.EOCustProductPurchaseAdditional;
import com.brijframework.ordering.entities.purchases.EOCustProductPurchaseItem;
import com.brijframework.ordering.rest.purchase.CustProductPurchaseAdditional;
import com.brijframework.ordering.rest.purchase.CustProductPurchaseItemRequest;
import com.brijframework.ordering.rest.purchase.CustProductPurchaseRequest;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_ORDERING_MAPPER_IMPL)
public interface CustProductPurchaseRequestMapper extends GenericMapper<EOCustProductPurchase, CustProductPurchaseRequest> {

	@Mapping(target = CUST_BUSINESS_APP_ID_ENTITY, source = CUST_BUSINESS_APP_ID_UI)
	@Override
	EOCustProductPurchase mapToDAO(CustProductPurchaseRequest custProductPurchaseRequest);

	@Mapping(source = CUST_BUSINESS_APP_ID_ENTITY, target = CUST_BUSINESS_APP_ID_UI)
	@Override
	CustProductPurchaseRequest mapToDTO(EOCustProductPurchase eoCustProductPurchase);

	EOCustProductPurchaseItem mapToDAO(CustProductPurchaseItemRequest custProductRetailPurchaseRequest);

	CustProductPurchaseItemRequest mapToDTO(EOCustProductPurchaseItem eoCustProductRetailPurchase);

	List<CustProductPurchaseAdditional> custProductPurchaseAdditionalListDTO(List<EOCustProductPurchaseAdditional> custProductPurchaseAdditionals);
	
	List<EOCustProductPurchaseAdditional> custProductPurchaseAdditionalListDAO(List<CustProductPurchaseAdditional> custProductPurchaseAdditionals);
}
