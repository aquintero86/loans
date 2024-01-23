package com.ms.example.loans;

import com.ms.example.loans.Entity.Loans;
import com.ms.example.loans.dto.LoansDto;

public class Utils {


    public static LoansDto buildLoansDto(String mobileNumber, String loanNumber, String loanType, int totalLoan, int amountPaid, int outstandingAmount ){
        LoansDto loansDto = new LoansDto();
        loansDto.setLoanNumber(loanNumber);
        loansDto.setLoanType(loanType);
        loansDto.setMobileNumber(mobileNumber);
        loansDto.setTotalLoan(totalLoan);
        loansDto.setAmountPaid(amountPaid);
        loansDto.setOutstandingAmount(outstandingAmount);
        return loansDto;
    }

    public static Loans buildLoans(String mobileNumber, String loanNumber, String loanType, int totalLoan, int amountPaid, int outstandingAmount ){
        Loans loans = new Loans();
        loans.setLoanNumber(loanNumber);
        loans.setLoanType(loanType);
        loans.setMobileNumber(mobileNumber);
        loans.setTotalLoan(totalLoan);
        loans.setAmountPaid(amountPaid);
        loans.setOutstandingAmount(outstandingAmount);
        return loans;
    }
}
