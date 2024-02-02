package com.brijframework.app.mapper;

import static com.brijframework.app.contants.Constants.COM_BRIJFRAMEWORK_APP_MAPPER_IMPL;
import static com.brijframework.app.contants.Constants.SPRING;

import org.mapstruct.Mapper;

import com.brijframework.app.entities.EOGlobalCountFreq;
import com.brijframework.app.mapper.GenericMapper;
import com.brijframework.app.rest.GlobalCountFreqRequest;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_APP_MAPPER_IMPL)
public interface GlobalCountFreqRequestMapper  extends GenericMapper<EOGlobalCountFreq, GlobalCountFreqRequest>{

	@Override
	EOGlobalCountFreq mapToDAO(GlobalCountFreqRequest globalCountFreqRequest);
	
	@Override
	GlobalCountFreqRequest mapToDTO(EOGlobalCountFreq eoGlobalCountFreq);
}
