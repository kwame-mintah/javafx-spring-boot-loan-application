package org.library.service;

import org.library.exception.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Autowired
    UserAccountService accountService;

    public String getWelcomeGreeting() {
        return "Welcome and have a nice day!";
    }

    public boolean processLoginInfo(String username, String password){
        try{
            accountService.checkUserExists(username);
        } catch (AccountNotFoundException accountNotFoundException){
            return false;
        }
        return true;
    }
}
