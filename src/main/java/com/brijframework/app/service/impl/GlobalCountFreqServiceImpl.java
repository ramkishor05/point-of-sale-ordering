package com.brijframework.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.app.entities.EOGlobalCountFreq;
import com.brijframework.app.mapper.GlobalCountFreqMapper;
import com.brijframework.app.mapper.GlobalCountFreqRequestMapper;
import com.brijframework.app.mapper.GlobalCountFreqResponseMapper;
import com.brijframework.app.repository.GlobalCountFreqRepository;
import com.brijframework.app.rest.GlobalCountFreqRequest;
import com.brijframework.app.rest.GlobalCountFreqResponse;
import com.brijframework.app.service.GlobalCountFreqService;

@Service
public class GlobalCountFreqServiceImpl implements GlobalCountFreqService {
	
	@Autowired
	GlobalCountFreqRepository countFreqRepository;
	
	@Autowired
	GlobalCountFreqMapper globalCountFreqMapper;
	
	@Autowired
	GlobalCountFreqRequestMapper globalCountFreqRequestMapper;
	
	@Autowired
	GlobalCountFreqResponseMapper globalCountFreqResponseMapper;
	
	@Override
	public GlobalCountFreqResponse saveCountFreq(GlobalCountFreqRequest globalCountFreqRequest) {
		EOGlobalCountFreq eoCountFreq=globalCountFreqRequestMapper.mapToDAO(globalCountFreqRequest);
		countFreqRepository.save(eoCountFreq);
		return globalCountFreqResponseMapper.mapToDTO(eoCountFreq);
	}

	@Override
	public GlobalCountFreqResponse getCountFreq(long id) {
		return globalCountFreqResponseMapper.mapToDTO(countFreqRepository.getOne(id));
	}

	@Override
	public List<GlobalCountFreqResponse> getCountFreqList() {
		return globalCountFreqResponseMapper.mapToDTO(countFreqRepository.findAll());
	}

	@Override
	public boolean deleteCountFreq(Long id) {
		countFreqRepository.deleteById(id);
		return true;
	}

}
