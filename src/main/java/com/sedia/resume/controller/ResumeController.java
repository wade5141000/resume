package com.sedia.resume.controller;

import com.sedia.resume.entity.ResumeEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/resume")
public class ResumeController {

    @GetMapping
    public List<ResumeEntity> getResumes() {
        // TODO 取得使用者所有履歷
        return null;
    }

    @GetMapping("/{id}")
    public ResumeEntity getResume(@PathVariable int id) {
        return null;
    }

    @PostMapping
    public boolean saveResume(ResumeEntity resume) {
        return false;
    }

    @PutMapping
    public boolean updateResume(ResumeEntity resume) {
        return false;
    }

    @DeleteMapping("/{id}")
    public boolean deleteResume(@PathVariable int id) {
        return false;
    }

    @PutMapping("/{id}/basic-info")
    public boolean updateBasicInfo(@PathVariable int id, List<String> basicInfoType) {
        // TODO 更新 resume 的 BASIC_INFO_COLUMNS (逗號隔開)
        // List<String> -> String
        // ["aaa", "bbb", "ccc"] -> "aaa,bbb,ccc"

        return false;
    }

    // ====================================================================================
    @PutMapping("/{id}/education")
    public boolean updateEducation(@PathVariable int id, List<Integer> educationId) {
        // TODO 存到 rel_resume_edu table
        return false;
    }

    @PutMapping("/{id}/experience")
    public boolean updateExperience(@PathVariable int id, List<Integer> experienceId) {

        // a. experienceId -> [1,2,3]
        // b. experienceId -> [2,3]
        //
        // 1. remove a
        // 2. save b

        return false;
    }

    @PutMapping("/{id}/language")
    public boolean updateLanguage(@PathVariable int id, List<Integer> languageId) {
        return false;
    }

    @PutMapping("/{id}/license")
    public boolean updateLicense(@PathVariable int id, List<Integer> licenseId) {
        return false;
    }

    @PutMapping("/{id}/skill")
    public boolean updateSkill(@PathVariable int id, List<Integer> skillId) {
        return false;
    }

}
