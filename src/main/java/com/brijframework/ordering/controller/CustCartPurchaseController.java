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

import com.brijframework.ordering.rest.cart.CustCartPurchaseRequest;
import com.brijframework.ordering.rest.cart.CustCartPurchaseResponse;
import com.brijframework.ordering.service.CustCartPurchaseService;

@RestController
@RequestMapping("/api/cust/cart/purchase")
public class CustCartPurchaseController {

	
	@Autowired
	private CustCartPurchaseService custCartPurchaseService;
	
	@GetMapping
	public CustCartPurchaseResponse currentCartPurchase(@RequestHeader(CUST_APP_ID) long custAppId, @RequestHeader(USER_APP_ID) Long userId) {
		return custCartPurchaseService.currentCartPurchase(custAppId, userId);
	}
	
	@PostMapping
	public CustCartPurchaseResponse addCartPurchase(@RequestHeader(CUST_APP_ID) long custAppId,@RequestHeader(USER_APP_ID) long userId, @RequestBody CustCartPurchaseRequest custCartPurchaseRequest) {
		custCartPurchaseRequest.setUserId(userId);
		return custCartPurchaseService.saveCartPurchase(custAppId,custCartPurchaseRequest);
	}
	
	@PutMapping
	public CustCartPurchaseResponse updateCartPurchase(@RequestHeader(CUST_APP_ID) long custAppId,@RequestHeader(USER_APP_ID) long userId,@RequestBody CustCartPurchaseRequest custCartPurchaseRequest) {
		custCartPurchaseRequest.setUserId(userId);
		return custCartPurchaseService.updateCartPurchase(custAppId,custCartPurchaseRequest);
	}
	
	@DeleteMapping
	public boolean deleteCartPurchase(@RequestHeader(CUST_APP_ID) long custAppId,@RequestHeader(USER_APP_ID) Long id) {
		return custCartPurchaseService.deleteCartPurchase(custAppId, id);
	}
	
}
