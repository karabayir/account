package com.tunahan.account.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.tunahan.account.dto.AccountDto;
import com.tunahan.account.dto.AccountDtoConverter;
import com.tunahan.account.dto.CreateAccountRequest;
import com.tunahan.account.model.Account;
import com.tunahan.account.model.Customer;
import com.tunahan.account.model.Transaction;
import com.tunahan.account.repository.AccountRepository;

@Service
public class AccountService {
	
	private final AccountRepository accountRepository;
	private final CustomerService customerService;
	private final AccountDtoConverter accountDtoConverter;
	private final TransactionService transactionService;

	public AccountService(AccountRepository accountRepository,
			              CustomerService customerService,
			              AccountDtoConverter accountDtoConverter,
			              TransactionService transactionService) 
	{
		this.accountRepository = accountRepository;
		this.customerService = customerService;
		this.accountDtoConverter=accountDtoConverter;
		this.transactionService=transactionService;
	}
	
	public AccountDto createAccount(CreateAccountRequest request) {
	   
		Customer customer = customerService.findCustomerById(request.getCustomerId());
		
		Account account = new Account();
		account.setBalance(request.getInitialCredit());
		account.setCreationDate(LocalDateTime.now());
		account.setCustomer(customer);
		
		if(request.getInitialCredit().compareTo(BigDecimal.ZERO) > 0) {
			Transaction transaction = transactionService.initiateMoney(account,request.getInitialCredit());
			account.getTransactions().add(transaction);
		}
		 
		//Transaction'ı hiç kaydetmeden doğrudan account'u set etsek bile jpa onu kaydeder.
		accountRepository.save(account);
		
		return accountDtoConverter.convert(account);
	}

}
