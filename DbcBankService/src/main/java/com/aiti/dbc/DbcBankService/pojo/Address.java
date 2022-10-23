package com.aiti.dbc.DbcBankService.pojo;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Address {

	private String permenentAdd;
	private String area;
	private String telephone;
	private String email;
	
}
