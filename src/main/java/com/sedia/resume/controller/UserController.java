package com.sedia.resume.controller;

import com.amazonaws.util.IOUtils;
import com.sedia.resume.domain.AutobiographyRequest;
import com.sedia.resume.domain.ResetPasswordRequest;
import com.sedia.resume.entity.UserEntity;
import com.sedia.resume.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user") // 在user根路徑
public class UserController {

    final UserService service;

    @GetMapping("/all")
    public List<UserEntity> getAllUser() {
        return service.getUsers();
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return service.save(user);
    }

    @PutMapping("/basic-info")
    public boolean updateBasicInfo(@RequestBody UserEntity user) {
        log.debug("Update basic info for: {}", user);
        return service.updateBasicInfo(user);
    }

    @GetMapping
    public UserEntity getUser() {
        return service.getUser();
    }

    @PutMapping("/autobiography")
    public boolean updateAutobiography(@RequestBody AutobiographyRequest request) {
        return service.updateAutobiography(request);
    }

    @PostMapping(value = "/image/upload", consumes = "multipart/form-data")
    public boolean uploadImage(@RequestParam("image") MultipartFile image) throws IOException {

        return service.uptoS3(image);
    }

    @GetMapping("/image")
    public void getImage(HttpServletResponse response) throws IOException {
        int id = service.getCurrentUser().getId();
        String imgPath = service.getImgById(id);
        File file = new ClassPathResource(imgPath).getFile();
        // File file = new ClassPathResource("user.wade/profile/example.jpg").getFile();
        final FileInputStream in = new FileInputStream(file);
        response.setContentType("image/png"); // 如果是 jpg 則為 image/jpeg，svg 為 image/svg+xml 等
        IOUtils.copy(in, response.getOutputStream());
        in.close();
        response.getOutputStream().close();

    }

    // 1. 根據輸入的 email 查詢 user (查詢條件是 account), 查不到就 throw ApiException (含 message)
    // 2. 存入一筆 reset password token 到 DB
    // 3. 發送 email, 回傳 email 發送是否成功
    @PostMapping("/send-token")
    public boolean sendToken(@RequestParam("email") String email, @Value("${sendgrid.api-key}") String sendGridKey,
            @Value("${resume.mail.from}") String from, @Value("${resume.mail.from-name}") String fromName,
            @Value("${resume.mail.frontend-host}") String host) throws Exception {

        // 2. 說明
        // TOKEN = UUID.randomUUID().toString();
        // EXPIRY_DATE = 24小時

        // 3. 說明
        // 參考 TestController testSendMail() 的寫法
        // 信件標題: Reset Password
        // 信件內容(html格式): <h2>請點擊連結：<a href='{url}'>重置你的密碼</a></h2>
        // url = "{host}/resetpw?token={token}

        return false;

    }

    // 1. 根據 token 從 DB 查出 reset password token
    // 2. 檢查該筆 token 還在有效期內且沒有被使用過
    // 3. 回傳有效或無效
    @PostMapping("/check-token") // 檢查 token 是否有效，並且跳轉到修改密碼頁面
    public boolean checkToken(@RequestParam("token") String token) {
        return false;
    }

    // 1. 根據 token 從 DB 查出 reset password token
    // 2. 檢查該筆 token 還在有效期內且沒有被使用過
    // 3. 變更使用者密碼，需要加密，參考 save user
    // 4. 修改 token 為已使用
    // 5. 回傳重置密碼是否成功
    @PostMapping("/reset-password")
    public boolean resetPassword(ResetPasswordRequest request) {
        return false;
    }

}
