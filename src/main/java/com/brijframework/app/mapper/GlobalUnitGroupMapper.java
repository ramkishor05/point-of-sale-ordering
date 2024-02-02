package com.brijframework.app.mapper;
import static com.brijframework.app.contants.Constants.COM_BRIJFRAMEWORK_APP_MAPPER_IMPL;
import static com.brijframework.app.contants.Constants.SPRING;

import org.mapstruct.Mapper;

import com.brijframework.app.dto.UIGlobalUnitGroup;
import com.brijframework.app.entities.EOGlobalUnitGroup;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_APP_MAPPER_IMPL)
public interface GlobalUnitGroupMapper  extends GenericMapper<EOGlobalUnitGroup, UIGlobalUnitGroup>{

	@Override
	EOGlobalUnitGroup mapToDAO(UIGlobalUnitGroup uiGlobalUnitGroup);
	
	@Override
	UIGlobalUnitGroup mapToDTO(EOGlobalUnitGroup eoGlobalUnitGroup);
}
