package com.sedia.resume.controller;

import com.sedia.resume.entity.EducationEntity;
import com.sedia.resume.entity.LanguageEntity;
import com.sedia.resume.service.EducationService;
import com.sedia.resume.service.UserService;
import com.sedia.resume.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EducationController {

    final EducationService service;
    final UserService userService;
    
    // 取得使用者所有學歷列表
    @GetMapping("/education")
    public List<EducationEntity> getEducationList() {
    	int uid = userService.getCurrentUser().getId();
        return service.getEducationList(uid);
    }
    
    // 取得使用者一筆學歷資料 
    @GetMapping("/education/{id}")
    public EducationEntity getEducation(int id) {
    	int uid = userService.getCurrentUser().getId();
        return service.getEducation(id,uid);
    }

    // 新增學歷資料
    @PostMapping("/education")
    public EducationEntity createEducation(@RequestBody EducationEntity education) {
    	int uid = userService.getCurrentUser().getId();
    	education.setUid(uid);
    	return (EducationEntity) service.insertEducation(education);
        
    }

    // 修改學歷資料
    @PutMapping("/education")
    public void updateEducation(@RequestBody EducationEntity education) {
    	int uid = userService.getCurrentUser().getId();
    	education.setUid(uid);
    	education.setUpdateUser(userService.getCurrentUser().getUsername());
    	education.setUpdateDate(userService.getCurrentUser().getUpdateDate());
        service.updateEducation(education);
    }
    
    // 刪除學歷資料
    @DeleteMapping("/education/{id}")
    public void deleteEducation(@PathVariable int id) {
    	int uid = userService.getCurrentUser().getId();
        service.deleteEducation(id, uid);
    }
    
 /* //確認資料是否存在 ??
    @GetMapping("/education/{uid}")
  	boolean isExistEducation(int uid) {
    	return service.isExistEducation(uid);
  	}
    
 */

}
