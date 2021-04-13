package com.sedia.resume.utils;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@RequiredArgsConstructor
@Slf4j
public class AwsUtils {

    @Value("${cloud.aws.s3.bucket-name}")
    String bucketName;

    final AmazonS3 s3Client;

    public boolean uploadToS3(File file) {
        // String path = "test/";
        String fileName = file.getName();
        log.info("Uploading file: [{}] to aws s3.", fileName);
        try {
            s3Client.putObject(new PutObjectRequest(bucketName, fileName, file));
            log.info("Upload to aws s3 successful.");
        } catch (Exception e) {
            log.error("Upload to aws s3 failed.", e);
            return false;
        }
        return true;
    }

}
