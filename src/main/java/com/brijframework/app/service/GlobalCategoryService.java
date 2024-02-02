package com.brijframework.app.service;

import java.util.List;

import com.brijframework.app.rest.GlobalCategoryRequest;
import com.brijframework.app.rest.GlobalCategoryResponse;

public interface GlobalCategoryService {

	GlobalCategoryResponse saveCategory(GlobalCategoryRequest globalCategoryRequest);

	GlobalCategoryResponse getCategory(Long id);

	List<GlobalCategoryResponse> getCategoryList();

	List<GlobalCategoryResponse> findAllByType(String typeId);

	boolean deleteCategory(Long id);

}
