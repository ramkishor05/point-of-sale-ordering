package com.brijframework.app.service;

import java.util.List;

import com.brijframework.app.contants.RecordStatus;
import com.brijframework.app.dto.UIGlobalCategoryGroup;

public interface GlobalCategoryGroupService {

	UIGlobalCategoryGroup saveCategoryGroup(UIGlobalCategoryGroup unitGroup);

	UIGlobalCategoryGroup getCategoryGroup(long id);

	List<UIGlobalCategoryGroup> getCategoryGroupList();

	List<UIGlobalCategoryGroup> getCategoryGroup( String typeId);

	List<UIGlobalCategoryGroup> getCategoryGroupList(RecordStatus dataStatus);

	boolean deleteCategoryGroup(Long id);

}
