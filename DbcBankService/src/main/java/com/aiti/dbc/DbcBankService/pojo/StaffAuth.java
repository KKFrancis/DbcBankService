package com.aiti.dbc.DbcBankService.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StaffAuth {

	@Id
	@GeneratedValue
	private Integer id;
	private String password;	
	private String username;
	
	@OneToOne
	@JoinColumn(name="staffId")
	private Staff staff;
}
