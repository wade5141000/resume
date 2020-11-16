package com.sedia.resume.service;

import com.sedia.resume.entity.User;
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

	public List<User> getUsers() {
		return repository.findAll();
	}

	public User save(User user) {
		if (!repository.existsByUsername(user.getUsername())) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return repository.save(user);
		}
		throw new RuntimeException("account already exists");
	}

	public User getUserById(int id) {
		return repository.findById(id).get();
	}


}
