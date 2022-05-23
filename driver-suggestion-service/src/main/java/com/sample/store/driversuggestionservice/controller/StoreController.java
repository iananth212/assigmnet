package com.sample.store.driversuggestionservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.store.driversuggestionservice.dto.StoreRequestDTO;
import com.sample.store.driversuggestionservice.entity.StoreDetail;
import com.sample.store.driversuggestionservice.service.StoreService;

@RestController
@RequestMapping("/stores")
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@PostMapping
	public StoreDetail saveStoreInfo(@RequestBody StoreRequestDTO storeRequestDTO) {
		return storeService.saveStoreInfo(storeRequestDTO);
	}

}
