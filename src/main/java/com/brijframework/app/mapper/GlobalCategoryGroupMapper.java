package com.brijframework.app.mapper;
import static com.brijframework.app.contants.Constants.COM_BRIJFRAMEWORK_APP_MAPPER_IMPL;
import static com.brijframework.app.contants.Constants.SPRING;

import org.mapstruct.Mapper;

import com.brijframework.app.dto.UIGlobalCategoryGroup;
import com.brijframework.app.entities.EOGlobalCategoryGroup;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_APP_MAPPER_IMPL)
public interface GlobalCategoryGroupMapper  extends GenericMapper<EOGlobalCategoryGroup, UIGlobalCategoryGroup>{

	@Override
	EOGlobalCategoryGroup mapToDAO(UIGlobalCategoryGroup eoRoleDTO);
	
	@Override
	UIGlobalCategoryGroup mapToDTO(EOGlobalCategoryGroup eoRole);
}
