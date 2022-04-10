package org.library.service;

import org.library.dto.UserDto;
import org.library.exception.AccountNotFoundException;
import org.library.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {
    private static final Logger logger = LoggerFactory.getLogger(UserAccountService.class);

    @Autowired
    private UserRepository userRepository;

    public UserDto checkUserExists(String username){
        UserDto userDto;
        try{
            userDto = userRepository.findByUsername(username);
            if (userDto.getEnabled().equals(false)){
                logger.info("{} is currently disabled", userDto.getUsername());
            }
        } catch (NullPointerException nullPointerException){
            throw new AccountNotFoundException();
        }
        return userDto;
    }
}
