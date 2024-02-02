package com.brijframework.app.mapper;
import static com.brijframework.app.contants.Constants.COM_BRIJFRAMEWORK_APP_MAPPER_IMPL;
import static com.brijframework.app.contants.Constants.SPRING;

import org.mapstruct.Mapper;

import com.brijframework.app.entities.EOGlobalCategory;
import com.brijframework.app.mapper.GenericMapper;
import com.brijframework.app.rest.GlobalCategoryResponse;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_APP_MAPPER_IMPL)
public interface GlobalCategoryResponseMapper  extends GenericMapper<EOGlobalCategory, GlobalCategoryResponse>{

	@Override
	EOGlobalCategory mapToDAO(GlobalCategoryResponse uiGlobalCategory);
	
	@Override
	GlobalCategoryResponse mapToDTO(EOGlobalCategory eoGlobalCategory);
}
