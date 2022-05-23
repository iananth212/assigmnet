package com.sample.store.driversuggestionservice.consumer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.store.driversuggestionservice.config.Constants;
import com.sample.store.driversuggestionservice.entity.DriverDetail;
import com.sample.store.driversuggestionservice.service.DriverService;

@Component
public class DriverDetailsKafkaConsumer {
	@Value(value = "${kafka.bootstrapAddress}")
	private String bootstrapAddress;

	@Autowired
	private ObjectMapper mapper;
	private final Logger logger = LoggerFactory.getLogger(DriverDetailsKafkaConsumer.class);
	
	@Autowired
	private DriverService driverService;
	
	@KafkaListener(topics = Constants.TOPIC_NAME, groupId = Constants.GROUP_ID)
	public void listenGroupFoo(String message) {
	    System.out.println("Received Message in group foo: " + message);
		try {
			DriverDetail driverDetail=mapper.readValue(message, DriverDetail.class);
			driverService.saveDriverDetails(driverDetail);
		} catch (IOException ex) {
			logger.error("Error while converting Input to Type DriverDetailsDTO : ".concat(ex.getMessage()));
		}

	}
	
}
