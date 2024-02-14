package com.brijframework.ordering.service;

import java.time.LocalDateTime;
import java.util.List;

import com.brijframework.ordering.rest.cart.CustCartPurchaseRequest;
import com.brijframework.ordering.rest.cart.CustCartPurchaseResponse;

public interface CustCartPurchaseService {

	CustCartPurchaseResponse saveCartPurchase(long custAppId, CustCartPurchaseRequest custCartPurchaseRequest);

	CustCartPurchaseResponse updateCartPurchase(long custAppId, CustCartPurchaseRequest custCartPurchaseRequest);

	List<CustCartPurchaseResponse> getCartPurchaseList(long custAppId, long userId);

	CustCartPurchaseResponse getCartPurchase(long custAppId, String typeId);

	List<CustCartPurchaseResponse> filterCartPurchaseList(long custAppId, LocalDateTime fromDate, LocalDateTime toDate);

	boolean deleteCartPurchase(long custAppId, Long id);

	List<CustCartPurchaseResponse> filterCartPurchaseList(long custAppId, Long supplierId, LocalDateTime fromDate,
			LocalDateTime toDate);

	List<CustCartPurchaseResponse> getCartPurchaseListBySupplier(long custAppId, Long supplierId);

	List<CustCartPurchaseResponse> getCartPurchaseListByUser(long custAppId, Long userId);

	CustCartPurchaseResponse currentCartPurchase(long custAppId, long userId);

}
