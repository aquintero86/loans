package com.ms.example.loans.repository;

import com.ms.example.loans.Entity.Loans;
import com.ms.example.loans.Utils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class LoansRepositoryTest {

    @Autowired
    private LoansRepository loansRepository;

    @Autowired
    TestEntityManager entityManager;


    @Test
    public void shouldBeReturnLoanNotNull() {

        String mobileNumber = "4365327698";
        String loanNumber = "548732457654";
        String loanType = "Home Loan";
        int totalLoan = 100000;
        int amountPaid = 1000;
        int outstandingAmount = 99000;

        Loans loans = Utils.buildLoans(mobileNumber,loanNumber, loanType, totalLoan, amountPaid, outstandingAmount);
        entityManager.persist(loans);
        entityManager.flush();
        Optional<Loans> loanResult = loansRepository.findByMobileNumber(mobileNumber);
        assertThat(loanResult.get().getLoanNumber()).isEqualTo(loanNumber);
        assertThat(loanResult.get().getLoanType()).isEqualTo(loanType);
        assertThat(loanResult.get().getAmountPaid()).isEqualTo(amountPaid);
        assertThat(loanResult.get().getOutstandingAmount()).isEqualTo(outstandingAmount);
    }
}

