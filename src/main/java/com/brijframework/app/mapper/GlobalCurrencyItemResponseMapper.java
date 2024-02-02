package com.brijframework.app.mapper;

import static com.brijframework.app.contants.Constants.COM_BRIJFRAMEWORK_APP_MAPPER_IMPL;
import static com.brijframework.app.contants.Constants.SPRING;

import org.mapstruct.Mapper;

import com.brijframework.app.entities.EOGlobalCurrencyItem;
import com.brijframework.app.mapper.GenericMapper;
import com.brijframework.app.rest.GlobalCurrencyItemResponse;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_APP_MAPPER_IMPL)
public interface GlobalCurrencyItemResponseMapper extends GenericMapper<EOGlobalCurrencyItem, GlobalCurrencyItemResponse>{

}
