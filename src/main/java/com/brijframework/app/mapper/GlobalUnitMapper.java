package com.brijframework.app.mapper;
import static com.brijframework.app.contants.Constants.COM_BRIJFRAMEWORK_APP_MAPPER_IMPL;
import static com.brijframework.app.contants.Constants.SPRING;

import org.mapstruct.Mapper;

import com.brijframework.app.dto.UIGlobalUnit;
import com.brijframework.app.entities.EOGlobalUnit;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_APP_MAPPER_IMPL)
public interface GlobalUnitMapper  extends GenericMapper<EOGlobalUnit, UIGlobalUnit>{

	@Override
	EOGlobalUnit mapToDAO(UIGlobalUnit uiGlobalUnit);
	
	@Override
	UIGlobalUnit mapToDTO(EOGlobalUnit eoGlobalUnit);
}
