package com.flipkart.request;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MerchantDTO {

	@NotEmpty(message = "firstName can not be null")
	private String firstName;

	private String middleName;

	@NotEmpty(message = "lastName can not be null")
	private String lastName;

	@NotEmpty(message = "gender can not be null")
	private String gender;

	@NotEmpty(message = "email can not be null")
	private String email;

	@NotEmpty(message = "country can not be null")
	private String country;

	@NotEmpty(message = "password can not be null")
	private String password;

}
