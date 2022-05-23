package com.sample.store.driversuggestionservice.service;

import com.sample.store.driversuggestionservice.dto.StoreRequestDTO;
import com.sample.store.driversuggestionservice.entity.StoreDetail;

public interface StoreService {

	 StoreDetail saveStoreInfo(final StoreRequestDTO storeRequestDTO);
}
