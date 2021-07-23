package com.sedia.resume.service;

import com.itextpdf.kernel.geom.Path;
import com.sedia.resume.controller.UserController;
import com.sedia.resume.entity.SkillEntity;
import com.sedia.resume.entity.UserEntity;
import com.sedia.resume.exception.ApiException;
import com.sedia.resume.repository.SkillMapper;
import com.sedia.resume.repository.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.nio.file.*;

import org.springframework.util.ResourceUtils;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
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

    public String getImgById(int id) {
        return userMapper.loadImg(id);
    }

}
