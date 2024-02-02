package com.brijframework.app.service;

import java.util.List;

import com.brijframework.app.rest.GlobalCurrencyItemRequest;
import com.brijframework.app.rest.GlobalCurrencyItemResponse;

public interface GlobalCurrencyItemService {

	GlobalCurrencyItemResponse saveCurrencyItem(GlobalCurrencyItemRequest globalCurrencyItemRequest);

	GlobalCurrencyItemResponse getCurrencyItem(Long id);

	List<GlobalCurrencyItemResponse> getCurrencyItemList();

	List<GlobalCurrencyItemResponse> findAllByType(String typeId);

	boolean deleteCurrencyItem(Long id);

}
