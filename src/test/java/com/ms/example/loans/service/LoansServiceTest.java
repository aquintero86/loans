package com.ms.example.loans.service;


import com.ms.example.loans.Entity.Loans;
import com.ms.example.loans.Utils;
import com.ms.example.loans.exception.LoanAlreadyExistsException;
import com.ms.example.loans.repository.LoansRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class LoansServiceTest {
    @Autowired
    private LoansServiceImlp loansServiceImlp;
    @MockBean
    private LoansRepository loansRepository;

    @Test
    public void shouldCreateLoanOK(){
        String loanNumber = "548732457654";
        loansServiceImlp.createLoan(loanNumber);
        verify(loansRepository, times(1)).save(any());

    }

    @Test
    public void shouldCreateLoanThrowException(){
        String mobileNumber = "4365327698";
        String loanNumber = "548732457654";
        String loanType = "Home Loan";
        int totalLoan = 100000;
        int amountPaid = 1000;
        int outstandingAmount = 99000;
        Loans loans = Utils.buildLoans(mobileNumber,loanNumber, loanType, totalLoan, amountPaid, outstandingAmount);
        when(loansRepository.findByLoanNumber(loanNumber)).thenReturn(Optional.of(loans));
        Exception exception = assertThrows(LoanAlreadyExistsException.class, () -> {
            loansServiceImlp.createLoan(loanNumber);
        });
        String expectedMessage = "Loan already registered with given mobileNumber ";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));


    }



}
