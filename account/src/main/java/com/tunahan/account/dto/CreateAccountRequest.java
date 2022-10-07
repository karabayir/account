package com.tunahan.account.dto;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class CreateAccountRequest {
	
	private String customerId;
	
	private BigDecimal initialCredit;

}
