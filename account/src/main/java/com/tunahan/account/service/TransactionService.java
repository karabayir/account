package com.tunahan.account.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tunahan.account.dto.TransactionDto;
import com.tunahan.account.model.Account;
import com.tunahan.account.model.Transaction;
import com.tunahan.account.model.TransactionType;
import com.tunahan.account.repository.TransactionRepository;

@Service
public class TransactionService {
	
	private Logger logger = LoggerFactory.getLogger(TransactionService.class);
	
	private final TransactionRepository transactionRepository;

	public TransactionService(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}
	
	Transaction initiateMoney(final Account account, BigDecimal amount) {
		return transactionRepository.save(
				 new Transaction(amount, LocalDateTime.now(), account, TransactionType.INITIAL)
				);
	}
	
}
