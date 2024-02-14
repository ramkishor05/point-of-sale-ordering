package com.brijframework.ordering.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.ordering.contants.RecordStatus;
import com.brijframework.ordering.entities.EOCustBusinessApp;
import com.brijframework.ordering.entities.purchases.EOCustProductPurchase;
import com.brijframework.ordering.entities.purchases.EOCustProductPurchaseAdditional;
import com.brijframework.ordering.entities.purchases.EOCustProductPurchaseItem;
import com.brijframework.ordering.entities.purchases.EOCustProductPurchaseItemPrice;
import com.brijframework.ordering.mapper.orders.CustProductPurchaseRequestMapper;
import com.brijframework.ordering.mapper.orders.CustProductPurchaseResponseMapper;
import com.brijframework.ordering.repository.CustBusinessAppRepository;
import com.brijframework.ordering.repository.CustProductPurchaseAdditionalRepository;
import com.brijframework.ordering.repository.CustProductPurchaseItemRepository;
import com.brijframework.ordering.repository.CustProductPurchaseRepository;
import com.brijframework.ordering.rest.purchase.CustProductPurchaseAdditional;
import com.brijframework.ordering.rest.purchase.CustProductPurchaseItemRequest;
import com.brijframework.ordering.rest.purchase.CustProductPurchaseRequest;
import com.brijframework.ordering.rest.purchase.CustProductPurchaseResponse;
import com.brijframework.ordering.service.CustProductPurchaseService;
import com.brijframework.ordering.util.CommanUtil;

@Service
public class CustProductPurchaseServiceImpl implements CustProductPurchaseService {
	
	private static final String CPL = "CPL";
	
	@Autowired
	private CustProductPurchaseRepository custProductPurchaseRepository;
	
	@Autowired
	private CustProductPurchaseItemRepository custProductPurchaseItemRepository;
	
	@Autowired
	private  CustBusinessAppRepository custBusinessAppRepository;
	
	@Autowired
	private CustProductPurchaseRequestMapper custProductPurchaseRequestMapper;
	
	@Autowired
	private CustProductPurchaseResponseMapper custProductPurchaseResponseMapper; 
	
	@Autowired
	private CustProductPurchaseAdditionalRepository custProductPurchaseAdditionalRepository;
	
	@Override
	public CustProductPurchaseResponse saveProductPurchase(long custAppId, CustProductPurchaseRequest custProductPurchaseRequest) {
		Optional<EOCustBusinessApp> findById = custBusinessAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		EOCustBusinessApp eoCustBusinessApp = findById.get();
		EOCustProductPurchase eoCustProductPurchase = saveCustProductPurchase(custProductPurchaseRequest, eoCustBusinessApp);
		return custProductPurchaseResponseMapper.mapToDTO(eoCustProductPurchase);
	}

	private EOCustProductPurchase saveCustProductPurchase(CustProductPurchaseRequest custProductPurchaseRequest,
			EOCustBusinessApp eoCustBusinessApp) {
		List<CustProductPurchaseItemRequest> custProductPurchaseItemList = custProductPurchaseRequest.getCustProductPurchaseItemList();
		List<CustProductPurchaseAdditional> custProductAdditionalList = custProductPurchaseRequest.getCustProductPurchaseAdditionalList();
		custProductPurchaseRequest.setCustProductPurchaseItemList(null);
		custProductPurchaseRequest.setCustProductPurchaseAdditionalList(null);
		
		EOCustProductPurchase eoCustProductPurchase = custProductPurchaseRequestMapper.mapToDAO(custProductPurchaseRequest);
		eoCustProductPurchase.setUserId(custProductPurchaseRequest.getUserId());
		eoCustProductPurchase.setSupplierId(custProductPurchaseRequest.getSupplierId());
		eoCustProductPurchase.setRecordState(RecordStatus.ACTIVETED.getStatus());
		if(custProductPurchaseRequest.getId()==null) {
			eoCustProductPurchase.setIdenNo(CommanUtil. getIdenNo(CPL));
		}
		eoCustProductPurchase.setCustBusinessApp(eoCustBusinessApp);
		eoCustProductPurchase = custProductPurchaseRepository.saveAndFlush(eoCustProductPurchase);
		
		for(EOCustProductPurchaseAdditional custProductAdditional: custProductPurchaseRequestMapper.custProductPurchaseAdditionalListDAO(custProductAdditionalList)){
			custProductAdditional.setCustProductPurchase(eoCustProductPurchase);
			custProductPurchaseAdditionalRepository.saveAndFlush(custProductAdditional);
		};
		
		for(CustProductPurchaseItemRequest custProductRetailPurchaseUi : custProductPurchaseItemList){
			EOCustProductPurchaseItem eoCustProductRetailPurchase = custProductPurchaseRequestMapper.mapToDAO(custProductRetailPurchaseUi);
			eoCustProductRetailPurchase.setCustProductPurchase(eoCustProductPurchase);
			EOCustProductPurchaseItemPrice purchasePrice = eoCustProductRetailPurchase.getPurchasePrice();
			EOCustProductPurchaseItem saveCustProductRetailPurchase=custProductPurchaseItemRepository.saveAndFlush(eoCustProductRetailPurchase);
			purchasePrice.setCustProductPurchaseItem(saveCustProductRetailPurchase);
			//custProductStockService.saveCustProductStocksBackground(saveCustProductRetailPurchase); 
		}
		return eoCustProductPurchase;
	}

	@Override
	public CustProductPurchaseResponse updateProductPurchase(long custAppId, CustProductPurchaseRequest custProductPurchaseRequest) {
		Optional<EOCustBusinessApp> findById = custBusinessAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		EOCustBusinessApp eoCustBusinessApp = findById.get();
		EOCustProductPurchase eoCustProductPurchase = saveCustProductPurchase(custProductPurchaseRequest, eoCustBusinessApp);
		return custProductPurchaseResponseMapper.mapToDTO(eoCustProductPurchase);
	}

	@Override
	public List<CustProductPurchaseResponse> getProductPurchaseList(long custAppId, long userId) {
		return custProductPurchaseResponseMapper.mapToDTO(custProductPurchaseRepository.findAllByCustBusinessAppIdAndUserIdAndRecordState(custAppId, userId, RecordStatus.ACTIVETED.getStatus()));
	}
		
	@Override
	public List<CustProductPurchaseResponse> getProductPurchaseListBySupplier(long custAppId, Long customerId) {
		return custProductPurchaseResponseMapper.mapToDTO(custProductPurchaseRepository.findAllByCustBusinessAppIdAndSupplierId(custAppId, customerId));
	}
	
	@Override
	public List<CustProductPurchaseResponse> getProductPurchaseListByUser(long custAppId, Long userId) {
		return custProductPurchaseResponseMapper.mapToDTO(custProductPurchaseRepository.findAllByCustBusinessAppIdAndUserIdAndRecordState(custAppId, userId, RecordStatus.ACTIVETED.getStatus()));
	}

	@Override
	public CustProductPurchaseResponse getProductPurchase(long custAppId, String typeId) {
		return custProductPurchaseResponseMapper.mapToDTO(custProductPurchaseRepository.findByCustBusinessAppIdAndTypeIdAndRecordState(custAppId, typeId, RecordStatus.ACTIVETED.getStatus()));
	}

	@Override
	public List<CustProductPurchaseResponse> filterProductPurchaseList(long custAppId, LocalDateTime fromDate,
			LocalDateTime toDate) {
		LocalDateTime toDateOf = LocalDateTime.of(toDate.getYear(), toDate.getMonth(), toDate.getDayOfMonth(), 23, 59,59);
		return custProductPurchaseResponseMapper.mapToDTO(custProductPurchaseRepository.filterProductPurchaseList(custAppId, fromDate, toDateOf));
	}
	
	@Override
	public List<CustProductPurchaseResponse> filterProductPurchaseList(long custAppId, Long supplierId, LocalDateTime fromDate,
			LocalDateTime toDate) {
		LocalDateTime toDateOf = LocalDateTime.of(toDate.getYear(), toDate.getMonth(), toDate.getDayOfMonth(), 23, 59,59);
		return custProductPurchaseResponseMapper.mapToDTO(custProductPurchaseRepository.filterProductPurchaseList(custAppId, supplierId, fromDate, toDateOf));
	}

	@Override
	public boolean deleteProductPurchase(long custAppId, Long id) {
		Optional<EOCustProductPurchase> findById = custProductPurchaseRepository.findById(id);
		if(findById.isPresent()) {
			EOCustProductPurchase eoCustProductPurchase = findById.get();
			eoCustProductPurchase.setRecordState(RecordStatus.DACTIVETED.getStatus());
			custProductPurchaseRepository.save(eoCustProductPurchase);
		}
		return true;
	}

}
