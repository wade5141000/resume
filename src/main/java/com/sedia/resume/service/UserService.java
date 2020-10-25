package com.sedia.resume.service;

import com.sedia.resume.entity.User;
import com.sedia.resume.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

  final UserRepository repository;

  public List<User> getUsers(){
    return repository.findAll();
  }

  public User save(User user){
    return repository.save(user);
  }

  public User getUserById(int id){
    return repository.findById(id).get();
  }


}
