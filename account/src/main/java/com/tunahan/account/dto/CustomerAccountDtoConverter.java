package com.tunahan.account.dto;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.tunahan.account.model.Account;

@Component
public class CustomerAccountDtoConverter {
//AccoutDtoConverter^da yazarsam injection cycle olacaktır.
	
	private final TransactionDtoConverter transactionDtoConverter;
	
	
	
	public CustomerAccountDtoConverter(TransactionDtoConverter transactionDtoConverter) {
	this.transactionDtoConverter = transactionDtoConverter;
}

	public CustomerAccountDto convert(Account account ) {
		
		return new CustomerAccountDto(
				account.getId(),
				account.getBalance(),
				LocalDateTime.now(),
				account.getTransactions().stream().map(t->transactionDtoConverter.convert(t)).collect(Collectors.toSet())
				);
	}
}
