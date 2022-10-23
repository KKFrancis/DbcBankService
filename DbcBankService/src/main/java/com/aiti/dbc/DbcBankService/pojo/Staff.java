package com.aiti.dbc.DbcBankService.pojo;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Staff extends User{
	
	@Id
	private String staffId;
	
	@ManyToOne
	@JoinColumn(name="branchId")
	private Branch branch;
	
	@OneToMany(mappedBy="staff")
	private List<Permission> permission;
	
	

}
