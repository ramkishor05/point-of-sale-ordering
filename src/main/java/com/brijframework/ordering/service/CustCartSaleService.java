package com.brijframework.ordering.service;

import java.time.LocalDateTime;
import java.util.List;

import com.brijframework.ordering.rest.cart.CustCartSaleRequest;
import com.brijframework.ordering.rest.cart.CustCartSaleResponse;

public interface CustCartSaleService {

	CustCartSaleResponse saveCartSale(long custAppId, CustCartSaleRequest custCartSaleRequest);

	CustCartSaleResponse updateCartSale(long custAppId, CustCartSaleRequest custCartSaleRequest);

	List<CustCartSaleResponse> getCartSaleList(long custAppId, long userId);

	CustCartSaleResponse getCartSale(long custAppId, String typeId);

	List<CustCartSaleResponse> filterCartSaleList(long custAppId, LocalDateTime fromDate, LocalDateTime toDate);

	boolean deleteCartSale(long custAppId, Long id);

	List<CustCartSaleResponse> getCartSaleListBySupplier(long custAppId, Long customerId);

	List<CustCartSaleResponse> getCartSaleListByUser(long custAppId, Long userId);

	List<CustCartSaleResponse> filterCartSaleList(long custAppId, Long customerId, LocalDateTime fromDate,
			LocalDateTime toDate);

	CustCartSaleResponse currentCartSale(long custAppId, long userId);

}
