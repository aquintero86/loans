package com.ms.example.loans.controller;

import com.ms.example.loans.constants.LoansConstants;
import com.ms.example.loans.dto.ResponseDto;
import com.ms.example.loans.service.ILoansService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

public class LoanControllerTest {

    private LoanController subject;
    @Mock
    private ILoansService loansService;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        subject = new LoanController(loansService);
    }



    @Test
    public void shouldCreateControllerResponseOK()
    {
        ResponseEntity<ResponseDto> resposeOk= ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(LoansConstants.STATUS_201, LoansConstants.MESSAGE_201));
        String mobileNumber = "1234567890";
        doNothing().when(loansService).createLoan(mobileNumber);
        ResponseEntity<ResponseDto> response = subject.createLoan(mobileNumber);
        verify(loansService, times(1)).createLoan(mobileNumber);
        Assert.assertEquals(response, resposeOk);
    }





}
