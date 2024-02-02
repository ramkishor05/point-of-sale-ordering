package com.brijframework.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.app.entities.EOGlobalCategory;
import com.brijframework.app.mapper.GlobalCategoryRequestMapper;
import com.brijframework.app.mapper.GlobalCategoryResponseMapper;
import com.brijframework.app.repository.GlobalCategoryRepository;
import com.brijframework.app.rest.GlobalCategoryRequest;
import com.brijframework.app.rest.GlobalCategoryResponse;
import com.brijframework.app.service.GlobalCategoryService;

@Service
public class GlobalCategoryServiceIMpl implements GlobalCategoryService {
	
	@Autowired
	private GlobalCategoryRepository globalCategoryRepository;
	
	@Autowired
	private GlobalCategoryRequestMapper globalCategoryRequestMapper;
	
	@Autowired
	private GlobalCategoryResponseMapper globalCategoryResponseMapper;

	@Override
	public GlobalCategoryResponse saveCategory(GlobalCategoryRequest uiGlobalCategory) {
		EOGlobalCategory eoGlobalCategory = globalCategoryRequestMapper.mapToDAO(uiGlobalCategory);
		eoGlobalCategory=globalCategoryRepository.saveAndFlush(eoGlobalCategory);
		return globalCategoryResponseMapper.mapToDTO(eoGlobalCategory);
	}

	@Override
	public GlobalCategoryResponse getCategory(Long id) {
	    return globalCategoryResponseMapper.mapToDTO(globalCategoryRepository.findById(id).orElse(null));
	}

	@Override
	public List<GlobalCategoryResponse> getCategoryList() {
		return globalCategoryResponseMapper.mapToDTO(globalCategoryRepository.findAll());
	}

	@Override
	public List<GlobalCategoryResponse> findAllByType(String typeId) {
		return globalCategoryResponseMapper.mapToDTO(globalCategoryRepository.findOneByTypeId(typeId));
	}
	
	@Override
	public boolean deleteCategory(Long id) {
		globalCategoryRepository.deleteById(id);
		return true;
	}

}
