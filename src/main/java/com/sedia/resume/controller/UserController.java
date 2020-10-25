package com.sedia.resume.controller;

import com.sedia.resume.entity.User;
import com.sedia.resume.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

  final UserService service;

  @GetMapping("/user")
  public List<User> getUser(@AuthenticationPrincipal String username){
//    String username = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    System.out.println(username);
    return service.getUsers();
  }

  @PostMapping("/user")
  public User createUser(@RequestBody User user){
	  return service.save(user);
  }

  @GetMapping("/user/{id}")
  public User getUser(@PathVariable int id){
    return service.getUserById(id);
  }


}
