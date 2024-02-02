package com.brijframework.app.mapper;
import static com.brijframework.app.contants.Constants.COM_BRIJFRAMEWORK_APP_MAPPER_IMPL;
import static com.brijframework.app.contants.Constants.SPRING;

import org.mapstruct.Mapper;

import com.brijframework.app.dto.UIGlobalCategory;
import com.brijframework.app.entities.EOGlobalCategory;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_APP_MAPPER_IMPL)
public interface GlobalCategoryMapper  extends GenericMapper<EOGlobalCategory, UIGlobalCategory>{

	@Override
	EOGlobalCategory mapToDAO(UIGlobalCategory uiGlobalCategory);
	
	@Override
	UIGlobalCategory mapToDTO(EOGlobalCategory eoGlobalCategory);
}
