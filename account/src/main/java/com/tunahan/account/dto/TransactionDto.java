package com.tunahan.account.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.tunahan.account.model.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TransactionDto {
	
    private String id;
	
	private TransactionType transactionType;
	private BigDecimal amount;
	private LocalDateTime transactionDate;
	
	//private AccountDto accountDto;

}
