package com.sedia.resume.controller;

import com.sedia.resume.utils.AwsUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

/**
 * 這是方便測試使用的 controller，這裡的方法不需要登入使用者也可以操作
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    final AwsUtils awsUtils;

    @GetMapping("/upload")
    public String testUpload() throws IOException {
        Resource resource = new ClassPathResource("temp/test.txt");
        File file = resource.getFile();
        boolean result = awsUtils.uploadToS3(file);
        if (result) {
            return "上傳成功";
        }
        return "上傳失敗";
    }

}
