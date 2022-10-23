package com.aiti.dbc.DbcBankService.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Permission {

	@Id
	@GeneratedValue
	private Integer id;
	private String role;
	private boolean createAccount;
	private boolean createStaff;
	private boolean createCust;
	private boolean createRole;
	private boolean creditAccountById;
	private boolean deditAccountById;
	private boolean viewAccountById;
	private boolean updateCustById;
	private boolean updateStaffById;
	private boolean updateLoan;
	private boolean manageRolesAndPermissions;
	private boolean removeRoleFromStaff;
	private boolean removePermissionFromStaff;
	private boolean assignRoleToStaff;
	private boolean assignPermissionToStaff;
	private boolean deleteStaff;
	private boolean viewStaffById;
	private boolean viewStaffByBranch;
	private boolean viewStaffByArea;
	private boolean viewCustById;
	private boolean viewCustByBranch;
	private boolean viewCustByArea;
	private boolean viewTransaction;
	
	@ManyToOne
	@JoinColumn(name="staffId")
	private Staff staff;
	
}
