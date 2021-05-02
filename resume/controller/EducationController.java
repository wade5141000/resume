package com.sedia.resume.controller;

import com.sedia.resume.entity.EducationEntity;
import com.sedia.resume.service.EducationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EducationController {

    final EducationService service;
    
    // 取得所有學歷列表
    @GetMapping("/education/{id}")
    public List<EducationEntity> getEducationList(@PathVariable String id) {
        return service.getEducationList(id);
    }
    
    // 取得學歷資料
    @GetMapping("education/{SN}/{id}")
    public EducationEntity getEducation(@PathVariable int SN, String id) {
        return service.getEducation(SN,id);
    }

    // 新增學歷資料
    @PostMapping("/education")
    public EducationEntity createEducation(@RequestBody EducationEntity education) {
        return (EducationEntity) service.insertEducation(education);
    }

    // 修改學歷資料
    @PutMapping("/education/")
    public EducationEntity updateEducation(@RequestBody EducationEntity education) {
        return service.updateEducation(education);
    }
    
    // 刪除學歷資料
    @DeleteMapping("/education/{SN}/{id}")
    public boolean deleteEducation(@PathVariable int SN, String id) {
        return service.deleteEducation(SN, id);
    }
    


}
