package com.sedia.resume.controller;

import com.sedia.resume.entity.EducationEntity;
import com.sedia.resume.service.EducationService;
import com.sedia.resume.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EducationController {

    final EducationService service;
    final UserService userService;
    
    // 取得所有學歷列表
    @GetMapping("/education/{id}")
    public List<EducationEntity> getEducationList(@PathVariable("id") int uid) {
        return service.getEducationList(uid);
    }
    
    // 取得學歷資料 ??
    @GetMapping("education/{uid}")
    public EducationEntity getEducation(@PathVariable int uid) {
        return service.getEducation(uid);
    }

    // 新增學歷資料
    @PostMapping("/education")
    public void createEducation(@RequestBody EducationEntity education) {
        service.insertEducation(education);
    }

    // 修改學歷資料
    @PutMapping("/education/")
    public EducationEntity updateEducation(@RequestBody EducationEntity education) {
        return service.updateEducation(education);
    }
    
    // 刪除學歷資料
    @DeleteMapping("/education/{uid}")
    public boolean deleteEducation(@PathVariable int uid) {
        return service.deleteEducation(uid);
    }
    
  //確認資料是否存在 ??
    @GetMapping("/education/{uid}")
  	boolean isExistEducation(int uid) {
    	return service.isExistEducation(uid);
  	}
    
 

}
