package com.brijframework.app.service;

import java.util.List;

import com.brijframework.app.contants.RecordStatus;
import com.brijframework.app.dto.UIGlobalCountry;

public interface GlobalCountryService {

	UIGlobalCountry saveCountry(UIGlobalCountry unitGroup);

	UIGlobalCountry getCountry(long id);

	List<UIGlobalCountry> getCountryList();

	List<UIGlobalCountry> getCountryList(RecordStatus dataStatus);

	boolean deleteCountry(Long id);

}
