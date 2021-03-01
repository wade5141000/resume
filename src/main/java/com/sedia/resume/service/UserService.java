package com.sedia.resume.service;

import com.sedia.resume.entity.UserEntity;
import com.sedia.resume.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

	final UserRepository repository;
	final BCryptPasswordEncoder passwordEncoder;

	public List<UserEntity> getUsers() {
		return repository.findAll();
	}

	public UserEntity save(UserEntity user) {
		if (!repository.existsByUsername(user.getUsername())) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return repository.save(user);
		}
		throw new RuntimeException("account already exists");
	}

	public UserEntity getUserById(int id) {
		return repository.findById(id).get();
	}


}
