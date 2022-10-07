package com.tunahan.account.dto;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.tunahan.account.model.Customer;

@Component
public class CustomerDtoConverter {
	
	private final CustomerAccountDtoConverter converter;
	
	
	public CustomerDtoConverter(CustomerAccountDtoConverter converter) {
		this.converter = converter;
	}

	public AccountCustomerDto convertToAccountCustomerDto(Customer customer) {
		return new AccountCustomerDto(
				customer.getId(),
				customer.getName(),
				customer.getSurname()
				);
	}
	
	public CustomerDto convert(Customer customer) {
		CustomerDto customerDto = new CustomerDto(
				customer.getId(), 
				customer.getName(), 
				customer.getSurname(), 
				customer.getAccountList().stream().map(converter::convert).collect(Collectors.toSet())
				);
		
		return customerDto;
	}
	
	


}
