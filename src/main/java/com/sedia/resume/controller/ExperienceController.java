package com.sedia.resume.controller;

import com.sedia.resume.entity.ExperienceEntity;
import com.sedia.resume.service.ExperienceService;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ExperienceController {

    final ExperienceService service;

    // 取得所有經歷列表
    @GetMapping("/experience/{id}")
    public List<ExperienceEntity> getExperienceList(String uid) {
        return service.getExperienceList(uid);
    }

    // 取得經歷列表
    @GetMapping("/experience/{SN}&{id}")
    public Optional<ExperienceEntity> getExperience(@PathVariable int sn, String uid) {
        return service.getExperience(sn, uid);
    }

    // 新增經歷列表
    @PostMapping("/experience")
    public ExperienceEntity intserExperience(@RequestBody ExperienceEntity experience) {
        return service.insertExperience(experience);

    }

    // 更新經歷列表
    @PutMapping("/experience")
    public ExperienceEntity editexperience(@RequestBody ExperienceEntity license) {
        return service.editExperience(license);
    }

    // 刪除經歷列表
    @DeleteMapping("/experience/{SN}&{id}")
    public boolean deleteExperience(@PathVariable int sn, String uid) {
        return service.deleteExperience(sn, uid);
    }

}
