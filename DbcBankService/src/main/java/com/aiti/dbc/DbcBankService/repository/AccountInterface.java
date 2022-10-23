package com.aiti.dbc.DbcBankService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aiti.dbc.DbcBankService.pojo.Account;

@Repository
public interface AccountInterface extends JpaRepository<Account, String> {

}
