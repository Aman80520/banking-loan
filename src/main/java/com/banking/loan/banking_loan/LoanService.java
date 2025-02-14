package com.banking.loan.banking_loan;

import java.util.List;

public interface LoanService {
	
	Loan addLoan(Loan loan);
	List<Loan> GetAllLoanList();
	Loan getLoanById(Long loanId);
	String UpdateLoan(Long loanId,Loan loan);
	String deleteLoanByID(Long loanId);
	List<Loan> findByAccount(Long accountNumber);
	boolean deleteByaccnumber(Integer accountNumber);

}
