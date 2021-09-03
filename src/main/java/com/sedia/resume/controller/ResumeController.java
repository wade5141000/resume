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
	final ResumeService resumeService;
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
    public boolean updateEducation(@PathVariable int id, @RequestBody List<Integer> educationId) {
        // TODO 存到 rel_resume_edu table
        return resumeService.updateResumeEducation(id,educationId);
    }

    @PutMapping("/{id}/experience")
    public boolean updateExperience(@PathVariable int id,@RequestBody List<Integer> experienceId) {

        return resumeService.updateResumeExperience(id,experienceId);
    }

    @PutMapping("/{id}/language")
    public boolean updateLanguage(@PathVariable int id,@RequestBody List<Integer> languageId) {
        return resumeService.updateResumeLanguage(id,languageId);
    }

    @PutMapping("/{id}/license")
    public boolean updateLicense(@PathVariable int id,@RequestBody List<Integer> licenseId) {
        return resumeService.updateResumeLicense(id,licenseId);
    }

    @PutMapping("/{id}/skill")
    public boolean updateSkill(@PathVariable int id,@RequestBody List<Integer> skillId) {
        return resumeService.updateResumeSkill(id,skillId);
    }

}
