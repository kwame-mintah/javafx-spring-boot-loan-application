package org.library.controller;

import org.library.entity.UserEntity;
import org.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/users")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping("")
  public List<UserEntity> getUsers(UserEntity userEntity) {
    return userRepository.findAll();
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }
}
