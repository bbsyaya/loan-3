package com.tkach.loan.facade;

import com.tkach.loan.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserFacade extends AbstractFacade<User>{
    public UserFacade(){
        super(User.class);
    }
}
