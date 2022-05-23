package com.flipkart.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.flipkart.dao.ProductDao;
import com.flipkart.exception.FlipkartException;
import com.flipkart.model.Product;

@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceImplTest {

	private static final String PRODUCT_NAME = "Lenovo Laptop";
	private static final String DESCRIPTION = "Processor -Core- i9, Ram-8GB";
	private static final Integer QUANTITY = 10;
	private static final Float PRICE = 100000.50f;
	private static final Long PRODUCT_ID = 1l;
	private static final Long MERCHANT_ID = 1l;

	@InjectMocks
	private ProductServiceImpl productServiceImpl;

	@Mock
	private ProductDao productDao;

	private Product product() {
		return Product.builder().merchantId(MERCHANT_ID).id(PRODUCT_ID).price(PRICE).productName(PRODUCT_NAME)
				.quantity(QUANTITY).description(DESCRIPTION).build();
	}

	@Test
	public void getProductList_Success() throws FlipkartException {
		Product product = product();
		Pageable pageable = PageRequest.of(0, 10);
		List<Product> productList = new ArrayList<>();
		productList.add(product);
		Page<Product> pagedResponse = new PageImpl(productList);
		Mockito.when(productDao.findByMerchantId(1L, pageable)).thenReturn(pagedResponse);
		Page productResponse = productServiceImpl.getProductList(0, 10, 1L);
		Assert.assertNotNull(productResponse);
		assertEquals(productResponse.getContent().size(), 1);
	}
	
	@Test
	public void getProductList_SuccessWithEmptyList() throws FlipkartException {
		Product product = product();
		Pageable pageable = PageRequest.of(0, 10);
		List<Product> productList = new ArrayList<>();
		Page<Product> pagedResponse = new PageImpl(productList);
		Mockito.when(productDao.findByMerchantId(1L, pageable)).thenReturn(pagedResponse);
		Page productResponse = productServiceImpl.getProductList(0, 10, 1L);
		Assert.assertNotNull(productResponse);
		assertEquals(productResponse.getContent().size(), 0);
	}

}
