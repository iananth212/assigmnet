package com.sample.store.driversuggestionservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sample.store.driversuggestionservice.dto.DriverDetailsDTO;
import com.sample.store.driversuggestionservice.entity.DriverDetail;

@Service
public interface DriverService {

	 void publishToKafka(final DriverDetailsDTO driverDetailsDTO);
	 List<DriverDetail> getNearestNDrivers(final String storeId, final Integer numberOfDrivers) throws Exception;
	void saveDriverDetails(DriverDetail driverDetail);
}
