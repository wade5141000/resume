package com.sedia.resume.repository;

import java.util.List;
import java.util.Optional;

import com.sedia.resume.entity.LicenseEntity;

public interface LicenseMapper {
    // 這邊最為關鍵，可確定物件在API傳遞的型態
    // 要問的是這邊是抽象化行為，那需要丟入的型態分別該為什麼型態?也就是使用者行為及annie那邊
    // 從ctrl->service->repostitory->DB

    // 證照資料表 查詢第一筆符合查詢的資料
    Optional<LicenseEntity> findFirstLicense(int sn, int uid);

    // 證照資料表 查詢資料
    List<LicenseEntity> findAll(int uid);

    // 證照資料表 新增資料
    LicenseEntity insertLicense(LicenseEntity license);

    // 證照資料表 修改資料
    LicenseEntity updateLicense(LicenseEntity license);

    // 證照資料表 刪除資料
    LicenseEntity deleteLicense(int sn, int uid);

    // 證照資料表 是否已存在
    boolean isExistLicense(int sn, String uid);

}
