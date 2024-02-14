package com.brijframework.ordering.mapper.cart;

import static com.brijframework.ordering.contants.Constants.COM_BRIJFRAMEWORK_ORDERING_MAPPER_IMPL;
import static com.brijframework.ordering.contants.Constants.CUST_BUSINESS_APP_ID_ENTITY;
import static com.brijframework.ordering.contants.Constants.CUST_BUSINESS_APP_ID_UI;
import static com.brijframework.ordering.contants.Constants.SPRING;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.brijframework.ordering.entities.cart.EOCustCartPurchase;
import com.brijframework.ordering.entities.cart.EOCustCartPurchaseAdditional;
import com.brijframework.ordering.entities.cart.EOCustCartPurchaseItem;
import com.brijframework.ordering.mapper.GenericMapper;
import com.brijframework.ordering.rest.cart.CustCartPurchaseAdditional;
import com.brijframework.ordering.rest.cart.CustCartPurchaseItemRequest;
import com.brijframework.ordering.rest.cart.CustCartPurchaseRequest;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_ORDERING_MAPPER_IMPL)
public interface CustCartPurchaseRequestMapper extends GenericMapper<EOCustCartPurchase, CustCartPurchaseRequest> {

	@Mapping(target = CUST_BUSINESS_APP_ID_ENTITY, source = CUST_BUSINESS_APP_ID_UI)
	@Override
	EOCustCartPurchase mapToDAO(CustCartPurchaseRequest custCartPurchaseRequest);

	@Mapping(source = CUST_BUSINESS_APP_ID_ENTITY, target = CUST_BUSINESS_APP_ID_UI)
	@Override
	CustCartPurchaseRequest mapToDTO(EOCustCartPurchase eoCustCartPurchase);

	EOCustCartPurchaseItem mapToDAO(CustCartPurchaseItemRequest custCartRetailPurchaseRequest);

	CustCartPurchaseItemRequest mapToDTO(EOCustCartPurchaseItem eoCustCartRetailPurchase);

	List<CustCartPurchaseAdditional> custCartPurchaseAdditionalListDTO(List<EOCustCartPurchaseAdditional> custCartPurchaseAdditionals);
	
	List<EOCustCartPurchaseAdditional> custCartPurchaseAdditionalListDAO(List<CustCartPurchaseAdditional> custCartPurchaseAdditionals);
}
