package com.sedia.resume.service;

import com.sedia.resume.entity.UserEntity;
import com.sedia.resume.repository.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

	//使用者類別
    final UserMapper userMapper;
    
    //密碼加密器
    final BCryptPasswordEncoder passwordEncoder;
        
    
    //檢查使用者是否存在
    public boolean checkUser(String id) {
    	try {
    		userMapper.findById(id).orElseThrow(() -> new RuntimeException("查無使用者"));
    	}
    	catch(RuntimeException ex) {
    		return false;
    	}
    	
    	return true;
    }

	//取得所有使用者清單
    public List<UserEntity> getUsers() {
        return userMapper.findAll();
    }
    
    //取得單一使用者by ID
    public UserEntity getUserById(String id) {
        return userMapper.findById(id).orElseThrow(() -> new RuntimeException("查無使用者"));
    }
    
    //新增使用者
    public boolean insertUser(UserEntity user) {
    	if(checkUser(user.getUSER_ID()))
    		return userMapper.insert(user);
    	else
    		return false;
    }
    
    //編輯使用者
    public boolean updateUser(UserEntity user) {
    	if(checkUser(user.getUSER_ID()))
    		return userMapper.update(user);
    	else
    		return false;
    }
    
    //刪除使用者
    public boolean deleteUser(String id) {
    	return userMapper.delete(id);    	
    }
	
}
