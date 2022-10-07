package com.tunahan.account.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;
	
	private TransactionType transactionType;
	private BigDecimal amount;
	private LocalDateTime transactionDate;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id",nullable = false)
	private Account account;
	
	// Ekstra constructor
	public Transaction(BigDecimal amount, LocalDateTime transactionDate, Account account, TransactionType transactionType) {
		this.amount=amount;
		this.transactionDate=transactionDate;
		this.account=account;
		this.transactionType=transactionType;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(/*account,*/ amount, id, transactionDate, transactionType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Objects.equals(account, other.account) && Objects.equals(amount, other.amount)
				&& Objects.equals(id, other.id) && Objects.equals(transactionDate, other.transactionDate)
				&& transactionType == other.transactionType;
	}
	
	
	
}
