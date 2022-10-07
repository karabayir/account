package com.tunahan.account.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CustomerAccountDto {
	
	private String id;
	
	private BigDecimal balance = BigDecimal.ZERO; 
	private LocalDateTime creationDate;	
	private Set<TransactionDto> transactions;

}
