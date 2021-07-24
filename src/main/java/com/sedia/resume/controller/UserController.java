package com.sedia.resume.controller;

import com.amazonaws.util.IOUtils;
import com.itextpdf.styledxmlparser.css.media.MediaType;
import com.sedia.resume.entity.UserEntity;
import com.sedia.resume.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user") // 在user根路徑
public class UserController {

    final UserService service;

    @GetMapping
    public List<UserEntity> getUser() {
        UserEntity currentUser = service.getCurrentUser(); // 取得當前登入的使用者
        return service.getUsers();
    }

    @PostMapping
    public UserEntity createUser(@RequestBody UserEntity user) {
        return service.save(user);
    }

    @GetMapping("/{id}")
    public UserEntity getUser(@PathVariable int id) {
        return service.getUserById(id);
    }

    /**
     * TODO 1. 將圖片存到 resources/user/{userId}/profile/{檔案名稱} (以後要換到 AWS S3 上) 2. 檔案名稱要替換，上傳新的圖片，舊的要刪掉 3. 儲存路徑寫入 user
     * imgPath 欄位 4. 回傳成功 or 失敗
     * 
     * @throws IOException
     */
    @PostMapping(value = "/image/upload", consumes = "multipart/form-data")
    public boolean uploadImage(@RequestParam("image") MultipartFile image) throws IOException {

        return service.uptoS3(image);
    }

    /**
     * TODO 1. 根據登入使用者的 img_path 欄位資訊，從 resource 取得圖片 (以後要換到 AWS S3 上) 2. 使用 response 把檔案回傳至 consumer
     */

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

}
