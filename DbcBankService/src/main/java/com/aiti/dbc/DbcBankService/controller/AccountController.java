package com.aiti.dbc.DbcBankService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aiti.dbc.DbcBankService.pojo.Account;
import com.aiti.dbc.DbcBankService.service.AccountServiceImp;

@RestController
@RequestMapping("account_api")
public class AccountController {
	
	@Autowired
	private AccountServiceImp acctService;

	@PostMapping("/add_account")
	public ResponseEntity<?> regAccount(@RequestBody Account account){
		
		Account acct = acctService.creditAccount(account);
		if(acct==null) {
			throw new RuntimeException("account has not been credited");
		}
		return ResponseEntity.ok(acct);
	}
}
