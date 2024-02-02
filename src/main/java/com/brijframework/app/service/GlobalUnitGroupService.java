package com.brijframework.app.service;

import java.util.List;

import com.brijframework.app.dto.UIGlobalUnitGroup;

public interface GlobalUnitGroupService {

	UIGlobalUnitGroup saveUnitGroup(UIGlobalUnitGroup unitGroup);

	UIGlobalUnitGroup getUnitGroup(long id);

	List<UIGlobalUnitGroup> getUnitGroupList();

	UIGlobalUnitGroup getUnitGroup(String typeId);

	boolean deleteUnitGroup(Long id);

}
