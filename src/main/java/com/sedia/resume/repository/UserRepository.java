package com.sedia.resume.repository;

import com.sedia.resume.entity.UserEntity;


import java.util.Optional;


public interface UserRepository  {

  Optional<UserEntity> findByUsername(String username);

	boolean existsByUsername(String username);

}
