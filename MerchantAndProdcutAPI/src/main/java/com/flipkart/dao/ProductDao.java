package com.flipkart.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.flipkart.model.Product;

public interface ProductDao extends JpaRepository<Product, Long> {

	Page findByMerchantId(Long merchantId, Pageable pageable);

}
