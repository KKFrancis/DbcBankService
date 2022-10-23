package com.aiti.dbc.DbcBankService.pojo;

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
public class Loan {

	@Id
	@GeneratedValue
	private Integer id;
	private String loanType;
	private Long amount;
	private String accountNo;
	
	@ManyToOne
	@JoinColumn(name="branchId")
	private Branch branch;
	
	@ManyToMany
	@JoinTable(name="loan_customer", joinColumns = @JoinColumn(name="loanId"), inverseJoinColumns = @JoinColumn(name="customerId"))
	private List<Customer> customer;
	
	@ManyToMany
	@JoinTable(name="loan_account", joinColumns= @JoinColumn(name="loanId"), inverseJoinColumns=@JoinColumn(name="accountId"))
	private List<Account> account;
}
