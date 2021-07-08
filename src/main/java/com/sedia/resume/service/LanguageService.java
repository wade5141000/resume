
package com.sedia.resume.service;

import com.sedia.resume.entity.LanguageEntity;
import com.sedia.resume.repository.LanguageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LanguageService {

    final LanguageMapper languageMapper;
   // final BCryptPasswordEncoder passwordEncoder;
    



//    //??
//    public EducationEntity save(EducationEntity school) {
//        if (education.findByEducationname(school.name()).isEmpty()) {
//        //	education.setSchool(passwordEncoder.encode(education.getPassword()));
//        	school.setCreateDate(LocalDateTime.now());
//        	education.save(school);
//            return school;
//        }
//        throw new RuntimeException("account already exists");
//    }
    
    // 檢查語言是否存在
    public boolean checkLanguage(int id, int uid) {
    	languageMapper.findByLanguageId(id, uid).orElseThrow(() -> new RuntimeException("找不到 Language"));
		return true;
    }

    // 取得語言
    public LanguageEntity getLanguage(int id, int uid) {
		return languageMapper.findByLanguageId(id, uid).orElseThrow(() -> new RuntimeException("找不到 Language"));
    }
    
    // 取得語言清單技能
    public List<LanguageEntity> getLanguageList(int uid) {
        return languageMapper.findAll(uid);
    }
    
    // 編輯語言
    public void updateLanguage(LanguageEntity language) {    
    	languageMapper.updateLanguage(language);
    }
    
    // 新增語言
    public LanguageEntity insertLanguage(LanguageEntity language) { 
    	languageMapper.insertLanguage(language);
		return language;
    }
    
    // 刪除語言
    public boolean deleteLanguage(int id, int uid) { 
    	languageMapper.deleteLanguage(id, uid);
		return true;
    }
   
}
