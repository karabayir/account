package com.tunahan.account.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Account {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;	

	private BigDecimal balance = BigDecimal.ZERO; 
	private LocalDateTime creationDate;	
	
	@ManyToOne(fetch = FetchType.LAZY , cascade =  CascadeType.ALL)
	@JoinColumn(name = "customer_id",nullable = false)
	private Customer customer;
	
	@OneToMany(mappedBy="account", fetch=FetchType.EAGER)
	private Set<Transaction> transactions=new HashSet<>();
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(balance, creationDate, customer, id /*transactions*/);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(balance, other.balance) && Objects.equals(creationDate, other.creationDate)
				&& Objects.equals(customer, other.customer) && Objects.equals(id, other.id)
				&& Objects.equals(transactions, other.transactions);
	}
	
	
	
	
	

}
	