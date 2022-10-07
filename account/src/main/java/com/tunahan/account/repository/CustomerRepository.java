package com.tunahan.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunahan.account.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
