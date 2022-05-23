package com.flipkart.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flipkart.model.Merchant;

public interface MerchantDao extends JpaRepository<Merchant, Long> {

	Merchant findByEmail(String email);

}
