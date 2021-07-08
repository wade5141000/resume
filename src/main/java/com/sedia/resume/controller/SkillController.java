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
    @GetMapping("/skill/") 
    public List<SkillEntity> getSkillList() {
    	int uid = userService.getCurrentUser().getId();
        return service.getSkillList(uid);
    }
    
    // 取得技能資料
    @GetMapping("/skill/{id}") 
    public SkillEntity getSkill(int id) {
    	int uid = userService.getCurrentUser().getId();
        return service.getSkill(id,uid);
    }

    // 新增技能資料
    @PostMapping("/skill")
    public SkillEntity createSkill(@RequestBody SkillEntity skill) {
    	int uid = userService.getCurrentUser().getId();
    	skill.setUid(uid);
        return (SkillEntity) service.insertSkill(skill);
    }
    

    // 修改技能資料
    @PutMapping("/skill")
    public void updateSkill(@RequestBody SkillEntity skill) {
    	int uid = userService.getCurrentUser().getId();
    	skill.setUid(uid);
    	skill.setUpdateUser(userService.getCurrentUser().getUsername());
    	skill.setUpdateDate(userService.getCurrentUser().getUpdateDate());
       service.updateSkill(skill);
    }

    // 刪除技能資料
    @DeleteMapping("/skill/{id}")
    public boolean deleteSkill(@PathVariable int id) {
    	int uid = userService.getCurrentUser().getId();
        return service.deleteSkill(id,uid);
    }



}
