package com.sedia.resume.controller;

import com.sedia.resume.entity.LanguageEntity;
import com.sedia.resume.service.LanguageService;
import com.sedia.resume.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LanguageController {

    final LanguageService service;
    final UserService userService;

    // 取得所有語言列表
    @GetMapping("/language/")
    public List<LanguageEntity> getLanguageList() {
    	int uid = userService.getCurrentUser().getId();
        return service.getLanguageList(uid);
    }
    
    // 取得語言資料
    @GetMapping("/language/{id}")
    public LanguageEntity getLanguage(int id) {
    	int uid = userService.getCurrentUser().getId();
        return service.getLanguage(id,uid);
    }

    // 新增語言資料
    @PostMapping("/language")
    public LanguageEntity createSkill(@RequestBody LanguageEntity language) {
    	int uid = userService.getCurrentUser().getId();
    	language.setUid(uid);
        return (LanguageEntity) service.insertLanguage(language);
    }

    // 修改語言資料
    @PutMapping("/language")
    public LanguageEntity updateLanguage(@RequestBody LanguageEntity language) {
    	int uid = userService.getCurrentUser().getId();
    	language.setUid(uid);
    	language.setUpdateUser(userService.getCurrentUser().getUsername());
    	language.setUpdateDate(userService.getCurrentUser().getUpdateDate());
        return service.updateLanguage(language);
    }
    
    // 刪除語言資料
    @DeleteMapping("/language/{id}") 
    public boolean deleteLanguage(@PathVariable int id) {
    	int uid = userService.getCurrentUser().getId();
        return service.deleteLanguage(id,uid);
    }
   


}
