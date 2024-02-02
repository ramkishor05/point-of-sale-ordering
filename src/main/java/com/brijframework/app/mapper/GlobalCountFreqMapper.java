package com.brijframework.app.mapper;

import static com.brijframework.app.contants.Constants.COM_BRIJFRAMEWORK_APP_MAPPER_IMPL;
import static com.brijframework.app.contants.Constants.SPRING;

import org.mapstruct.Mapper;

import com.brijframework.app.dto.UIGlobalCountFreq;
import com.brijframework.app.entities.EOGlobalCountFreq;

@Mapper(componentModel = SPRING, implementationPackage = COM_BRIJFRAMEWORK_APP_MAPPER_IMPL)
public interface GlobalCountFreqMapper  extends GenericMapper<EOGlobalCountFreq, UIGlobalCountFreq>{

	@Override
	EOGlobalCountFreq mapToDAO(UIGlobalCountFreq globalCountFreq);
	
	@Override
    UIGlobalCountFreq mapToDTO(EOGlobalCountFreq eoGlobalCountFreq);
}
