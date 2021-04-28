package com.sedia.resume.repository;

import java.util.List;
import java.util.Optional;

import com.sedia.resume.entity.ExperienceEntity;

public interface ExperienceMapper {

    // 經歷資料表 查詢首筆符合資料
    // 是以sn?uid?Str?做查詢
    // 概念是存取資料時，一定要有sn,uid做存取，新增時則要實體去指派資料
    Optional<ExperienceEntity> firstExperience(int sn, int uid);

    // 經歷資料表 查詢資料清單
    List<ExperienceEntity> listExperience(int uid);

    // 經歷資料表 新增資料
    ExperienceEntity insertExperience(ExperienceEntity user);

    // 經歷資料表 修改資料
    ExperienceEntity updateExperience(ExperienceEntity user);

    // 經歷資料表 刪除資料
    boolean deleteExperience(int sn, int uid);

    // 經歷資料表 是否已存在
    boolean isExistExperience(int sn, int uid);

}
