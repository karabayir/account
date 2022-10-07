package com.tunahan.account.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomerDto {
	
    private String id;
	
	private String name;
	private String surname;
	
	//private Set<AccountDto> accountList;
	private Set<CustomerAccountDto> accounts;
	

}
