package com.sedia.resume.service;

import com.sedia.resume.repository.ExperienceMapper;
import com.sedia.resume.entity.ExperienceEntity;
import com.sedia.resume.exception.ApiException;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ExperienceService {

    final ExperienceMapper experienceMapper;

    // 檢查經歷ID是否存在
    public boolean checkExperienceID(int sn, int uid) {
        if (experienceMapper.isExistExperience(sn, uid))
            return true;
        else
            return false;
    }

    // 取得經歷
    public ExperienceEntity getExperience(int sn,int uid) {
    	return experienceMapper.firstExperience(sn, uid).orElseThrow(() -> new RuntimeException("找不到 證照"));
        }

    // 取得經歷清單
    public List<ExperienceEntity> getExperienceList(int uid) {
        return experienceMapper.listExperience(uid);
    }

    // 編輯經歷
    public ExperienceEntity editExperience(ExperienceEntity experience) {
        experienceMapper.updateExperience(experience);
        return experience;
    }

    // 新增經歷
    public void insertExperience(ExperienceEntity experience) {
        experienceMapper.insertExperience(experience);

    }

    // 刪除經歷
    public void deleteExperience(int uid,int sn) {
        experienceMapper.deleteExperience(uid,sn);
        
    }

    // //controller的儲存方法
    // /*針對介面的定義有些疑問，該如何介定那些是需要另外寫save這類方法的*/
    // public ExperienceEntity save(ExperienceEntity user) {
    // if (experienceMapper.firstExperience(user.getSn(),user.getUid()).isEmpty()) {
    //
    //// user.setCreateDate(LocalDateTime.now());
    //// license可用@setter,
    // experienceMapper.save(user);
    // return user;
    // }
    // throw new RuntimeException("License already exists");
    // }
}
