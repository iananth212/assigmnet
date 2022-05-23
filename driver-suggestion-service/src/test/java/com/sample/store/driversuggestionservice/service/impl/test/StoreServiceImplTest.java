package com.sample.store.driversuggestionservice.service.impl.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import com.sample.store.driversuggestionservice.dto.StoreRequestDTO;
import com.sample.store.driversuggestionservice.entity.StoreDetail;
import com.sample.store.driversuggestionservice.repository.StoreDetailRepository;
import com.sample.store.driversuggestionservice.service.impl.StoreServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class StoreServiceImplTest {


	@InjectMocks
	private StoreServiceImpl storeServiceImpl;

    @Mock
    private StoreDetailRepository storeDetailRepository;
    @Mock
    private ModelMapper modelMapper;

    private StoreRequestDTO storeRequestDTO; 
    private StoreDetail storeDetail;
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
		storeRequestDTO = new StoreRequestDTO("1", 1.2, 2.4);
		storeDetail = new StoreDetail("1", 1.2, 2.4);

    }
    
    
    @Test
    public void testSaveStoreInfo() {
        Mockito.when(modelMapper.map(Mockito.any(), Mockito.any())).thenReturn(storeDetail);
        Mockito.when(storeDetailRepository.save(Mockito.any())).thenReturn(storeDetail);
    	StoreDetail storeDetailObj=storeServiceImpl.saveStoreInfo((storeRequestDTO));
    	Assert.assertNotNull(storeDetailObj);
    }
    
}
