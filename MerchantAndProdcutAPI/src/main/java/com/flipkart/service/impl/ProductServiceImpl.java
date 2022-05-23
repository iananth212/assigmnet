package com.flipkart.service.impl;

import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.flipkart.dao.ProductDao;
import com.flipkart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private final ProductDao productDao;

	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public Page getProductList(Integer pageNo, Integer pageSize, Long merchantId) {
		if (Objects.isNull(pageNo)) {
			pageNo = 0;
		}
		if (Objects.isNull(pageSize)) {
			pageSize = 10;
		}
		Pageable pageable = PageRequest.of(pageNo, pageSize);
		return productDao.findByMerchantId(merchantId, pageable);
	}

}
