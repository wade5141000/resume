
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
import com.sedia.resume.repository.ResumeRelationMapper;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class ResumeService {

    final ResumeMapper mapper;
    final ResumeRelationMapper resumeMapper;
    final UserService userService;

    public ResumeEntity getResume(int id) {
        UserEntity currentUser = userService.getCurrentUser();
        int uid = currentUser.getId();
        return mapper.firstResume(id, uid).orElseThrow(() -> new ApiException("找不到語言"));

    }

    public List<ResumeEntity> getResumeList() {
        UserEntity currentUser = userService.getCurrentUser();
        int uid = currentUser.getId();
        return mapper.listResume(uid);

    }

    public boolean updateResume(ResumeEntity resume) {
        try {

            UserEntity currentUser = userService.getCurrentUser();
            resume.setUid(currentUser.getId());
            resume.setUpdateUser(currentUser.getAccount());
            resume.setUpdateDate(LocalDateTime.now());
            mapper.updateResume(resume);
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
            mapper.insertResume(resume);
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
            mapper.deleteResume(id, uid);
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
            mapper.updateBasicInfo(UpdatebasicInfo, id, uid);
            return true;
        } catch (Exception e) {
            log.error("更新失敗", e);
            return false;
        }
    }

    // 使用者挑選resumeId根據自己需要的eduId加入
    public boolean updateResumeEducation(int id, List<Integer> educationId) {
        // 資料庫rel_resume_edu table的RID跟EDU_ID都是PrimeKey
        resumeMapper.deleteResumeEducation(id);

        for (int i = 0; i < educationId.size(); i++) {
            resumeMapper.insertResumeEducation(id, educationId.get(i));
        }

        return true;
    }

    public boolean updateResumeExperience(int id, List<Integer> experienceId) {
        resumeMapper.deleteResumeExperience(id);

        for (int i = 0; i < experienceId.size(); i++) {
            resumeMapper.insertResumeExperience(id, experienceId.get(i));
        }

        return true;
    }

    public boolean updateResumeLanguage(int id, List<Integer> languageId) {
        resumeMapper.deleteResumeLanguage(id);

        for (int i = 0; i < languageId.size(); i++) {
            resumeMapper.insertResumeLanguage(id, languageId.get(i));
        }

        return true;
    }

    public boolean updateResumeLicense(int id, List<Integer> licenseId) {
        resumeMapper.deleteResumeLicense(id);

        for (int i = 0; i < licenseId.size(); i++) {
            resumeMapper.insertResumeLicense(id, licenseId.get(i));
        }

        return true;
    }

    public boolean updateResumeSkill(int id, List<Integer> skillId) {
        resumeMapper.deleteResumeSkill(id);

        for (int i = 0; i < skillId.size(); i++) {
            resumeMapper.insertResumeSkill(id, skillId.get(i));
        }

        return true;
    }

}
