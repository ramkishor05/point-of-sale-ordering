package com.brijframework.app.service;

import java.util.List;

import com.brijframework.app.rest.GlobalCountFreqRequest;
import com.brijframework.app.rest.GlobalCountFreqResponse;

public interface GlobalCountFreqService {

	GlobalCountFreqResponse saveCountFreq(GlobalCountFreqRequest globalCountFreqRequest);

	GlobalCountFreqResponse getCountFreq(long id);

	List<GlobalCountFreqResponse> getCountFreqList();

	boolean deleteCountFreq(Long id);

}
