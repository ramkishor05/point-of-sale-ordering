package com.brijframework.app.service;

import java.util.List;

import com.brijframework.app.contants.RecordStatus;
import com.brijframework.app.dto.UIGlobalCurrencyGroup;

public interface GlobalCurrencyGroupService {

	UIGlobalCurrencyGroup saveCurrencyGroup(UIGlobalCurrencyGroup unitGroup);

	UIGlobalCurrencyGroup getCurrencyGroup(long id);

	List<UIGlobalCurrencyGroup> getCurrencyGroupList();

	List<UIGlobalCurrencyGroup> getCurrencyGroup( String typeId);

	List<UIGlobalCurrencyGroup> getCurrencyGroupList(RecordStatus dataStatus);

	boolean deleteCurrencyGroup(Long id);

}
