package com.brijframework.ordering.mapper.cart;

import static com.brijframework.ordering.contants.Constants.COM_BRIJFRAMEWORK_ORDERING_MAPPER_IMPL;
import static com.brijframework.ordering.contants.Constants.CUST_BUSINESS_APP_ID_ENTITY;
import static com.brijframework.ordering.contants.Constants.CUST_BUSINESS_APP_ID_UI;
import static com.brijframework.ordering.contants.Constants.SPRING;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.brijframework.ordering.entities.cart.EOCustCartSale;
import com.brijframework.ordering.entities.cart.EOCustCartSaleAdditional;
import com.brijframework.ordering.entities.cart.EOCustCartSaleItem;
import com.brijframework.ordering.mapper.GenericMapper;
import com.brijframework.ordering.rest.cart.CustCartSaleAdditional;
import com.brijframework.ordering.rest.cart.CustCartSaleItemRequest;
import com.brijframework.ordering.rest.cart.CustCartSaleRequest;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_ORDERING_MAPPER_IMPL)
public interface CustCartSaleRequestMapper extends GenericMapper<EOCustCartSale, CustCartSaleRequest> {


	@Mapping(target = CUST_BUSINESS_APP_ID_ENTITY, source = CUST_BUSINESS_APP_ID_UI)
	@Override
	EOCustCartSale mapToDAO(CustCartSaleRequest custCartSaleRequest);

	@Mapping(source = CUST_BUSINESS_APP_ID_ENTITY, target = CUST_BUSINESS_APP_ID_UI)
	@Override
	CustCartSaleRequest mapToDTO(EOCustCartSale eoCustCartSale);

	EOCustCartSaleItem mapToDAO(CustCartSaleItemRequest custCartRetailSaleRequest);

	CustCartSaleItemRequest mapToDTO(EOCustCartSaleItem eoCustCartRetailSale);

	List<CustCartSaleAdditional> custCartSaleAdditionalListDTO(List<EOCustCartSaleAdditional> custCartSaleAdditionals);
	
	List<EOCustCartSaleAdditional> custCartSaleAdditionalListDAO(List<CustCartSaleAdditional> custCartSaleAdditionals);

}
