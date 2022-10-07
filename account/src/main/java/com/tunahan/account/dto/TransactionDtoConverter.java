package com.tunahan.account.dto;

import org.springframework.stereotype.Component;

import com.tunahan.account.model.Transaction;

@Component
public class TransactionDtoConverter {
	

	
	public TransactionDto convert(Transaction transaction) {
		return new TransactionDto(
				transaction.getId(),
				transaction.getTransactionType(),
				transaction.getAmount(),
				transaction.getTransactionDate()
				);
	}

}
