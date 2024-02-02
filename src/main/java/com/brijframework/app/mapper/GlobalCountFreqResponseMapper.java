package com.brijframework.app.mapper;

import static com.brijframework.app.contants.Constants.COM_BRIJFRAMEWORK_APP_MAPPER_IMPL;
import static com.brijframework.app.contants.Constants.SPRING;

import org.mapstruct.Mapper;

import com.brijframework.app.entities.EOGlobalCountFreq;
import com.brijframework.app.mapper.GenericMapper;
import com.brijframework.app.rest.GlobalCountFreqResponse;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_APP_MAPPER_IMPL)
public interface GlobalCountFreqResponseMapper  extends GenericMapper<EOGlobalCountFreq, GlobalCountFreqResponse>{

	@Override
	EOGlobalCountFreq mapToDAO(GlobalCountFreqResponse globalCountFreqResponse);
	
	@Override
	GlobalCountFreqResponse mapToDTO(EOGlobalCountFreq eoGlobalCountFreq);
}
