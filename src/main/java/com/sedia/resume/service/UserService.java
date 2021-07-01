package com.sedia.resume.service;

import com.sedia.resume.entity.UserEntity;
import com.sedia.resume.exception.ApiException;
import com.sedia.resume.repository.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public UserEntity getCurrentUser() {
        String account = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userMapper.findByAccount(account).orElseThrow(() -> new ApiException("找不到使用者"));
    }

    public List<UserEntity> getUsers() {
        return userMapper.findAll();
    }

    public UserEntity save(UserEntity user) {
        if (userMapper.findByAccount(user.getAccount()).isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setCreateDate(LocalDateTime.now());
            user.setCreateUser(user.getAccount());
            user.setUpdateDate(LocalDateTime.now());
            user.setUpdateUser(user.getAccount());
            userMapper.save(user);
            return user;
        }
        throw new ApiException("account already exists");
    }

    public UserEntity getUserById(int id) {
        return userMapper.findById(id).orElseThrow(() -> new ApiException("找不到 User"));
    }

}
