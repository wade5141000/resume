// package com.sedia.resume.utils;
//
// import lombok.RequiredArgsConstructor;
// import lombok.extern.slf4j.Slf4j;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.mail.MailSender;
// import org.springframework.stereotype.Service;
//
// import java.io.File;
// import java.io.InputStream;
//
// @Service
// @RequiredArgsConstructor
// @Slf4j
// public class AwsUtils {
//
// @Value("${cloud.aws.s3.bucket-name}")
// String bucketName;
//
// // final AmazonS3 s3Client;
//
//// final MailSender mailSender;
//
// public boolean uploadFileToS3(File file) {
// // String path = "test/";
// String fileName = file.getName();
// log.info("Uploading file: [{}] to aws s3.", fileName);
// try {
// // s3Client.putObject(new PutObjectRequest(bucketName, fileName, file));
// log.info("Upload to aws s3 successful.");
// } catch (Exception e) {
// log.error("Upload to aws s3 failed.", e);
// return false;
// }
// return true;
// }
//
// public InputStream downloadFileFromS3(String fileName) {
// log.info("Downloading file: [{}] from aws s3.", fileName);
// try {
// // return s3Client.getObject(bucketName, fileName).getObjectContent();
// return null;
// } catch (Exception e) {
// log.error("Download file: [{}] from aws s3 failed.", fileName, e);
// throw e;
// }
// }
//
// // public boolean sendMail() {
// // SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
// // simpleMailMessage.setFrom("wade5141000@outlook.com");
// // simpleMailMessage.setTo("wade5141000@outlook.com");
// // simpleMailMessage.setSubject("test subject");
// // simpleMailMessage.setText("test text");
// // mailSender.send(simpleMailMessage);
// // return true;
// // }
//
// }
