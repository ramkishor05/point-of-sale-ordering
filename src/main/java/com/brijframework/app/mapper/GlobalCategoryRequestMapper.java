package com.brijframework.app.mapper;
import static com.brijframework.app.contants.Constants.COM_BRIJFRAMEWORK_APP_MAPPER_IMPL;
import static com.brijframework.app.contants.Constants.SPRING;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.brijframework.app.entities.EOGlobalCategory;
import com.brijframework.app.mapper.GenericMapper;
import com.brijframework.app.rest.GlobalCategoryRequest;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_APP_MAPPER_IMPL)
public interface GlobalCategoryRequestMapper  extends GenericMapper<EOGlobalCategory, GlobalCategoryRequest>{

	@Override
	@Mapping(target = "globalCategoryGroup.id", source = "glbCategoryGroupId")
	EOGlobalCategory mapToDAO(GlobalCategoryRequest globalCategoryRequest);
	
	@Override
	@Mapping(source = "globalCategoryGroup.id", target = "glbCategoryGroupId")
	GlobalCategoryRequest mapToDTO(EOGlobalCategory eoGlobalCategory);
}
