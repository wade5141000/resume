package com.sedia.resume.controller;

import com.sedia.resume.entity.LicenseEntity;
import com.sedia.resume.entity.UserEntity;
import com.sedia.resume.service.LicenseService;
import com.sedia.resume.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class LicenseController {

    final LicenseService service;

    // 取得使用者全部證照列表
    @GetMapping("/license/")
    public List<LicenseEntity> getLicenseList() {
        return service.getLicenseList();
    }

    // 使用者取得證照
    @GetMapping("/license/{sn}")
    public LicenseEntity getLicense(int sn) {
        return service.getLicense(sn);
    }

    // 新增證照資料
    @PostMapping("/license/")
    public boolean insertLicense(@RequestBody LicenseEntity license) {
        return service.insertLicense(license);

    }

    // 更新證照資料
    @PutMapping("/license/")
    public boolean updateLicense(@RequestBody LicenseEntity license) {
        return service.editLicense(license);
    }

    // 刪除證照資料
    @DeleteMapping("/license/{sn}")
    public boolean deleteLicense(@PathVariable int sn) {
        return service.deleteLicense(sn);
    }
}
