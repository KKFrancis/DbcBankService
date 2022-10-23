package com.aiti.dbc.DbcBankService.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.aiti.dbc.DbcBankService.pojo.DBCBank;
import com.aiti.dbc.DbcBankService.repository.DBCBankInterface;
import com.aiti.dbc.DbcBankService.service.DBCBankServiceImp;

@RestController
public class DBCBankController {
	
	@Autowired
	private DBCBankServiceImp dbcs;
	
	@Autowired
	private DBCBankInterface  dbci;
	

	@RequestMapping(value="/bank_details", method = RequestMethod.GET)
	public ResponseEntity<?> getBankDetails(@RequestBody DBCBank dbc){
		
		List<DBCBank> db = dbcs.getBankInfo(dbc);
		if(db.isEmpty())
			ResponseEntity.ok("Information is not available");
			
		return ResponseEntity.ok(db);
	}
	
	@RequestMapping(value="/{id}/update_bank", method=RequestMethod.PATCH)
	public ResponseEntity<?> updateBankInfo(@PathVariable("id") Long id, @RequestBody DBCBank dbc){
		
		Optional<DBCBank> opt = dbci.findById(id);
	
		if(opt.isPresent()) {
			
			try {
				
				dbcs.updateBankInfo(dbc);
			}catch(Exception e) {
				return ResponseEntity.ok(e);
			}
			
			return ResponseEntity.ok("Info updated");
		}
		
		return ResponseEntity.ok("This entity is not present");
		
	}
	
	@RequestMapping(value="/save_info", method=RequestMethod.POST)
	public ResponseEntity<?> saveInfo(@RequestBody DBCBank dbc){
		try {
			dbcs.updateBankInfo(dbc);
		}catch(Exception e) {
			
			return ResponseEntity.ok(e);
		}	
		
		return ResponseEntity.ok("Bank info is not saved");
	}
}
