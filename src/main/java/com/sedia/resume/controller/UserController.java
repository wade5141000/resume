package com.sedia.resume.controller;

import com.sedia.resume.entity.UserEntity;
import com.sedia.resume.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    final UserService service;

    @GetMapping
    public List<UserEntity> getUser() {
        UserEntity currentUser = service.getCurrentUser(); // 取得當前登入的使用者
        return service.getUsers();
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return service.save(user);
    }

    @GetMapping("/{id}")
    public UserEntity getUser(@PathVariable int id) {
        return service.getUserById(id);
    }

    @GetMapping("/image") // 圖片上傳
    public void image() {

    }

    @GetMapping("/image") // 圖片下載
    public void image2() {

    }

}
