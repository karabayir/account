package com.tunahan.account;

import java.util.HashSet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tunahan.account.model.Customer;
import com.tunahan.account.repository.CustomerRepository;

@SpringBootApplication
public class AccountApplication implements CommandLineRunner {
	
	private final CustomerRepository customerRepository;

	public AccountApplication(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	Customer customer=customerRepository.save(new Customer("","tunahan","karabayır",new HashSet<>()));
	System.out.println(customer);
	
	}

}
