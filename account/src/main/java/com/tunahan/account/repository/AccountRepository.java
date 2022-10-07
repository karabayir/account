package com.tunahan.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahan.account.model.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

}
