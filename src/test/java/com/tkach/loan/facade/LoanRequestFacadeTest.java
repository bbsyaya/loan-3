package com.tkach.loan.facade;

import com.tkach.loan.model.LoanRequest;
import com.tkach.loan.model.User;
import org.joda.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoanRequestFacadeTest extends AbstractFacadeTest<LoanRequest> {

    @Autowired
    private LoanRequestFacade loanRequestFacade;
    @Autowired
    private UserFacade userFacade;
    private User user;

    @Before
    public void setUp(){
        user = userFacade.create(new User("test user", "test user"));
    }

    @After
    public void tearDown(){
        userFacade.remove(user);
    }

    @Override
    protected AbstractFacade<LoanRequest> getFacade() {
        return loanRequestFacade;
    }

    @Override
    protected LoanRequest getEntity() {
        return new LoanRequest(user, BigDecimal.valueOf(1000.00), LocalDate.now().plusMonths(3), LocalDate.now());
    }

    @Override
    protected LoanRequest updateEntity(LoanRequest e) {
        e.setAmount(BigDecimal.valueOf(10000.00));
        return e;
    }
}
