package com.brijframework.ordering.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.ordering.contants.RecordStatus;
import com.brijframework.ordering.entities.EOCustBusinessApp;
import com.brijframework.ordering.entities.cart.EOCustCartPurchase;
import com.brijframework.ordering.entities.cart.EOCustCartPurchaseAdditional;
import com.brijframework.ordering.entities.cart.EOCustCartPurchaseItem;
import com.brijframework.ordering.entities.cart.EOCustCartPurchaseItemPrice;
import com.brijframework.ordering.mapper.cart.CustCartPurchaseRequestMapper;
import com.brijframework.ordering.mapper.cart.CustCartPurchaseResponseMapper;
import com.brijframework.ordering.repository.CustBusinessAppRepository;
import com.brijframework.ordering.repository.cart.CustCartPurchaseAdditionalRepository;
import com.brijframework.ordering.repository.cart.CustCartPurchaseItemRepository;
import com.brijframework.ordering.repository.cart.CustCartPurchaseRepository;
import com.brijframework.ordering.rest.cart.CustCartPurchaseAdditional;
import com.brijframework.ordering.rest.cart.CustCartPurchaseItemRequest;
import com.brijframework.ordering.rest.cart.CustCartPurchaseRequest;
import com.brijframework.ordering.rest.cart.CustCartPurchaseResponse;
import com.brijframework.ordering.service.CustCartPurchaseService;
import com.brijframework.ordering.util.CommanUtil;

@Service
public class CustCartPurchaseServiceImpl implements CustCartPurchaseService {
	
	private static final String CPL = "CPL";
	
	@Autowired
	private CustCartPurchaseRepository custCartPurchaseRepository;
	
	@Autowired
	private CustCartPurchaseItemRepository custCartPurchaseItemRepository;
	
	@Autowired
	private  CustBusinessAppRepository custBusinessAppRepository;
	
	@Autowired
	private CustCartPurchaseRequestMapper custCartPurchaseRequestMapper;
	
	@Autowired
	private CustCartPurchaseResponseMapper custCartPurchaseResponseMapper; 
	
	@Autowired
	private CustCartPurchaseAdditionalRepository custCartPurchaseAdditionalRepository;
	
	@Override
	public CustCartPurchaseResponse saveCartPurchase(long custAppId, CustCartPurchaseRequest custCartPurchaseRequest) {
		Optional<EOCustBusinessApp> findById = custBusinessAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		EOCustBusinessApp eoCustBusinessApp = findById.get();
		EOCustCartPurchase eoCustCartPurchase = saveCustCartPurchase(custCartPurchaseRequest, eoCustBusinessApp);
		return custCartPurchaseResponseMapper.mapToDTO(eoCustCartPurchase);
	}

	private EOCustCartPurchase saveCustCartPurchase(CustCartPurchaseRequest custCartPurchaseRequest,
			EOCustBusinessApp eoCustBusinessApp) {
		List<CustCartPurchaseItemRequest> custCartPurchaseItemList = custCartPurchaseRequest.getCustCartPurchaseItemList();
		List<CustCartPurchaseAdditional> custCartAdditionalList = custCartPurchaseRequest.getCustCartPurchaseAdditionalList();
		custCartPurchaseRequest.setCustCartPurchaseItemList(null);
		custCartPurchaseRequest.setCustCartPurchaseAdditionalList(null);
		
		EOCustCartPurchase eoCustCartPurchase = custCartPurchaseRequestMapper.mapToDAO(custCartPurchaseRequest);
		eoCustCartPurchase.setUserId(custCartPurchaseRequest.getUserId());
		eoCustCartPurchase.setSupplierId(custCartPurchaseRequest.getSupplierId());
		eoCustCartPurchase.setRecordState(RecordStatus.ACTIVETED.getStatus());
		if(custCartPurchaseRequest.getId()==null) {
			eoCustCartPurchase.setIdenNo(CommanUtil. getIdenNo(CPL));
		}
		eoCustCartPurchase.setCustBusinessApp(eoCustBusinessApp);
		eoCustCartPurchase = custCartPurchaseRepository.saveAndFlush(eoCustCartPurchase);
		
		for(EOCustCartPurchaseAdditional custCartAdditional: custCartPurchaseRequestMapper.custCartPurchaseAdditionalListDAO(custCartAdditionalList)){
			custCartAdditional.setCustCartPurchase(eoCustCartPurchase);
			custCartPurchaseAdditionalRepository.saveAndFlush(custCartAdditional);
		};
		
		custCartPurchaseItemRepository.deleteByCustCartPurchaseId(eoCustCartPurchase.getId());
		
		for(CustCartPurchaseItemRequest custCartRetailPurchaseUi : custCartPurchaseItemList){
			EOCustCartPurchaseItem eoCustCartRetailPurchase = custCartPurchaseRequestMapper.mapToDAO(custCartRetailPurchaseUi);
			eoCustCartRetailPurchase.setCustCartPurchase(eoCustCartPurchase);
			EOCustCartPurchaseItemPrice purchasePrice = eoCustCartRetailPurchase.getPurchasePrice();
			EOCustCartPurchaseItem saveCustCartRetailPurchase=custCartPurchaseItemRepository.saveAndFlush(eoCustCartRetailPurchase);
			purchasePrice.setCustCartPurchaseItem(saveCustCartRetailPurchase);
			//custCartStockService.saveCustCartStocksBackground(saveCustCartRetailPurchase); 
		}
		return eoCustCartPurchase;
	}

	@Override
	public CustCartPurchaseResponse updateCartPurchase(long custAppId, CustCartPurchaseRequest custCartPurchaseRequest) {
		Optional<EOCustBusinessApp> findById = custBusinessAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		EOCustBusinessApp eoCustBusinessApp = findById.get();
		EOCustCartPurchase eoCustCartPurchase = saveCustCartPurchase(custCartPurchaseRequest, eoCustBusinessApp);
		return custCartPurchaseResponseMapper.mapToDTO(eoCustCartPurchase);
	}

	@Override
	public List<CustCartPurchaseResponse> getCartPurchaseList(long custAppId, long userId) {
		return custCartPurchaseResponseMapper.mapToDTO(custCartPurchaseRepository.findAllByCustBusinessAppIdAndUserIdAndRecordState(custAppId, userId, RecordStatus.ACTIVETED.getStatus()));
	}
		
	@Override
	public List<CustCartPurchaseResponse> getCartPurchaseListBySupplier(long custAppId, Long customerId) {
		return custCartPurchaseResponseMapper.mapToDTO(custCartPurchaseRepository.findAllByCustBusinessAppIdAndSupplierId(custAppId, customerId));
	}
	
	@Override
	public List<CustCartPurchaseResponse> getCartPurchaseListByUser(long custAppId, Long userId) {
		return custCartPurchaseResponseMapper.mapToDTO(custCartPurchaseRepository.findAllByCustBusinessAppIdAndUserIdAndRecordState(custAppId, userId, RecordStatus.ACTIVETED.getStatus()));
	}
	
	@Override
	public CustCartPurchaseResponse currentCartPurchase(long custAppId, long userId) {
		List<EOCustCartPurchase> eoCustCartPurchases = custCartPurchaseRepository.findAllByCustBusinessAppIdAndUserId(custAppId, userId);
		if(eoCustCartPurchases.isEmpty()) {
			return null;
		}
		return custCartPurchaseResponseMapper.mapToDTO(eoCustCartPurchases.get(0));
	}

	@Override
	public CustCartPurchaseResponse getCartPurchase(long custAppId, String typeId) {
		return custCartPurchaseResponseMapper.mapToDTO(custCartPurchaseRepository.findByCustBusinessAppIdAndTypeIdAndRecordState(custAppId, typeId, RecordStatus.ACTIVETED.getStatus()));
	}

	@Override
	public List<CustCartPurchaseResponse> filterCartPurchaseList(long custAppId, LocalDateTime fromDate,
			LocalDateTime toDate) {
		LocalDateTime toDateOf = LocalDateTime.of(toDate.getYear(), toDate.getMonth(), toDate.getDayOfMonth(), 23, 59,59);
		return custCartPurchaseResponseMapper.mapToDTO(custCartPurchaseRepository.filterCartPurchaseList(custAppId, fromDate, toDateOf));
	}
	
	@Override
	public List<CustCartPurchaseResponse> filterCartPurchaseList(long custAppId, Long supplierId, LocalDateTime fromDate,
			LocalDateTime toDate) {
		LocalDateTime toDateOf = LocalDateTime.of(toDate.getYear(), toDate.getMonth(), toDate.getDayOfMonth(), 23, 59,59);
		return custCartPurchaseResponseMapper.mapToDTO(custCartPurchaseRepository.filterCartPurchaseList(custAppId, supplierId, fromDate, toDateOf));
	}

	@Override
	public boolean deleteCartPurchase(long custAppId, Long id) {
		Optional<EOCustCartPurchase> findById = custCartPurchaseRepository.findById(id);
		if(findById.isPresent()) {
			EOCustCartPurchase eoCustCartPurchase = findById.get();
			eoCustCartPurchase.setRecordState(RecordStatus.DACTIVETED.getStatus());
			custCartPurchaseRepository.save(eoCustCartPurchase);
		}
		return true;
	}

}
