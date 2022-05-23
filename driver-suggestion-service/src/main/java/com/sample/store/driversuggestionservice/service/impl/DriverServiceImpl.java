package com.sample.store.driversuggestionservice.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.store.driversuggestionservice.dto.DriverDetailsDTO;
import com.sample.store.driversuggestionservice.entity.DriverDetail;
import com.sample.store.driversuggestionservice.entity.StoreDetail;
import com.sample.store.driversuggestionservice.repository.DriverDetailRepository;
import com.sample.store.driversuggestionservice.repository.StoreDetailRepository;
import com.sample.store.driversuggestionservice.service.DriverService;

@Service
public class DriverServiceImpl implements DriverService{
	private final Logger logger = LoggerFactory.getLogger(DriverServiceImpl.class);

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;


	@Value(value = "${kafka.topic.driver}")
	private String topicName;

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private DriverDetailRepository driverDetailRepository ;
	
	@Autowired
	private StoreDetailRepository storeDetailRepository ;
	
	@Override
	public void publishToKafka(final DriverDetailsDTO driverDetailsDTO) {
	    try {
			kafkaTemplate.send(topicName, mapper.writeValueAsString(driverDetailsDTO));
		} catch (JsonProcessingException e) {
			logger.error("Exception while Converting Object to json");
		}
	}
	
	@Override
	public void saveDriverDetails(final DriverDetail driverDetail) {
		driverDetailRepository.save(driverDetail);
	}

	@Override
	public List<DriverDetail> getNearestNDrivers(String storeId, Integer numberOfDrivers) throws Exception {
		StoreDetail storeDetail=storeDetailRepository.findById(storeId).orElseThrow(()->new Exception());
		return driverDetailRepository.getNearestStore(storeDetail.getLatitude(), storeDetail.getLongitude(),
				PageRequest.of(0, numberOfDrivers));
	}
	
}
