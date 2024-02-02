package com.brijframework.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brijframework.app.contants.RecordStatus;
import com.brijframework.app.dto.UIGlobalCountry;
import com.brijframework.app.service.GlobalCountryService;

@RestController
@RequestMapping("api/global/country")
public class GlobalCountryController {

	@Autowired
	GlobalCountryService globalCountryService;
	
	@PostMapping
	public UIGlobalCountry addCountry(@RequestBody UIGlobalCountry globalCountry) {
		return globalCountryService.saveCountry(globalCountry);
	}
	
	@PutMapping
	public UIGlobalCountry updateCountry(@RequestBody UIGlobalCountry globalCountry) {
		return globalCountryService.saveCountry(globalCountry);
	}
	
	@GetMapping
	public List<UIGlobalCountry> getCountryList() {
		return globalCountryService.getCountryList();
	}
	
	@GetMapping("/{id}")
	public UIGlobalCountry getCurrencyList(@PathVariable("id") Long id) {
		return globalCountryService.getCountry(id);
	}
	
	@DeleteMapping("/{id}")
	public boolean deleteCurrencyList(@PathVariable("id") Long id) {
		return globalCountryService.deleteCountry(id);
	}
	
	@GetMapping("/status/{status}")
	public List<UIGlobalCountry> getCountryList(@PathVariable("status") RecordStatus  dataStatus) {
		return globalCountryService.getCountryList(dataStatus);
	}
	
}
