package com.aiti.dbc.DbcBankService.pojo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer extends User{

	@Id
	private String customerId;
	
	@ManyToMany(mappedBy="customer")
	private List<Loan> loan;
	
	@ManyToMany(mappedBy="customer")
	private List<Account> account;
	
	@ManyToOne
	@JoinColumn(name="branchId")
	private Branch branch;
	
}
