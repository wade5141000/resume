package com.sedia.resume.repository;

import com.sedia.resume.entity.UserEntity;

import java.util.List;
import java.util.Optional;


public interface UserMapper {

  List<UserEntity> findAll();

  Optional<UserEntity> findByUsername(String username);

  Optional<UserEntity> findById(int id);

  void save(UserEntity user);

}
