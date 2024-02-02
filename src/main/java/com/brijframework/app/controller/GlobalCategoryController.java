package com.brijframework.app.controller;
import static com.brijframework.app.contants.Constants.TYPE_ID;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brijframework.app.rest.GlobalCategoryRequest;
import com.brijframework.app.rest.GlobalCategoryResponse;
import com.brijframework.app.service.GlobalCategoryService;

@RestController
@RequestMapping("/api/global/category")
public class GlobalCategoryController {

	@Autowired
	private GlobalCategoryService globalCategoryService;
	
	@PostMapping
	public GlobalCategoryResponse addCategory(@RequestBody GlobalCategoryRequest globalCategoryRequest) {
		return globalCategoryService.saveCategory(globalCategoryRequest);
	}
	
	@PutMapping
	public GlobalCategoryResponse updateCategory(@RequestBody GlobalCategoryRequest globalCategoryRequest) {
		return globalCategoryService.saveCategory(globalCategoryRequest);
	}
	
	@GetMapping
	public List<GlobalCategoryResponse> getCategoryList() {
		return globalCategoryService.getCategoryList();
	}
	
	@GetMapping("/{id}")
	public GlobalCategoryResponse getCategoryList(@PathVariable("id") Long id) {
		return globalCategoryService.getCategory(id);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteCategoryList(@PathVariable("id") Long id) {
		return globalCategoryService.deleteCategory(id);
	}
	
	@GetMapping("/type/{typeId}")
	public List<GlobalCategoryResponse> getCategoryList(@PathVariable(TYPE_ID) String typeId) {
		return globalCategoryService.findAllByType(typeId);
	}
}
