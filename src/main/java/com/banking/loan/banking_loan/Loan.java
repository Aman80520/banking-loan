package com.banking.loan.banking_loan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long loanId;
	private String loanAccountNo;
	//private loanType loanType;
	private double totalLoanAmount;
	private double restAmount;
	private Long accountNumber;

}
