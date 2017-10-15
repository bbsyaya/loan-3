package com.tkach.loan.facade;

import com.tkach.loan.model.LoanRequest;
import org.springframework.stereotype.Service;

@Service
public class LoanRequestFacade extends AbstractFacade<LoanRequest> {
    public LoanRequestFacade(){
        super(LoanRequest.class);
    }
}
