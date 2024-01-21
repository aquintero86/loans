package com.ms.example.loans.service;

import com.ms.example.loans.dto.LoansDto;

public class LoansServiceImlp implements ILoansService {
    @Override
    public void createLoan(String mobileNumber) {

    }

    @Override
    public LoansDto fetchLoan(String mobileNumber) {
        return null;
    }

    @Override
    public boolean updateLoan(LoansDto loansDto) {
        return false;
    }

    @Override
    public boolean deleteLoan(String mobileNumber) {
        return false;
    }
}
