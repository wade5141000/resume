package com.sedia.resume.service;

import com.sedia.resume.entity.UserEntity;
import com.sedia.resume.exception.ApiException;
import com.sedia.resume.repository.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
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

    public UserEntity getUserById(int id) {
        return userMapper.findById(id).orElseThrow(() -> new ApiException("找不到 User"));
    }

    public UserEntity save(UserEntity user) {
        if (userMapper.findByAccount(user.getAccount()).isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setCreateDate(LocalDateTime.now());
            user.setCreateUser(user.getAccount());
            user.setUpdateDate(LocalDateTime.now());
            user.setUpdateUser(user.getAccount());
            user.setEmail(user.getAccount());
            userMapper.save(user);
            return user;
        }
        throw new ApiException("account already exists");
    }

    public boolean update(UserEntity user) {
        try {
            UserEntity currentUser = getCurrentUser();
            user.setId(currentUser.getId());
            user.setUpdateDate(LocalDateTime.now());
            user.setUpdateUser(user.getAccount());
            userMapper.update(user);
            return true;
        } catch (Exception e) {
            log.error("更新失敗", e);
            return false;
        }
    }

}
