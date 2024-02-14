package com.brijframework.ordering.controller;

import static com.brijframework.ordering.contants.Constants.CUST_APP_ID;
import static com.brijframework.ordering.contants.Constants.USER_APP_ID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brijframework.ordering.rest.cart.CustCartSaleRequest;
import com.brijframework.ordering.rest.cart.CustCartSaleResponse;
import com.brijframework.ordering.service.CustCartSaleService;

@RestController
@RequestMapping("/api/cust/cart/sale")
public class CustCartSaleController {

	
	@Autowired
	private CustCartSaleService custCartSaleService;
	
	@GetMapping
	public CustCartSaleResponse currentCartSale(@RequestHeader(CUST_APP_ID) long custAppId, @RequestHeader(USER_APP_ID) Long userId) {
		return custCartSaleService.currentCartSale(custAppId, userId);
	}
	
	@PostMapping
	public CustCartSaleResponse addCartSale(@RequestHeader(CUST_APP_ID) long custAppId,@RequestHeader(USER_APP_ID) long userId, @RequestBody CustCartSaleRequest custCartSaleRequest) {
		custCartSaleRequest.setUserId(userId);
		return custCartSaleService.saveCartSale(custAppId,custCartSaleRequest);
	}
	
	@PutMapping
	public CustCartSaleResponse updateCartSale(@RequestHeader(CUST_APP_ID) long custAppId,@RequestHeader(USER_APP_ID) long userId,@RequestBody CustCartSaleRequest custCartSaleRequest) {
		custCartSaleRequest.setUserId(userId);
		return custCartSaleService.updateCartSale(custAppId,custCartSaleRequest);
	}
	
	@DeleteMapping
	public boolean deleteCartSale(@RequestHeader(CUST_APP_ID) long custAppId,@RequestHeader(USER_APP_ID) Long id) {
		return custCartSaleService.deleteCartSale(custAppId, id);
	}
	
}
