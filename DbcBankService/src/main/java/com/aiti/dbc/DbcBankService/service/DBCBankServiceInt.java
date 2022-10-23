package com.aiti.dbc.DbcBankService.service;

import java.util.List;

import com.aiti.dbc.DbcBankService.pojo.DBCBank;

public interface DBCBankServiceInt {

	List<DBCBank> getBankInfo(DBCBank dbc);
	DBCBank saveBankInfo(DBCBank dbc)throws Exception;
	DBCBank updateBankInfo(DBCBank dbc)throws Exception;
}
