
package com.sedia.resume.service;

import com.sedia.resume.entity.EducationEntity;
import com.sedia.resume.repository.EducationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EducationService {

    final EducationMapper educationMapper;
    
    // 檢查學歷是否存在
    public boolean checkEducation(int uid) {
    	try {
    		educationMapper.findByEducationID(uid).orElseThrow(() -> new RuntimeException("找不到 Education"));
    	}
    	catch(RuntimeException ex) {
    		return false;
    	}
    	
    	return true;
    }
 
    // 取得學歷
    public EducationEntity getEducation(int uid) {
		return educationMapper.findByEducationID(uid).orElseThrow(() -> new RuntimeException("找不到 Education"));
    }
    // 取得學歷清單
    public List<EducationEntity> getEducationList(int uid) {
        return educationMapper.findAll(uid);
    }
    
    // 編輯學歷
    public EducationEntity updateEducation(EducationEntity school) {    
    	educationMapper.updateEducation(school);
		return school;
    }
    
    // 新增學歷
    public void insertEducation(EducationEntity school) { 
    	educationMapper.insertEducation(school);
    }
    
    // 刪除學歷
    public boolean deleteEducation(int uid) { 
    	educationMapper.deleteEducation(uid);
		return true;
    }
    
 // 確認資料是否存在
    public boolean isExistEducation(int uid) { 
    	educationMapper.isExistEducation(uid);
		return true;
    }
    
}



