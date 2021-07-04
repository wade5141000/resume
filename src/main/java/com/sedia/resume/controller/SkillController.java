package com.sedia.resume.controller;

import com.sedia.resume.entity.SkillEntity;
import com.sedia.resume.service.SkillService;
import com.sedia.resume.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SkillController {

    final SkillService service;
    final UserService userService;

    // 取得所有技能列表
    @GetMapping("/skill/{id}") 
    public List<SkillEntity> getSkillList(@PathVariable int id) {
        return service.getSkillList(id);
    }
    
    // 取得技能資料
    @GetMapping("/skill/{uid}/{id}") 
    public SkillEntity getSkill(@PathVariable int uid) {
        return service.getSkill(uid);
    }

    // 新增技能資料
    @PostMapping("/skill")
    public SkillEntity createSkill(@RequestBody SkillEntity skill) {
        return (SkillEntity) service.insertSkill(skill);
    }
    

    // 修改技能資料
    @PutMapping("/skill")
    public SkillEntity updateEducation(@RequestBody SkillEntity skill) {
        return service.updateSkill(skill);
    }

    // 刪除技能資料
    @DeleteMapping("/skill/{uid}/{id}")
    public boolean deleteSkill(@PathVariable int uid) {
        return service.deleteSkill(uid);
    }



}
