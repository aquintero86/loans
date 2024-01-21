package com.ms.example.loans.mapper;

import com.ms.example.loans.Entity.Loans;
import com.ms.example.loans.dto.LoansDto;
import org.junit.Assert;
import org.junit.Before;

import org.junit.Test;


public class LoansMapperTest {
    private LoansMapper loansMapper;

    @Before
    public void setUp() {
        loansMapper = new LoansMapper();
    }


    @Test
    public void shouldmapToLoans()
    {   String mobileNumber = "4365327698";
        String loanNumber = "548732457654";
        String loanType = "Home Loan";
        int totalLoan = 100000;
        int amountPaid = 1000;
        int outstandingAmount = 99000;
        LoansDto loansDto = buildLoansDto(mobileNumber,loanNumber, loanType, totalLoan, amountPaid, outstandingAmount);
        Loans result = loansMapper.mapToLoans(loansDto, new Loans());
        Assert.assertEquals(loansDto.getMobileNumber(), result.getMobileNumber());
        Assert.assertEquals(loansDto.getLoanNumber(), result.getLoanNumber());
        Assert.assertEquals(loansDto.getLoanType(), result.getLoanType());
        Assert.assertEquals(loansDto.getTotalLoan(), result.getTotalLoan());
        Assert.assertEquals(loansDto.getAmountPaid(), result.getAmountPaid());
        Assert.assertEquals(loansDto.getOutstandingAmount(), result.getOutstandingAmount());
    }


    @Test
    public void shouldmapToLoansDto()
    {   String mobileNumber = "4365327698";
        String loanNumber = "548732457654";
        String loanType = "Home Loan";
        int totalLoan = 100000;
        int amountPaid = 1000;
        int outstandingAmount = 99000;
        Loans loans = buildLoans(mobileNumber,loanNumber, loanType, totalLoan, amountPaid, outstandingAmount);
        LoansDto result = loansMapper.mapToLoansDto(loans, new LoansDto());
        Assert.assertEquals(loans.getMobileNumber(), result.getMobileNumber());
        Assert.assertEquals(loans.getLoanNumber(), result.getLoanNumber());
        Assert.assertEquals(loans.getLoanType(), result.getLoanType());
        Assert.assertEquals(loans.getTotalLoan(), result.getTotalLoan());
        Assert.assertEquals(loans.getAmountPaid(), result.getAmountPaid());
        Assert.assertEquals(loans.getOutstandingAmount(), result.getOutstandingAmount());
    }



    private static LoansDto buildLoansDto(String mobileNumber, String loanNumber, String loanType, int totalLoan, int amountPaid,int outstandingAmount ){
        LoansDto loansDto = new LoansDto();
        loansDto.setLoanNumber(loanNumber);
        loansDto.setLoanType(loanType);
        loansDto.setMobileNumber(mobileNumber);
        loansDto.setTotalLoan(totalLoan);
        loansDto.setAmountPaid(amountPaid);
        loansDto.setOutstandingAmount(outstandingAmount);
        return loansDto;
    }

    private static Loans buildLoans(String mobileNumber, String loanNumber, String loanType, int totalLoan, int amountPaid,int outstandingAmount ){
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
