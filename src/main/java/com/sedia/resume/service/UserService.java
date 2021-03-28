package com.sedia.resume.service;

import com.sedia.resume.entity.UserEntity;
import com.sedia.resume.repository.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

	final UserMapper userMapper;
	final BCryptPasswordEncoder passwordEncoder;

	public List<UserEntity> getUsers() {
		return userMapper.findAll();
	}

	public UserEntity save(UserEntity user) {
		if (userMapper.findByUsername(user.getUsername()).isEmpty()) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setCreateDate(LocalDateTime.now());
			userMapper.save(user);
			return user;
		}
		throw new RuntimeException("account already exists");
	}

	public UserEntity getUserById(int id) {
		return userMapper.findById(id).orElseThrow(() -> new RuntimeException("找不到 User"));
	}


}
