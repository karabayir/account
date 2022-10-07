package com.tunahan.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahan.account.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, String> {

}
