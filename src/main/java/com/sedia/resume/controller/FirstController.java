package com.sedia.resume.controller;

import com.sedia.resume.entity.User;
import com.sedia.resume.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FirstController {

  final UserRepository repository;

  @ResponseBody
  @GetMapping("/user")
  public List<User> getUser(){
    return repository.findAll();
  }

  @ResponseBody
  @PostMapping("/user")
  public User createUser(@RequestBody User user){
    return repository.save(user);
  }


}
