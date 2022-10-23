package com.aiti.dbc.DbcBankService.pojo;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DBCBank {

	@Id
	@GeneratedValue
	private Long bankcode;
	
	@Embedded
	private Address address;
	
	@OneToMany(mappedBy="bank")
	private List<Branch> branch;
	
}
