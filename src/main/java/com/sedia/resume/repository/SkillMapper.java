package com.sedia.resume.repository;

import com.sedia.resume.entity.SkillEntity;

import java.util.List;
import java.util.Optional;

public interface SkillMapper {
	
	// 查詢資料：回傳所有符合查詢條件的資料
	List<SkillEntity> findAll(String id);
	
	// 查詢資料：回傳符合查詢條件的資料
	Optional<SkillEntity> findBySkillSN(int SN, String id);
	
	// 新增資料
	void insertSkill(SkillEntity skill);
	
	// 修改資料
	void updateSkill(SkillEntity skill);
	
	// 刪除資料
	void deleteSkill(int SN, String id);

}
