package com.sedia.resume.controller;

import com.sedia.resume.entity.LicenseEntity;
import com.sedia.resume.service.LicenseService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LicenseController {

    final LicenseService service; // 服務者的請求.sn,uid

    // 取得全部證照列表
    @GetMapping("/license/{id}") // http標籤
    public List<LicenseEntity> getLicenseList(int uid) {
        return service.getLicenseList(uid);
    }

    // 取得證照
    @GetMapping("/license/{SN}&{id}")
    public LicenseEntity getLicense(@PathVariable int sn, int uid) {
        return service.getLicense(sn, uid);
    }

    // 以下是4/17確認將功能拆分。額外的method,新增()、編輯()、更新()、boolean刪除()
    // 新增證照資料
    @PostMapping("/license")
    public LicenseEntity insertLicense(@RequestBody LicenseEntity license) {
        return service.insertLicense(license);

    }

    // 更新證照資料
    @PutMapping("/license")
    public LicenseEntity updateLicense(@RequestBody LicenseEntity license) {
        return service.editLicense(license);
    }

    // 刪除證照資料
    @DeleteMapping("/license/{SN}&{id}")
    public boolean deleteLicense(@PathVariable int sn, int uid) {
        return service.deleteLicense(sn, uid);
    }
}
