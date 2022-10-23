package com.aiti.dbc.DbcBankService.pojo;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public abstract class User {

	private String name;
	private String gender;
	private Date dob;
	
	@Embedded
	private Address address;
}
