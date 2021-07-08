package com.sedia.resume.repository;

import com.sedia.resume.entity.EducationEntity;

import java.util.List;
import java.util.Optional;


public interface EducationMapper {
	
	
	// 查詢資料：回傳所有符合查詢條件的資料
	List<EducationEntity> findAll(int uid);
	
	// 查詢資料：回傳符合查詢條件的資料
	Optional<EducationEntity> findByEducationId(int id, int uid);
	
	// 新增資料
	void insertEducation(EducationEntity education);
	
	// 更新資料
	void updateEducation(EducationEntity education);
	
	// 刪除資料
	boolean deleteEducation(int id, int uid);
	
	
}
