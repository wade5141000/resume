
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
    public boolean checkEducation(int SN, String id) {
    	try {
    		educationMapper.findByEducationSN(SN,id).orElseThrow(() -> new RuntimeException("找不到 Education"));
    	}
    	catch(RuntimeException ex) {
    		return false;
    	}
    	
    	return true;
    }
 
    // 取得學歷
    public EducationEntity getEducation(int SN, String id) {
		return educationMapper.findByEducationSN(SN,id).orElseThrow(() -> new RuntimeException("找不到 Education"));
    }
    // 取得學歷清單
    public List<EducationEntity> getEducationList(String id) {
        return educationMapper.findAll(id);
    }
    
    // 編輯學歷
    public EducationEntity updateEducation(EducationEntity school) {    
    	educationMapper.updateEducation(school);
		return school;
    }
    
    // 新增學歷
    public EducationEntity insertEducation(EducationEntity school) { 
    	educationMapper.insertEducation(school);
		return school;
    }
    
    // 刪除學歷
    public boolean deleteEducation(int SN, String id) { 
    	educationMapper.deleteEducation(SN, id);
		return true;
    }
    
}
