package com.brijframework.app.mapper;

import static com.brijframework.app.contants.Constants.COM_BRIJFRAMEWORK_APP_MAPPER_IMPL;
import static com.brijframework.app.contants.Constants.SPRING;

import org.mapstruct.Mapper;

import com.brijframework.app.dto.UIGlobalCountry;
import com.brijframework.app.entities.EOGlobalCountry;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_APP_MAPPER_IMPL)
public interface GlobalCountryMapper  extends GenericMapper<EOGlobalCountry, UIGlobalCountry>{

}
