package com.flipkart.service.impl;

import java.util.Objects;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.flipkart.dao.MerchantDao;
import com.flipkart.exception.FlipkartException;
import com.flipkart.model.Merchant;
import com.flipkart.request.MerchantDTO;
import com.flipkart.service.MerchantService;

@Service
public class MerchantServiceImpl implements MerchantService {

	private static final String MERCHANT_ALREADY_REGISTERED = "This email id is already registered with us. Please try with different Email";

	private final MerchantDao merchantDao;

	public MerchantServiceImpl(MerchantDao merchantDao) {
		this.merchantDao = merchantDao;
	}

	@Override
	public Merchant registerMerchant(@Valid MerchantDTO merchantDTO) throws FlipkartException {
		if (Objects.nonNull(merchantDao.findByEmail(merchantDTO.getEmail()))) {
			throw new FlipkartException(HttpStatus.CONFLICT, MERCHANT_ALREADY_REGISTERED);
		}
		Merchant merchant = Merchant.builder().country(merchantDTO.getCountry()).email(merchantDTO.getEmail())
				.firstName(merchantDTO.getFirstName()).gender(merchantDTO.getGender())
				.lastName(merchantDTO.getLastName()).middleName(merchantDTO.getMiddleName())
				.password(merchantDTO.getPassword()).build();
		return merchantDao.save(merchant);
	}

}
