package com.flipkart.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.flipkart.dao.MerchantDao;
import com.flipkart.exception.FlipkartException;
import com.flipkart.model.Merchant;
import com.flipkart.request.MerchantDTO;

@RunWith(SpringJUnit4ClassRunner.class)
public class MerchantServiceImplTest {

	private static final String FIRSTNAME = "John";
	private static final String LASTNAME = "Smith";
	private static final String GENDER = "Male";
	private static final String COUNTRY = "INDIA";
	private static final String PASSWORD = "Joha@1234";
	private static final String EMAIL = "john@gmail.com";

	@InjectMocks
	private MerchantServiceImpl merchantServiceImpl;

	@Mock
	private MerchantDao merchantDao;

	@Test
	public void registerMerchant_Success() throws FlipkartException {
		Merchant merchant = merchant();
		MerchantDTO merchantDTO = MerchantDTO.builder().country(COUNTRY).email(EMAIL).firstName(FIRSTNAME)
				.gender(GENDER).lastName(LASTNAME).password(PASSWORD).build();
		Mockito.when(merchantDao.findByEmail(Mockito.anyString())).thenReturn(null);
		Mockito.when(merchantDao.save(Mockito.any())).thenReturn(merchant);
		Merchant registerMerchant = merchantServiceImpl.registerMerchant(merchantDTO);
		Assert.assertNotNull(registerMerchant);
		assertEquals(registerMerchant, merchant);
	}
	
	@Test(expected = FlipkartException.class)
	public void registerMerchant_ShouldThrowMerchantAlreadyRegister() throws FlipkartException {
		Merchant merchant = merchant();
		MerchantDTO merchantDTO = MerchantDTO.builder().country(COUNTRY).email(EMAIL).firstName(FIRSTNAME)
				.gender(GENDER).lastName(LASTNAME).password(PASSWORD).build();
		Mockito.when(merchantDao.findByEmail(Mockito.anyString())).thenReturn(merchant);
		Merchant registerMerchant = merchantServiceImpl.registerMerchant(merchantDTO);
	}


	private Merchant merchant() {
		return Merchant.builder().id(1L).country(COUNTRY).email(EMAIL).firstName(FIRSTNAME).gender(GENDER)
				.lastName(LASTNAME).password(PASSWORD).build();
	}

}
