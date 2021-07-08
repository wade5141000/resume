package com.sedia.resume.repository;

import com.sedia.resume.entity.LanguageEntity;

import java.util.List;
import java.util.Optional;

public interface LanguageMapper {
	
	// 查詢資料：回傳所有符合查詢條件的資料
	List<LanguageEntity> findAll(int uid);
	
	// 查詢資料：回傳符合查詢條件的資料
	Optional<LanguageEntity> findByLanguageId(int id, int uid);
	
	// 新增資料
	void insertLanguage(LanguageEntity language);
	
	// 修改資料
	void updateLanguage(LanguageEntity language);
	
	// 刪除資料
	boolean deleteLanguage(int id, int uid);
	
	

}
