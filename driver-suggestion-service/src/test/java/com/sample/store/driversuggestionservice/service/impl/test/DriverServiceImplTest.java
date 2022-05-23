package com.sample.store.driversuggestionservice.service.impl.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.kafka.core.KafkaTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.store.driversuggestionservice.dto.DriverDetailsDTO;
import com.sample.store.driversuggestionservice.entity.DriverDetail;
import com.sample.store.driversuggestionservice.entity.StoreDetail;
import com.sample.store.driversuggestionservice.repository.DriverDetailRepository;
import com.sample.store.driversuggestionservice.repository.StoreDetailRepository;
import com.sample.store.driversuggestionservice.service.impl.DriverServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class DriverServiceImplTest {

	@InjectMocks
	private  DriverServiceImpl  driverServiceImpl;

    @Mock
    private DriverDetailRepository driverDetailRepository;
    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    @Mock
    private StoreDetailRepository storeDetailRepository;
    @Mock
    private ObjectMapper mapper;

    private DriverDetail driverDetail;
    private List<DriverDetail> driverDetails;
    private DriverDetailsDTO driverDetailsDTO;
    private StoreDetail storeDetail;
    
    

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        
        driverDetail=new DriverDetail("1", 1.0, 1.9);
        driverDetailsDTO=new DriverDetailsDTO("1", 1.0, 1.9);
        storeDetail=new StoreDetail("1", 1.0, 1.9);
        driverDetails=new ArrayList();
        driverDetails.add(driverDetail);
    }
    

    @Test
    public void testSaveStoreInfo() {
    	driverServiceImpl.saveDriverDetails(driverDetail);
    }

    @Test
    public void testPublishToKafka() {
    	driverServiceImpl.publishToKafka(driverDetailsDTO);
    }

    @Test
    public void testPublishToKafkaException() throws JsonProcessingException {
        Mockito.when(mapper.writeValueAsString(Mockito.any(DriverDetailsDTO.class))).thenThrow(JsonProcessingException.class);
    	driverServiceImpl.publishToKafka(driverDetailsDTO);
    }
    
    @Test
    public void testGetNearestNDrivers() throws Exception {
        Mockito.when(storeDetailRepository.findById(Mockito.anyString())).thenReturn(Optional.of(storeDetail));
       Mockito.when(driverDetailRepository.getNearestStore(Mockito.any(),
    		   Mockito.any(), Mockito.any())).thenReturn(driverDetails);
        Assert.assertNotNull(driverServiceImpl.getNearestNDrivers("1", 1));
    }

}
