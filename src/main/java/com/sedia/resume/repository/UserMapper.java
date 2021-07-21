package com.sedia.resume.repository;

import com.sedia.resume.entity.SkillEntity;
import com.sedia.resume.entity.UserEntity;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartFile;

public interface UserMapper {

    List<UserEntity> findAll();

    Optional<UserEntity> findByAccount(String account);

    Optional<UserEntity> findById(int id);

    void save(UserEntity user);
    
    void updateImage(MultipartFile image);

}
