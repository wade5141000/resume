package com.sedia.resume.controller;

import com.sedia.resume.entity.ExperienceEntity;
import com.sedia.resume.entity.UserEntity;
import com.sedia.resume.service.ExperienceService;
import com.sedia.resume.service.UserService;

import lombok.RequiredArgsConstructor;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.serviceloader.ServiceListFactoryBean;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ExperienceController {

    final ExperienceService service;
   
    final UserService userService;
    

    // 取得使用者所有經歷列表
    @GetMapping("/experience/")
    public List<ExperienceEntity> getExperienceList() {
    	
    	//在這set uid
    	UserEntity currentUser = userService.getCurrentUser();
    	int uid = currentUser.getId();
    	
        return service.getExperienceList(uid);
    }

    // 取得使用者一筆經歷
    @GetMapping("/experience/{sn}")
    public ExperienceEntity getExperience(int sn) {
    	
    	UserEntity currentUser = userService.getCurrentUser();
    	int uid = currentUser.getId();
    	
//    	Optional <ExperienceEntity> currentExperience = service.getExperience(uid,sn);
    	
        return service.getExperience(sn,uid);
    }

    // 新增經歷列表
    @PostMapping("/experience/")
    public void intserExperience(@RequestBody ExperienceEntity experience) {
    	
    	UserEntity currentUser = userService.getCurrentUser();
    	experience.setUid(currentUser.getId());
    	
    	service.insertExperience(experience);

    }

    // 更新經歷列表
    //同一uid才能更新自身的經歷，同時他們不會知道自己uid或別人uid
    @PutMapping("/experience/")
    public ExperienceEntity editexperience(@RequestBody ExperienceEntity experience) {
        
    	//取得當前使用者
    	UserEntity currentUser = userService.getCurrentUser();
    	//讓使用者取得自身的經歷
    	experience.setUid(currentUser.getId());
    	
    	//讓使用者做編輯
    	return service.editExperience(experience);
    }

    // 刪除經歷列表
    //同一uid才能刪除自身的經歷，同時他們不會知道自己uid或別人uid
    @DeleteMapping("/experience/{sn}")
    public void deleteExperience(@PathVariable int sn) {
    	
    	UserEntity currentUser = userService.getCurrentUser();
    	int uid = currentUser.getId();
    	
        service.deleteExperience(sn,uid);
    }

}
