package com.brijframework.ordering.mapper;

import static com.brijframework.ordering.contants.Constants.COM_BRIJFRAMEWORK_ORDERING_MAPPER_IMPL;
import static com.brijframework.ordering.contants.Constants.CUST_BUSINESS_APP_ID_ENTITY;
import static com.brijframework.ordering.contants.Constants.CUST_BUSINESS_APP_ID_UI;
import static com.brijframework.ordering.contants.Constants.SPRING;

import java.util.Date;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.brijframework.ordering.entities.sales.EOCustProductSale;
import com.brijframework.ordering.entities.sales.EOCustProductSaleAdditional;
import com.brijframework.ordering.entities.sales.EOCustProductSaleItem;
import com.brijframework.ordering.entities.sales.EOCustProductSalePayment;
import com.brijframework.ordering.rest.sale.CustProductSaleAdditional;
import com.brijframework.ordering.rest.sale.CustProductSaleItemRequest;
import com.brijframework.ordering.rest.sale.CustProductSalePayment;
import com.brijframework.ordering.rest.sale.CustProductSaleRequest;
import com.brijframework.ordering.util.CommanUtil;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_ORDERING_MAPPER_IMPL)
public interface CustProductSaleRequestMapper extends GenericMapper<EOCustProductSale, CustProductSaleRequest> {


	@Mapping(target = CUST_BUSINESS_APP_ID_ENTITY, source = CUST_BUSINESS_APP_ID_UI)
	@Override
	EOCustProductSale mapToDAO(CustProductSaleRequest custProductSaleRequest);

	@Mapping(source = CUST_BUSINESS_APP_ID_ENTITY, target = CUST_BUSINESS_APP_ID_UI)
	@Override
	CustProductSaleRequest mapToDTO(EOCustProductSale eoCustProductSale);

	EOCustProductSaleItem mapToDAO(CustProductSaleItemRequest custProductRetailSaleRequest);

	CustProductSaleItemRequest mapToDTO(EOCustProductSaleItem eoCustProductRetailSale);

	List<CustProductSaleAdditional> custProductSaleAdditionalListDTO(List<EOCustProductSaleAdditional> custProductSaleAdditionals);
	
	List<EOCustProductSaleAdditional> custProductSaleAdditionalListDAO(List<CustProductSaleAdditional> custProductSaleAdditionals);

	List<EOCustProductSalePayment> custProductSalePaymentListDAO(List<CustProductSalePayment> custProductPaymentList);

}
