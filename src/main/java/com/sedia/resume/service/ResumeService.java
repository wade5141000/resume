
package com.sedia.resume.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.sedia.resume.entity.LanguageEntity;
import com.sedia.resume.entity.ResumeEntity;
import com.sedia.resume.entity.UserEntity;
import com.sedia.resume.exception.ApiException;
import com.sedia.resume.repository.LanguageMapper;
import com.sedia.resume.repository.ResumeMapper;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ResumeService {

    final ResumeMapper resumeMapper;
    final UserService userService;

    public ResumeEntity getResume(int id) {
        UserEntity currentUser = userService.getCurrentUser();
        int uid = currentUser.getId();
        return resumeMapper.firstResume(id, uid).orElseThrow(() -> new ApiException("找不到語言"));

    }

    public List<ResumeEntity> getResumeList() {
        UserEntity currentUser = userService.getCurrentUser();
        int uid = currentUser.getId();
        return resumeMapper.listResume(uid);

    }

    public boolean updateResume(ResumeEntity resume) {
        try {

            UserEntity currentUser = userService.getCurrentUser();
            resume.setUid(currentUser.getId());
            resume.setUpdateUser(currentUser.getAccount());
            resume.setUpdateDate(LocalDateTime.now());
            resumeMapper.updateResume(resume);
            return true;
        } catch (Exception e) {
            log.error("更新失敗");
            return false;
        }

    }

    public boolean insertResume(ResumeEntity resume) {
        try {
            log.debug("{}", resume);
            UserEntity currentUser = userService.getCurrentUser();
            resume.setUid(currentUser.getId());
            // 取得cr_user與cr_localdatetime
            resume.setCreateUser(currentUser.getAccount());
            resume.setCreateDate(LocalDateTime.now());
            resumeMapper.insertResume(resume);
            return true;
        } catch (Exception e) {
            log.error("新增失敗", e);
            return false;
        }

    }

    public boolean deleteResume(int id) {
        try {
            UserEntity currentUser = userService.getCurrentUser();
            int uid = currentUser.getId();
            resumeMapper.deleteResume(id, uid);
            return true;
        } catch (Exception e) {
            log.error("刪除失敗", e);
            return false;
        }

    }

    public boolean updateBasicInfo(int id, List<String> basicInfo) {
        try {
            UserEntity currentUser = userService.getCurrentUser();
            int uid = currentUser.getId();
            String UpdatebasicInfo = String.join(",", basicInfo);
            resumeMapper.updateBasicInfo(UpdatebasicInfo, id, uid);
            return true;
        } catch (Exception e) {
            log.error("更新失敗", e);
            return false;
        }
    }
}