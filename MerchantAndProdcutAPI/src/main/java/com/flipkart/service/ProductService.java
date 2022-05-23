package com.flipkart.service;

import org.springframework.data.domain.Page;

public interface ProductService {

	Page getProductList(Integer pageNo, Integer pageSize, Long merchantId);

}
