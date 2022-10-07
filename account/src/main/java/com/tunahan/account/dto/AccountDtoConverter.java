package com.tunahan.account.dto;


import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.tunahan.account.model.Account;

@Component
public class AccountDtoConverter {
	
	private final CustomerDtoConverter customerDtoConverter;
	private final TransactionDtoConverter transactionDtoConverter;
	
	public AccountDtoConverter(CustomerDtoConverter customerDtoConverter,
			                   TransactionDtoConverter transactionDtoConverter) {
	
		this.customerDtoConverter = customerDtoConverter;
		this.transactionDtoConverter = transactionDtoConverter;
	}
	



	public AccountDto convert(Account account) {
		
		return new AccountDto(
				account.getId(),
				account.getBalance(),
				account.getCreationDate(),
				customerDtoConverter.convertToAccountCustomerDto(account.getCustomer()),
				account.getTransactions().stream().map(t->transactionDtoConverter.convert(t)).collect(Collectors.toSet())
				);
	}

}
