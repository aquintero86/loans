package com.ms.example.loans.controller;


import com.ms.example.loans.Entity.Loans;
import com.ms.example.loans.Utils;
import com.ms.example.loans.constants.LoansConstants;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.ms.example.loans.exception.LoanAlreadyExistsException;
import com.ms.example.loans.service.ILoansService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest(LoanController.class)
public class WebMockControllerTest {
    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private ILoansService loansService;

    @Test
    void shouldReturnMessageFromServiceBadRequest() throws Exception {
        this.mockMvc.perform(post("/api/create")).andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString("Bad Request")));
    }


    @Test
    void shouldReturnMessageCreated() throws Exception {
        String mobileNumber = "mobileNumber=4354437687";
        doNothing().when(loansService).createLoan("4354437687");
        this.mockMvc.perform(post("/api/create?"+mobileNumber).contentType(APPLICATION_JSON)).andDo(print()).andExpect(status().is2xxSuccessful())
                .andExpect(content().string(containsString(LoansConstants.MESSAGE_201)));
    }


    @Test
    void shouldReturnException() throws Exception {
        String mobileNumber = "4365327698";
        String loanNumber = "548732457654";
        String loanType = "Home Loan";
        String messageException = "Loan already registered with given mobileNumber";
        int totalLoan = 100000;
        int amountPaid = 1000;
        int outstandingAmount = 99000;
        Loans loans = Utils.buildLoans(mobileNumber,loanNumber, loanType, totalLoan, amountPaid, outstandingAmount);
        doThrow(new LoanAlreadyExistsException(messageException)).when(loansService).createLoan("4365327698");
        this.mockMvc.perform(post("/api/create?mobileNumber="+mobileNumber).contentType(APPLICATION_JSON)).andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().string(containsString(messageException)));
    }



}
