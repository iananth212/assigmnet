package com.flipkart.service;

import javax.validation.Valid;

import com.flipkart.exception.FlipkartException;
import com.flipkart.model.Merchant;
import com.flipkart.request.MerchantDTO;

public interface MerchantService {

	Merchant registerMerchant(@Valid MerchantDTO merchantDTO) throws FlipkartException;

}
