package com.brijframework.app.service;

import java.util.List;

import com.brijframework.app.dto.UIGlobalUnit;
import com.brijframework.app.entities.EOGlobalUnitGroup;

public interface GlobalUnitService {

	UIGlobalUnit saveUnit(UIGlobalUnit uiUnit);

	List<UIGlobalUnit> getUnitList();

	UIGlobalUnit saveUnit(EOGlobalUnitGroup eoUnitGroup, UIGlobalUnit unit);

	UIGlobalUnit updateUnit(Long id, UIGlobalUnit uiUnit);

	boolean deleteUnit(Long id);

}
