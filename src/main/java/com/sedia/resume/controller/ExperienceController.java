package com.sedia.resume.controller;

import com.sedia.resume.entity.ExperienceEntity;
import com.sedia.resume.service.ExperienceService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ExperienceController {

    final ExperienceService service;

    // 取得使用者所有經歷列表
    @GetMapping("/experience/{uid}")
    public List<ExperienceEntity> getExperienceList(int uid) {
        return service.getExperienceList(uid);
    }

    // 取得使用者一筆經歷
    @GetMapping("/experience/{sn}/{uid}")//不能兩個sn&uid,或者用{sn}/{uid}要跟伯寬跟vicky講一下改sn
    public Optional<ExperienceEntity> getExperience(@PathVariable int sn,int uid) {
        return service.getExperience(sn,uid);
    }

    // 新增經歷列表 
    @PostMapping("/experience")
    public void intserExperience(@RequestBody ExperienceEntity experience) {
        service.insertExperience(experience);

    }

    // 更新經歷列表
    @PutMapping("/experience")
    public ExperienceEntity editexperience(@RequestBody ExperienceEntity license) {
        return service.editExperience(license);
    }

    // 刪除經歷列表
    //要跟柏寬他們討論是否直接void就好
    @DeleteMapping("/experience/{sn}")
    public void deleteExperience(@PathVariable int sn) {
        service.deleteExperience(sn);
    }

}
