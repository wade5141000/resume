package com.sedia.resume.service;
import com.sedia.resume.repository.LicenseMapper;
import com.sedia.resume.entity.LicenseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class LicenseService {
	
	//@RequiredArgsConstructor不需做初始化
	final LicenseMapper licenseMapper;
	
	
	//確認證照ID是否存在
	public boolean checkLicenseID(int sn,String uid){
		if(licenseMapper.isExistLicense(sn,uid))
			return true;
		else 
			return false;
	}
	
	//取得證照
	//0422先保留exception
	public LicenseEntity getLicense(int sn,String uid){
		return licenseMapper.findFirstLicense(sn,uid).orElseThrow(() -> new RuntimeException("找不到 證照"));
//		return licenseMapper.findById(id).orElseThrow(() -> new RuntimeException("找不到 User"));
	}
	
	//取得證照清單
	public List<LicenseEntity> getLicenseList(String uid){
		return licenseMapper.findAll(uid);
	}
	
	//編輯證照
	public LicenseEntity editLicense(LicenseEntity license){
		return licenseMapper.updateLicense(license);
	}
	
	//新增證照
	public LicenseEntity insertLicense(LicenseEntity license){
		return licenseMapper.insertLicense(license);
	}
	
	//刪除證照
	public boolean deleteLicense(int sn,String uid){
		licenseMapper.deleteLicense(sn,uid);
		return true;
	}
	
	
	
}
