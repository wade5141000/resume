package com.sedia.resume.repository;

import com.sedia.resume.entity.EducationEntity;

import java.util.List;
import java.util.Optional;

public interface EducationMapper {
	
	// 查詢資料：回傳所有符合查詢條件的資料
	List<EducationEntity> findAll(String id);
	
	// 查詢資料：回傳符合查詢條件的資料
	Optional<EducationEntity> findByEducationSN(int SN, String id);
	
	// 新增資料
	void insertEducation(EducationEntity education);
	
	// 修改資料
	void updateEducation(EducationEntity education);
	
	// 刪除資料
	void deleteEducation(int SN, String id);

}
