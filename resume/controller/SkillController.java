package com.sedia.resume.controller;

import com.sedia.resume.entity.SkillEntity;
import com.sedia.resume.service.SkillService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SkillController {

    final SkillService service;

    // 取得所有技能列表
    @GetMapping("/skill/{id}") 
    public List<SkillEntity> getSkillList(@PathVariable String id) {
        return service.getSkillList(id);
    }
    
    // 取得技能資料
    @GetMapping("/skill/{SN}/{id}") 
    public SkillEntity getSkill(@PathVariable int SN, String id) {
        return service.getSkill(SN,id);
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
    @DeleteMapping("/skill/{SN}/{id}")
    public boolean deleteSkill(@PathVariable int SN, String id) {
        return service.deleteSkill(SN, id);
    }



}
