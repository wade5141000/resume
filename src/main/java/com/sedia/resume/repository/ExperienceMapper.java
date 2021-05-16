package com.sedia.resume.repository;

import java.util.List;
import java.util.Optional;

import com.sedia.resume.entity.ExperienceEntity;

public interface ExperienceMapper {

	//查詢第一個符合資料
    Optional<ExperienceEntity> firstExperience(int sn,int uid);

    // 經歷資料表 查詢資料清單
    List<ExperienceEntity> listExperience(int uid);

    // 經歷資料表 新增資料
    void insertExperience(ExperienceEntity user);

    // 經歷資料表 修改資料
    ExperienceEntity updateExperience(ExperienceEntity user);

    // 經歷資料表 刪除資料
    void deleteExperience(int sn);

    // 經歷資料表 是否已存在
    boolean isExistExperience(int sn, int uid);

}
