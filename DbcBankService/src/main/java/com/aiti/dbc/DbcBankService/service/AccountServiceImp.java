package com.aiti.dbc.DbcBankService.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.aiti.dbc.DbcBankService.exception.AccountAvailableException;
import com.aiti.dbc.DbcBankService.exception.AccountNotFoundException;
import com.aiti.dbc.DbcBankService.pojo.Account;
import com.aiti.dbc.DbcBankService.repository.AccountInterface;
@Service
public class AccountServiceImp implements AccountServiceInterface {

	@Autowired
	private AccountInterface accInt;
	
	@Override
	public void addAccount(Account account) {
		Optional<Account> opt = accInt.findById(account.getAccountNo());
		if(opt.isPresent())
			throw new AccountAvailableException("Account number is available");
		
		accInt.save(account);
	}

	@Override
	public Account creditAccount(Account account) {
		Account acct = new Account();
		acct.setAccountNo(account.getAccountNo());
		acct.setCustomer(account.getCustomer());
		Example<Account> eg = Example.of(acct);
		Optional<Account> opt= accInt.findOne(eg);
		if(opt.isPresent()) {
			
			Long amount = account.getAmount();
			acct.setAmount(acct.getAmount() + amount);
			accInt.save(acct);
		}
		return null;
	}

	@Override
	public Account deditAccountById(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccountById(String id) throws AccountNotFoundException {
		Optional<Account> accOpt = accInt.findById(id);
		if(accOpt.isPresent())
			return accOpt.get();
		
		throw new AccountNotFoundException("Account is not found");
	}

}
