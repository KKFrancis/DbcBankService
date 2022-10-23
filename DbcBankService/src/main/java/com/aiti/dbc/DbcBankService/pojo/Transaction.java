package com.aiti.dbc.DbcBankService.pojo;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Transaction {

	@Id
	@GeneratedValue
	private Long transactionId;
	private LocalDate debitDate;
	private LocalDate creditDate;
	private Long credit;
	private Long debit;
	
	@ManyToMany
	@JoinTable(name="transaction_account", joinColumns= @JoinColumn(name="transactionId"), inverseJoinColumns=@JoinColumn(name="accountId"))
	private List<Account> account;
}
