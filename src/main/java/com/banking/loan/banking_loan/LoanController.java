package com.banking.loan.banking_loan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loan")
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	
	@PostMapping("/save")
	public ResponseEntity<Loan> saveLoan(@RequestBody Loan loan){
		Loan loan2 = loanService.addLoan(loan);
		return new ResponseEntity<Loan>(loan2,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getLoan")
	public ResponseEntity<Loan> getLoan(@PathVariable Long LoanId){
		Loan loan2 = loanService.getLoanById(LoanId);
		return new ResponseEntity<Loan>(loan2,HttpStatus.OK);
		
	}
	
	@GetMapping("/account/{accountNumber}")
	public ResponseEntity<List<Loan>> getLoanByAcc(@PathVariable Long accountNumber){
		List<Loan> loan2 = loanService.findByAccount(accountNumber);
		return new ResponseEntity<>(loan2,HttpStatus.OK);
		
	}
	

}
