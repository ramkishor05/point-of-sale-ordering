package com.brijframework.ordering.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brijframework.ordering.entities.EOCustBusinessApp;
import com.brijframework.ordering.entities.cart.EOCustCartSale;
import com.brijframework.ordering.entities.cart.EOCustCartSaleAdditional;
import com.brijframework.ordering.entities.cart.EOCustCartSaleItem;
import com.brijframework.ordering.mapper.cart.CustCartSaleRequestMapper;
import com.brijframework.ordering.mapper.cart.CustCartSaleResponseMapper;
import com.brijframework.ordering.repository.CustBusinessAppRepository;
import com.brijframework.ordering.repository.cart.CustCartSaleAdditionalRepository;
import com.brijframework.ordering.repository.cart.CustCartSaleItemRepository;
import com.brijframework.ordering.repository.cart.CustCartSaleRepository;
import com.brijframework.ordering.rest.cart.CustCartSaleAdditional;
import com.brijframework.ordering.rest.cart.CustCartSaleItemRequest;
import com.brijframework.ordering.rest.cart.CustCartSaleRequest;
import com.brijframework.ordering.rest.cart.CustCartSaleResponse;
import com.brijframework.ordering.service.CustCartSaleService;
import com.brijframework.ordering.util.CommanUtil;

@Service
public class CustCartSaleServiceImpl implements CustCartSaleService {
	
	
	private static final String CRT = "CRT";

	@Autowired
	private CustCartSaleRepository custCartSaleRepository;
	
	@Autowired
	private CustCartSaleItemRepository custProductSaleItemRepository;
	
	@Autowired
	private  CustBusinessAppRepository custBusinessAppRepository;
	
	@Autowired
	private CustCartSaleRequestMapper custCartSaleRequestMapper;
	
	@Autowired
	private CustCartSaleResponseMapper custCartSaleResponseMapper; 
	
	@Autowired
	private CustCartSaleAdditionalRepository custCartSaleAdditionalRepository;
	
	@Override
	public CustCartSaleResponse saveCartSale(long custAppId, CustCartSaleRequest custCartSaleRequest) {
		Optional<EOCustBusinessApp> findById = custBusinessAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		EOCustBusinessApp eoCustBusinessApp = findById.get();
		EOCustCartSale eoCustCartSale = saveCustCartSale(custCartSaleRequest, eoCustBusinessApp);
		return custCartSaleResponseMapper.mapToDTO(eoCustCartSale);
	}

	private EOCustCartSale saveCustCartSale(CustCartSaleRequest custCartSaleRequest, EOCustBusinessApp eoCustBusinessApp) {
		List<CustCartSaleItemRequest> custCartSaleItemList = custCartSaleRequest.getCustCartSaleItemList();
		List<CustCartSaleAdditional> custProductAdditionalList = custCartSaleRequest.getCustCartSaleAdditionalList();
		custCartSaleRequest.setCustCartSaleItemList(null);
		custCartSaleRequest.setCustCartSaleAdditionalList(null);
		
		EOCustCartSale eoCustCartSale = custCartSaleRequestMapper.mapToDAO(custCartSaleRequest);
		eoCustCartSale.setUserId(custCartSaleRequest.getUserId());
		eoCustCartSale.setCustomerId(custCartSaleRequest.getCustomerId());
		if(custCartSaleRequest.getId()==null) {
			eoCustCartSale.setIdenNo(CommanUtil. getIdenNo(CRT));
		}
		eoCustCartSale.setCustBusinessApp(eoCustBusinessApp);
		eoCustCartSale = custCartSaleRepository.saveAndFlush(eoCustCartSale);
		
		for(EOCustCartSaleAdditional custProductAdditional: custCartSaleRequestMapper.custCartSaleAdditionalListDAO(custProductAdditionalList)){
			custProductAdditional.setCustCartSale(eoCustCartSale);
			custCartSaleAdditionalRepository.saveAndFlush(custProductAdditional);
		};
		
		custProductSaleItemRepository.deleteByCustCartSaleId(eoCustCartSale.getId());
		
		for(CustCartSaleItemRequest custProductRetailSaleUi : custCartSaleItemList){
			EOCustCartSaleItem eoCustProductRetailSale = custCartSaleRequestMapper.mapToDAO(custProductRetailSaleUi);
			eoCustProductRetailSale.setId(null);
			eoCustProductRetailSale.setCustCartSale(eoCustCartSale);
			custProductSaleItemRepository.saveAndFlush(eoCustProductRetailSale);
		}
		return eoCustCartSale;
	}

	@Override
	public CustCartSaleResponse updateCartSale(long custAppId, CustCartSaleRequest custCartSaleRequest) {
		Optional<EOCustBusinessApp> findById = custBusinessAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		EOCustBusinessApp eoCustBusinessApp = findById.get();
		EOCustCartSale eoCustCartSale = saveCustCartSale(custCartSaleRequest, eoCustBusinessApp);
		return custCartSaleResponseMapper.mapToDTO(eoCustCartSale);
	}

	@Override
	public List<CustCartSaleResponse> getCartSaleList(long custAppId, long userId) {
		return custCartSaleResponseMapper.mapToDTO(custCartSaleRepository.findAllByCustBusinessAppId(custAppId));
	}
	
	@Override
	public CustCartSaleResponse currentCartSale(long custAppId, long userId) {
		List<EOCustCartSale> eoCustCartSales = custCartSaleRepository.findByCustBusinessAppIdAndUserId(custAppId, userId);
		if(eoCustCartSales.isEmpty()) {
			CustCartSaleRequest custCartSaleRequest = new CustCartSaleRequest();
			custCartSaleRequest.setUserId(userId);
			return saveCartSale(custAppId, custCartSaleRequest);
		}
		return custCartSaleResponseMapper.mapToDTO(eoCustCartSales.get(0));
	}

	@Override
	public CustCartSaleResponse getCartSale(long custAppId, String typeId) {
		return custCartSaleResponseMapper.mapToDTO(custCartSaleRepository.findByCustBusinessAppIdAndTypeId(custAppId, typeId));
	}

	@Override
	public List<CustCartSaleResponse> filterCartSaleList(long custAppId, LocalDateTime fromDate, LocalDateTime toDate) {
		LocalDateTime toDateOf = LocalDateTime.of(toDate.getYear(), toDate.getMonth(), toDate.getDayOfMonth(), 23, 59,59);
		return custCartSaleResponseMapper.mapToDTO(custCartSaleRepository.filterCartSaleList(custAppId, fromDate, toDateOf));
	}

	@Override
	public boolean deleteCartSale(long custAppId, Long id) {
		custCartSaleRepository.deleteById(id);
		return true;
	}

	@Override
	public List<CustCartSaleResponse> getCartSaleListBySupplier(long custAppId, Long customerId) {
		return custCartSaleResponseMapper.mapToDTO(custCartSaleRepository.findByCustBusinessAppIdAndCustomerId(custAppId, customerId));
	}
	
	@Override
	public List<CustCartSaleResponse> getCartSaleListByUser(long custAppId, Long userId) {
		return custCartSaleResponseMapper.mapToDTO(custCartSaleRepository.findByCustBusinessAppIdAndUserId(custAppId, userId));
	}

	@Override
	public List<CustCartSaleResponse> filterCartSaleList(long custAppId, Long customerId, LocalDateTime fromDate,
			LocalDateTime toDate) {
		return null;
	}
}
