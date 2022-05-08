package org.library.service;

import org.library.exception.AccountDisabledException;
import org.library.exception.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Autowired
    UserAccountService accountService;

    static final String WELCOME_AND_HAVE_A_NICE_DAY = "Welcome and have a nice day!";

    public String getWelcomeGreeting() {
        return WELCOME_AND_HAVE_A_NICE_DAY;
    }

    public boolean processLoginInfo(final String username){
        try{
            accountService.checkUserExists(username);
        } catch (AccountNotFoundException | AccountDisabledException exception ){
            return false;
        }
        return true;
    }
}
