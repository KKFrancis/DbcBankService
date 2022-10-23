package com.aiti.dbc.DbcBankService.service;

import com.aiti.dbc.DbcBankService.exception.AccountAvailableException;
import com.aiti.dbc.DbcBankService.exception.AccountNotFoundException;
import com.aiti.dbc.DbcBankService.pojo.Account;

public interface AccountServiceInterface {

	void addAccount(Account account) throws AccountAvailableException;
	Account creditAccount(Account account);
	Account deditAccountById(Account account);
	Account getAccountById(String id) throws AccountNotFoundException;
}
