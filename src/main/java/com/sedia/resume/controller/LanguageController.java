package com.sedia.resume.controller;

import com.sedia.resume.entity.LanguageEntity;
import com.sedia.resume.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LanguageController {

    final LanguageService service;

    // 取得所有語言列表
    @GetMapping("/language/{id}")
    public List<LanguageEntity> getLanguageList(@PathVariable int id) {
        return service.getLanguageList(id);
    }
    
    // 取得語言資料
    @GetMapping("/language/{uid}/{id}")
    public LanguageEntity getLanguage(@PathVariable int uid) {
        return service.getLanguage(uid);
    }

    // 新增語言資料
    @PostMapping("/language")
    public LanguageEntity createSkill(@RequestBody LanguageEntity language) {
        return (LanguageEntity) service.insertLanguage(language);
    }

    // 修改語言資料
    @PutMapping("/language")
    public LanguageEntity updateLanguage(@RequestBody LanguageEntity language) {
        return service.updateLanguage(language);
    }
    
    // 刪除語言資料
    @DeleteMapping("/language/{UID}/{id}") 
    public boolean deleteLanguage(@PathVariable int uid) {
        return service.deleteLanguage(uid);
    }
   


}
