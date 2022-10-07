package com.tunahan.account.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AccountDto {
	
	private String id;	

	private BigDecimal balance = BigDecimal.ZERO; 
	private LocalDateTime creationDate;	
	
	//private CustomerDto customer;
	private AccountCustomerDto accountCustomerDto;
	
	private Set<TransactionDto> transactios;

}
