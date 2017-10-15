package com.tkach.loan.facade;

import com.tkach.loan.model.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.text.html.parser.Entity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserFacadeTest extends AbstractFacadeTest<User>{

    @Autowired
    private UserFacade userFacade;

    @Override
    protected AbstractFacade<User> getFacade() {
        return userFacade;
    }

    @Override
    protected User getEntity() {
        return new User("test name", "test last name");
    }

    @Override
    protected User updateEntity(User e) {
        e.setFirstName("updated first name");
        return e;
    }
}
