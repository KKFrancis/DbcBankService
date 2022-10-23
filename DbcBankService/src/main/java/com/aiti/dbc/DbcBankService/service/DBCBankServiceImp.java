package com.aiti.dbc.DbcBankService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiti.dbc.DbcBankService.pojo.Address;
import com.aiti.dbc.DbcBankService.pojo.DBCBank;
import com.aiti.dbc.DbcBankService.repository.DBCBankInterface;

@Service
public class DBCBankServiceImp implements DBCBankServiceInt {

	@Autowired
	private DBCBankInterface dbci;
	
	@Override
	public List<DBCBank> getBankInfo(DBCBank dbc) {
		List<DBCBank> list = dbci.findAll();
		if(list.isEmpty())
			return null;
		
		return list;
		
	}

	@Override
	public DBCBank saveBankInfo(DBCBank dbc) throws Exception {
		
		DBCBank dbcb = dbci.save(dbc);
		if(dbcb == null)
			throw new Exception("Error run !!!!!");
			
		return dbcb;
	}
	
	@Override
	public DBCBank updateBankInfo(DBCBank dbc) throws Exception {

		DBCBank bank = new DBCBank();
		
		bank.setAddress(dbc.getAddress());
	
		DBCBank dbcb = dbci.save(bank);
		if(dbcb == null)
			throw new Exception("Error run !!!!!");
			
		return dbcb;
	}

}
