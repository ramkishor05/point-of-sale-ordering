package com.brijframework.app;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.brijframework.app.contants.RecordStatus;
import com.brijframework.app.entities.EOGlobalCategory;
import com.brijframework.app.entities.EOGlobalCategoryGroup;
import com.brijframework.app.entities.EOGlobalCountFreq;
import com.brijframework.app.entities.EOGlobalCountry;
import com.brijframework.app.entities.EOGlobalCurrencyGroup;
import com.brijframework.app.entities.EOGlobalCurrencyItem;
import com.brijframework.app.entities.EOGlobalUnit;
import com.brijframework.app.entities.EOGlobalUnitConversion;
import com.brijframework.app.entities.EOGlobalUnitGroup;
import com.brijframework.app.repository.GlobalCategoryGroupRepository;
import com.brijframework.app.repository.GlobalCategoryRepository;
import com.brijframework.app.repository.GlobalCountFreqRepository;
import com.brijframework.app.repository.GlobalCountryRepository;
import com.brijframework.app.repository.GlobalCurrencyGroupRepository;
import com.brijframework.app.repository.GlobalCurrencyItemRepository;
import com.brijframework.app.repository.GlobalUnitConversionRepository;
import com.brijframework.app.repository.GlobalUnitGroupRepository;
import com.brijframework.app.repository.GlobalUnitRepository;
import com.brijframework.app.schema.factories.JsonSchemaDataFactory;

@Component
public class ApplicaionMainListener implements ApplicationListener<ContextRefreshedEvent> {
	

	@Autowired
	private GlobalCurrencyGroupRepository globalCurrencyGroupRepository;
	
	@Autowired
	private GlobalCurrencyItemRepository globalCurrencyItemRepository;
	
	@Autowired
	private GlobalCountFreqRepository globalCountFreqRepository;
	
	@Autowired
	private GlobalUnitConversionRepository globalUnitConversionRepository;
	
	@Autowired
	private GlobalUnitGroupRepository glbUnitGroupRepository;
	
	@Autowired
	private GlobalUnitRepository glbUnitRepository;
	
	@Autowired
	private GlobalCategoryGroupRepository glbCategoryGroupRepository;
	
	@Autowired
	private GlobalCategoryRepository glbCategoryRepository;
	
	@Autowired
	private GlobalCountryRepository globalCountryRepository;
	
	@Value("${spring.db.datajson.upload}")
	boolean upload;
	
    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
    	if(upload) {
    		
    		JsonSchemaDataFactory instance = JsonSchemaDataFactory.getInstance();
	    	List<EOGlobalCurrencyGroup> eoGlobalCurrencyGroupJson = instance.getAll(EOGlobalCurrencyGroup.class);
	    	eoGlobalCurrencyGroupJson.forEach(eoGlobalCurrencyGroup->{
	    		EOGlobalCurrencyGroup findGlobalCurrencyGroup = globalCurrencyGroupRepository.findByTypeId(eoGlobalCurrencyGroup.getTypeId()).orElse(eoGlobalCurrencyGroup);
	    		BeanUtils.copyProperties(eoGlobalCurrencyGroup, findGlobalCurrencyGroup,"id");
	    		findGlobalCurrencyGroup.setRecordState(RecordStatus.ACTIVETED.getStatus());
	    		EOGlobalCurrencyGroup eoGlobalCurrencyGroupSave= globalCurrencyGroupRepository.save(findGlobalCurrencyGroup);
	    		eoGlobalCurrencyGroup.setId(eoGlobalCurrencyGroupSave.getId());
	    	});
	    	
	    	List<EOGlobalCurrencyItem> eoGlobalCurrencyItemJson = instance.getAll(EOGlobalCurrencyItem.class);
	    	eoGlobalCurrencyItemJson.forEach(eoGlobalCurrencyItem->{
	    		EOGlobalCurrencyItem findGlobalCurrencyItem=globalCurrencyItemRepository.findOneByIdenNo(eoGlobalCurrencyItem.getIdenNo()).orElse(eoGlobalCurrencyItem);
	    		BeanUtils.copyProperties(eoGlobalCurrencyItem, findGlobalCurrencyItem,"id");
	    		findGlobalCurrencyItem.setRecordState(RecordStatus.ACTIVETED.getStatus());
	    		EOGlobalCurrencyItem eoGlobalCurrencyItemSave= globalCurrencyItemRepository.save(findGlobalCurrencyItem);
	    		eoGlobalCurrencyItem.setId(eoGlobalCurrencyItemSave.getId());
	    	});
	    	
	    	List<EOGlobalCategoryGroup> eoGlobalCategoryGroupJson = instance.getAll(EOGlobalCategoryGroup.class);
	    	
	    	eoGlobalCategoryGroupJson.forEach(eoGlobalCategoryGroup->{
	    		EOGlobalCategoryGroup findGlobalCategoryGroup = glbCategoryGroupRepository.findByTypeId(eoGlobalCategoryGroup.getTypeId()).orElse(eoGlobalCategoryGroup);
	    		BeanUtils.copyProperties(eoGlobalCategoryGroup, findGlobalCategoryGroup,"id");
	    		findGlobalCategoryGroup.setRecordState(RecordStatus.ACTIVETED.getStatus());
	    		EOGlobalCategoryGroup eoGlobalCategoryGroupSave= glbCategoryGroupRepository.save(findGlobalCategoryGroup);
	    		eoGlobalCategoryGroup.setId(eoGlobalCategoryGroupSave.getId());
	    	});
	    	
	    	List<EOGlobalCategory> eoGlobalCategoryJson = instance.getAll(EOGlobalCategory.class);
	    	
	    	eoGlobalCategoryJson.forEach(eoGlobalCategory->{
	    		if(glbCategoryRepository.countByTypeId(eoGlobalCategory.getTypeId())==0) {
	    			eoGlobalCategory.setRecordState(RecordStatus.ACTIVETED.getStatus());
		    		EOGlobalCategory eoGlobalCategorySave= glbCategoryRepository.save(eoGlobalCategory);
		    		eoGlobalCategory.setId(eoGlobalCategorySave.getId());
	    		}
	    	});
	    	
	    	List<EOGlobalUnitGroup> eoGlobalUnitGroupsJson = instance.getAll(EOGlobalUnitGroup.class);
	    	
	    	eoGlobalUnitGroupsJson.forEach(eoGlobalUnitGroup->{
	    		EOGlobalUnitGroup findGlobalUnitGroup = glbUnitGroupRepository.findByTypeId(eoGlobalUnitGroup.getTypeId()).orElse(eoGlobalUnitGroup);
	    		BeanUtils.copyProperties(eoGlobalUnitGroup, findGlobalUnitGroup,"id");
	    		findGlobalUnitGroup.setRecordState(RecordStatus.ACTIVETED.getStatus());
	    		EOGlobalUnitGroup eoGlobalUnitGroupSave= glbUnitGroupRepository.save(findGlobalUnitGroup);
	    		eoGlobalUnitGroup.setId(eoGlobalUnitGroupSave.getId());
	    	});
	    	
	
	    	List<EOGlobalUnit> eoGlobalUnitsJson = instance.getAll(EOGlobalUnit.class);
	
	    	eoGlobalUnitsJson.forEach(eoGlobalUnit->{
	    		if(glbUnitRepository.countByTypeId(eoGlobalUnit.getTypeId())==0) {
	    			eoGlobalUnit.setRecordState(RecordStatus.ACTIVETED.getStatus());
		    		EOGlobalUnit eoGlobalUnitSave= glbUnitRepository.save(eoGlobalUnit);
		    		eoGlobalUnit.setId(eoGlobalUnitSave.getId());
	    		}
	    	});
	    	
	    	List<EOGlobalCountFreq> eoGlobalCountFreqsJson = instance.getAll(EOGlobalCountFreq.class);
	    	eoGlobalCountFreqsJson.forEach(eoGlobalCountFreq->{
	    		if(globalCountFreqRepository.countByTypeId(eoGlobalCountFreq.getTypeId())==0) {
	    			eoGlobalCountFreq.setRecordState(RecordStatus.ACTIVETED.getStatus());
		    		EOGlobalCountFreq eoGlobalCountFreqSave = globalCountFreqRepository.save(eoGlobalCountFreq);
		    		eoGlobalCountFreq.setId(eoGlobalCountFreqSave.getId());
	    		}
	    	});
	    	
	    	List<EOGlobalUnitConversion> eoGlobalUnitConversions = instance.getAll(EOGlobalUnitConversion.class);
	
	    	eoGlobalUnitConversions.forEach(eoGlobalUnitConversion->{
	    		if(globalUnitConversionRepository.countByTypeId(eoGlobalUnitConversion.getTypeId())==0) {
	    			eoGlobalUnitConversion.setRecordState(RecordStatus.ACTIVETED.getStatus());
		    		EOGlobalUnitConversion eoGlobalUnitConversionSave =globalUnitConversionRepository.save(eoGlobalUnitConversion);
		    		eoGlobalUnitConversion.setId(eoGlobalUnitConversionSave.getId());
	    		}
	    	});
	    	
	    	List<EOGlobalCountry> globalCountryList = instance.getAll(EOGlobalCountry.class);
	    	List<String> globalCountryUrls=globalCountryList.stream().map(userEndpoint->userEndpoint.getName()).collect(Collectors.toList());
	    	Map<String, EOGlobalCountry> globalCountryMap = globalCountryRepository.findByNames(globalCountryUrls)
	    			.stream().collect(Collectors.toMap(EOGlobalCountry::getName, Function.identity()));
	    	for (EOGlobalCountry globalCountry : globalCountryList) {
	    		EOGlobalCountry eoUserEndpoint = globalCountryMap.getOrDefault(globalCountry.getName(),globalCountry);
	    		BeanUtils.copyProperties(globalCountry, eoUserEndpoint, "id");
	    		EOGlobalCountry saveGlobalCountry = globalCountryRepository.save(eoUserEndpoint);
	    		globalCountry.setId(saveGlobalCountry.getId());
	    		globalCountryMap.put(globalCountry.getName(), globalCountry);
			}
    	}
    }

}