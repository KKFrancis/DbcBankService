package com.aiti.dbc.DbcBankService.pojo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {

	@Id
	@GeneratedValue
	private String accountNo;
	private String accountType;
	private Long amount;
	private LocalDate dateCreated;
	
	@ManyToMany
	@JoinTable(name="account_customer", joinColumns= @JoinColumn(name="accountId"), inverseJoinColumns=@JoinColumn(name="customerId"))
	private List<Customer> customer;
	
	@ManyToMany(mappedBy="account")
	private List<Transaction> transaction;
	
	@ManyToOne
	@JoinColumn(name="branchId")
	private Branch branch;
	
	@ManyToMany(mappedBy="account")
	private List<Loan> loan;
	
	
}
