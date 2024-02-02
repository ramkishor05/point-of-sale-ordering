package com.brijframework.ordering.service;

import java.time.LocalDateTime;
import java.util.List;

import com.brijframework.ordering.rest.purchase.CustProductPurchaseRequest;
import com.brijframework.ordering.rest.purchase.CustProductPurchaseResponse;

public interface CustProductPurchaseService {

	CustProductPurchaseResponse saveProductPurchase(long custAppId, CustProductPurchaseRequest custProductPurchaseRequest);

	CustProductPurchaseResponse updateProductPurchase(long custAppId, CustProductPurchaseRequest custProductPurchaseRequest);

	List<CustProductPurchaseResponse> getProductPurchaseList(long custAppId, long userId);

	CustProductPurchaseResponse getProductPurchase(long custAppId, String typeId);

	List<CustProductPurchaseResponse> filterProductPurchaseList(long custAppId, LocalDateTime fromDate, LocalDateTime toDate);

	boolean deleteProductPurchase(long custAppId, Long id);

	List<CustProductPurchaseResponse> filterProductPurchaseList(long custAppId, Long supplierId, LocalDateTime fromDate,
			LocalDateTime toDate);

	List<CustProductPurchaseResponse> getProductPurchaseListBySupplier(long custAppId, Long supplierId);

	List<CustProductPurchaseResponse> getProductPurchaseListByUser(long custAppId, Long userId);

}
