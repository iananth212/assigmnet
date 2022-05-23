package com.sample.store.driversuggestionservice.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.store.driversuggestionservice.dto.StoreRequestDTO;
import com.sample.store.driversuggestionservice.entity.StoreDetail;
import com.sample.store.driversuggestionservice.repository.StoreDetailRepository;
import com.sample.store.driversuggestionservice.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService{

	@Autowired
	private StoreDetailRepository storeDetailRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public StoreDetail saveStoreInfo(final StoreRequestDTO storeRequestDTO) {
		StoreDetail storeDetail=modelMapper.map(storeRequestDTO, StoreDetail.class);
		return storeDetailRepository.save(storeDetail);
	}
}
