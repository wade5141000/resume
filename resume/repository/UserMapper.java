package com.sedia.resume.repository;

import com.sedia.resume.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserMapper {
	
	//查詢所有使用者帳號
    List<UserEntity> findAll();
    
    
    Optional<UserEntity> findByUsername(String username);
    
    //查詢單一使用者 by ID
    Optional<UserEntity> findById(int id);

    //新增
    boolean insert(UserEntity user);
    
    //修改
    boolean update(UserEntity user);
    
    //刪除
    boolean delete(String id);
}
