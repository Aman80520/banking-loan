package com.banking.loan.banking_loan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{
	
	List<Loan> findByAccountNumber(Long accountNumber);
	
	Loan deleteByAccountNumber(Integer accountNumber);
	
	

}
