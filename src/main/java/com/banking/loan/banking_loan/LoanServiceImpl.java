package com.banking.loan.banking_loan;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	private LoanRepository loanRepository;
	
	@Override
	public Loan addLoan(Loan loan) {
		Loan save = loanRepository.save(loan);
		return save;
	}

	@Override
	public List<Loan> GetAllLoanList() {
		List<Loan> all = loanRepository.findAll();
		return all;
	}

	@Override
	public Loan getLoanById(Long loanId) {
		Optional<Loan> loanbyId = loanRepository.findById(loanId);
		return loanbyId.orElseThrow(()->new ResourceNotFoundeException("Loan Id is not Present"));
	}

	@Override
	public String UpdateLoan(Long loanId, Loan loan) {
		Optional<Loan> findLoan = loanRepository.findById(loanId);
		Loan updatel = findLoan.get();
		if (updatel!=null) {
			updatel.setLoanAccountNo(loan.getLoanAccountNo());
			updatel.setRestAmount(loan.getRestAmount());
			updatel.setTotalLoanAmount(loan.getTotalLoanAmount());
		loanRepository.save(updatel);
		}
	
		return "updated successfully";
	}

	@Override
	public String deleteLoanByID(Long loanId) {
		Optional<Loan> byId = Optional.of(loanRepository.findById(loanId).orElse(null));
		if (byId.isPresent()) {
			loanRepository.deleteById(loanId);
			return "Deleted Successfully";
		}
		return "Id is not present";
	}

	@Override
	public List<Loan> findByAccount(Long accountNumber) {
		List<Loan> byAccountNumber = loanRepository.findByAccountNumber(accountNumber);
		return byAccountNumber;
	}

	@Override
	@Transactional
	public boolean deleteByaccnumber(Integer accountNumber) {
		Loan deleteByAcc = loanRepository.deleteByAccountNumber(accountNumber);
		
		if (deleteByAcc!=null) {
			return true;
		}
		return false; 
	}

}
