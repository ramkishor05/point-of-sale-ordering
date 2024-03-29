package com.brijframework.ordering.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.brijframework.ordering.entities.EOCustBusinessApp;
import com.brijframework.ordering.entities.sales.EOCustProductSale;
import com.brijframework.ordering.entities.sales.EOCustProductSaleAdditional;
import com.brijframework.ordering.entities.sales.EOCustProductSaleItem;
import com.brijframework.ordering.mapper.orders.CustProductSaleRequestMapper;
import com.brijframework.ordering.mapper.orders.CustProductSaleResponseMapper;
import com.brijframework.ordering.repository.CustBusinessAppRepository;
import com.brijframework.ordering.repository.CustProductSaleAdditionalRepository;
import com.brijframework.ordering.repository.CustProductSaleItemRepository;
import com.brijframework.ordering.repository.CustProductSaleRepository;
import com.brijframework.ordering.rest.sale.CustProductSaleAdditional;
import com.brijframework.ordering.rest.sale.CustProductSaleItemRequest;
import com.brijframework.ordering.rest.sale.CustProductSaleRequest;
import com.brijframework.ordering.rest.sale.CustProductSaleResponse;
import com.brijframework.ordering.service.CustProductSaleService;
import com.brijframework.ordering.util.CommanUtil;

@Service
public class CustProductSaleServiceImpl implements CustProductSaleService {
	
	
	private static final String CSL = "CSL";

	@Autowired
	private CustProductSaleRepository custProductSaleRepository;
	
	@Autowired
	private CustProductSaleItemRepository custProductRetailSaleRepository;
	
	@Autowired
	private  CustBusinessAppRepository custBusinessAppRepository;
	
	@Autowired
	private CustProductSaleRequestMapper custProductSaleRequestMapper;
	
	@Autowired
	private CustProductSaleResponseMapper custProductSaleResponseMapper; 
	
	@Autowired
	private CustProductSaleAdditionalRepository custProductSaleAdditionalRepository;
	
	@Override
	public CustProductSaleResponse saveProductSale(long custAppId, CustProductSaleRequest custProductSaleRequest) {
		Optional<EOCustBusinessApp> findById = custBusinessAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		EOCustBusinessApp eoCustBusinessApp = findById.get();
		EOCustProductSale eoCustProductSale = saveCustProductSale(custProductSaleRequest, eoCustBusinessApp);
		return custProductSaleResponseMapper.mapToDTO(eoCustProductSale);
	}

	private EOCustProductSale saveCustProductSale(CustProductSaleRequest custProductSaleRequest,
			EOCustBusinessApp eoCustBusinessApp) {
		List<CustProductSaleItemRequest> custProductSaleItemList = custProductSaleRequest.getCustProductSaleItemList();
		List<CustProductSaleAdditional> custProductAdditionalList = custProductSaleRequest.getCustProductSaleAdditionalList();
		custProductSaleRequest.setCustProductSaleItemList(null);
		custProductSaleRequest.setCustProductSaleAdditionalList(null);
		
		EOCustProductSale eoCustProductSale = custProductSaleRequestMapper.mapToDAO(custProductSaleRequest);
		eoCustProductSale.setUserId(custProductSaleRequest.getUserId());
		eoCustProductSale.setCustomerId(custProductSaleRequest.getCustomerId());
		if(custProductSaleRequest.getId()==null) {
			eoCustProductSale.setIdenNo(CommanUtil. getIdenNo(CSL));
		}
		eoCustProductSale.setCustBusinessApp(eoCustBusinessApp);
		eoCustProductSale = custProductSaleRepository.saveAndFlush(eoCustProductSale);
		
		List<EOCustProductSaleAdditional> custProductSaleAdditionalListDAO = custProductSaleRequestMapper.custProductSaleAdditionalListDAO(custProductAdditionalList);
		if(!CollectionUtils.isEmpty(custProductSaleAdditionalListDAO))
		for(EOCustProductSaleAdditional custProductAdditional:custProductSaleAdditionalListDAO ){
			custProductAdditional.setCustProductSale(eoCustProductSale);
			custProductSaleAdditionalRepository.saveAndFlush(custProductAdditional);
		};
		custProductRetailSaleRepository.deleteByCustProductSaleId(eoCustProductSale.getId());
		for(CustProductSaleItemRequest custProductRetailSaleUi : custProductSaleItemList){
			EOCustProductSaleItem eoCustProductRetailSale = custProductSaleRequestMapper.mapToDAO(custProductRetailSaleUi);
			eoCustProductRetailSale.setId(null);
			eoCustProductRetailSale.setCustProductSale(eoCustProductSale);
			custProductRetailSaleRepository.saveAndFlush(eoCustProductRetailSale);
		}
		
		return eoCustProductSale;
	}

	@Override
	public CustProductSaleResponse updateProductSale(long custAppId, CustProductSaleRequest custProductSaleRequest) {
		Optional<EOCustBusinessApp> findById = custBusinessAppRepository.findById(custAppId);
		if(!findById.isPresent()) {
			return null;
		}
		EOCustBusinessApp eoCustBusinessApp = findById.get();
		EOCustProductSale eoCustProductSale = saveCustProductSale(custProductSaleRequest, eoCustBusinessApp);
		return custProductSaleResponseMapper.mapToDTO(eoCustProductSale);
	}

	@Override
	public List<CustProductSaleResponse> getProductSaleList(long custAppId) {
		return custProductSaleResponseMapper.mapToDTO(custProductSaleRepository.findAllByCustBusinessAppId(custAppId));
	}

	@Override
	public CustProductSaleResponse getProductSale(long custAppId, String typeId) {
		return custProductSaleResponseMapper.mapToDTO(custProductSaleRepository.findByCustBusinessAppIdAndTypeId(custAppId, typeId));
	}

	@Override
	public List<CustProductSaleResponse> filterProductSaleList(long custAppId, LocalDateTime fromDate,
			LocalDateTime toDate) {
		LocalDateTime toDateOf = LocalDateTime.of(toDate.getYear(), toDate.getMonth(), toDate.getDayOfMonth(), 23, 59,59);
		return custProductSaleResponseMapper.mapToDTO(custProductSaleRepository.filterProductSaleList(custAppId, fromDate, toDateOf));
	}

	@Override
	public boolean deleteProductSale(long custAppId, Long id) {
		custProductSaleRepository.deleteById(id);
		return true;
	}

	@Override
	public List<CustProductSaleResponse> getProductSaleListBySupplier(long custAppId, Long customerId) {
		return custProductSaleResponseMapper.mapToDTO(custProductSaleRepository.findByCustBusinessAppIdAndCustomerId(custAppId, customerId));

	}
	
	@Override
	public List<CustProductSaleResponse> getProductSaleListByUser(long custAppId, Long userId) {
		return custProductSaleResponseMapper.mapToDTO(custProductSaleRepository.findByCustBusinessAppIdAndUserId(custAppId, userId));
	}
}
