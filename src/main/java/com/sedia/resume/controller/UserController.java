package com.sedia.resume.controller;

import com.sedia.resume.entity.UserEntity;
import com.sedia.resume.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController extends BaseController {

    final UserService service;
    
    //取得使用者清單
    @GetMapping("/user")
    public List<UserEntity> getUsers() {
        return service.getUsers();
    }    

    //取得單一使用者
    @GetMapping("/user/{id}")
    public UserEntity getUser(@PathVariable String id) {
        return service.getUserById(id);
    }
    
    //新增使用者
    @PostMapping("/user")
    public boolean createUser(@RequestBody UserEntity user) {
        return service.insertUser(user);
    }
    
    //修改使用者
    @PutMapping("/user")
    public boolean updateUser(@RequestBody UserEntity user) {
        return service.updateUser(user);
    }
    
    //刪除使用者
    @DeleteMapping("/user/{id}")
    public boolean deleteUser(@PathVariable String id){
    	return service.deleteUser(id);
    }
}
