package com.tunahan.account.service;

import org.springframework.stereotype.Service;

import com.tunahan.account.dto.CustomerDto;
import com.tunahan.account.dto.CustomerDtoConverter;
import com.tunahan.account.exception.CustomerNotFoundException;
import com.tunahan.account.model.Customer;
import com.tunahan.account.repository.CustomerRepository;

@Service
public class CustomerService {
	
	private final CustomerRepository customerRepository;
	private final CustomerDtoConverter customerDtoConverter;

	public CustomerService(CustomerRepository customerRepository,
			               CustomerDtoConverter customerDtoConverter) {
		this.customerRepository = customerRepository;
		this.customerDtoConverter=customerDtoConverter;
	}
	
	protected Customer findCustomerById(String id) {
		return customerRepository.findById(id)
				.orElseThrow(()->new CustomerNotFoundException("Customer not found "+ id));
	}

	public CustomerDto getCustomerById(String customerId) {
		
		Customer customer = findCustomerById(customerId);
		
		return customerDtoConverter.convert(customer);
	}
}
