package com.aiti.dbc.DbcBankService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aiti.dbc.DbcBankService.pojo.Loan;

@Repository
public interface LoanInterface extends JpaRepository<Loan, Integer> {

}
