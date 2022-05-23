package com.flipkart.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flipkart.exception.FlipkartException;
import com.flipkart.model.Merchant;
import com.flipkart.request.MerchantDTO;
import com.flipkart.service.MerchantService;

@RestController
@RequestMapping("/merchant")
public class MerchantController {

	private final MerchantService merchantService;

	public MerchantController(MerchantService merchantService) {
		this.merchantService = merchantService;
	}

	@PostMapping
	public ResponseEntity<Merchant> registerMerchant(@Valid @RequestBody MerchantDTO merchantDTO)
			throws FlipkartException {
		return ResponseEntity.status(HttpStatus.CREATED.value()).body(merchantService.registerMerchant(merchantDTO));
	}

}
