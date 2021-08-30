package com.sedia.resume.controller;

import com.sedia.resume.entity.ResumeEntity;
import com.sedia.resume.service.ResumeService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/resume")
public class ResumeController {

    final ResumeService service;

    @GetMapping
    public List<ResumeEntity> getResumes() {

        return service.getResumeList();
    }

    @GetMapping("/{id}")
    public ResumeEntity getResume(@PathVariable int id) {
        return service.getResume(id);
    }

    @PostMapping
    public boolean saveResume(@RequestBody ResumeEntity resume) {
        return service.insertResume(resume);
    }

    @PutMapping
    public boolean updateResume(@RequestBody ResumeEntity resume) {
        return service.updateResume(resume);
    }

    @DeleteMapping("/{id}")
    public boolean deleteResume(@PathVariable int id) {
        return service.deleteResume(id);
    }

    @PutMapping("/{id}/basic-info") // 要套用的資料
    public boolean updateBasicInfo(@PathVariable int id, List<String> basicInfoType) {
        // TODO 更新SQL resume 的 BASIC_INFO_COLUMNS (逗號隔開)
        // List<String> -> String, 放欄位名稱 , ex: ["aaa", "bbb", "ccc"] -> "aaa,bbb,ccc"

        return service.updateBasicInfo(id, basicInfoType);
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
