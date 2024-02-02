package com.brijframework.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.app.contants.RecordStatus;
import com.brijframework.app.dto.UIGlobalCategoryGroup;
import com.brijframework.app.entities.EOGlobalCategoryGroup;
import com.brijframework.app.mapper.GlobalCategoryGroupMapper;
import com.brijframework.app.repository.GlobalCategoryGroupRepository;
import com.brijframework.app.service.GlobalCategoryGroupService;

@Service
public class GlobalCategoryGroupServiceImpl implements GlobalCategoryGroupService {
	
	@Autowired
	private GlobalCategoryGroupRepository globalCategoryGroupRepository;
	
	@Autowired
	private GlobalCategoryGroupMapper inventoryCategoryGroupMapper;
	
	@Override
	public UIGlobalCategoryGroup saveCategoryGroup(UIGlobalCategoryGroup unitGroup) {
		EOGlobalCategoryGroup eoCategoryGroup=inventoryCategoryGroupMapper.mapToDAO(unitGroup);
		globalCategoryGroupRepository.save(eoCategoryGroup);
		return inventoryCategoryGroupMapper.mapToDTO(eoCategoryGroup);
	}

	@Override
	public UIGlobalCategoryGroup getCategoryGroup(long id) {
		return inventoryCategoryGroupMapper.mapToDTO(globalCategoryGroupRepository.getOne(id));
	}

	@Override
	public List<UIGlobalCategoryGroup> getCategoryGroupList() {
		return inventoryCategoryGroupMapper.mapToDTO(globalCategoryGroupRepository.findAll());
	}
	
	@Override
	public List<UIGlobalCategoryGroup> getCategoryGroupList(RecordStatus dataStatus) {
		List<EOGlobalCategoryGroup> findAllByStatus = globalCategoryGroupRepository.getCategoryGroupListByStatus(dataStatus.getStatusIds());
		System.out.println("findAllByStatus="+findAllByStatus);
		return inventoryCategoryGroupMapper.mapToDTO(findAllByStatus);
	}

	@Override
	public List<UIGlobalCategoryGroup> getCategoryGroup(String typeId) {
		return inventoryCategoryGroupMapper.mapToDTO(globalCategoryGroupRepository.findAllByTypeId(typeId));
	}

	@Override
	public boolean deleteCategoryGroup(Long id) {
		EOGlobalCategoryGroup eoGlobalCategoryGroup = globalCategoryGroupRepository.getOne(id);
		eoGlobalCategoryGroup.setRecordState(RecordStatus.DACTIVETED.getStatus());
		globalCategoryGroupRepository.save(eoGlobalCategoryGroup);
		return true;
	}

}
