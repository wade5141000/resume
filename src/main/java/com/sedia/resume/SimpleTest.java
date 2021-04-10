package com.sedia.resume;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class SimpleTest {

	public static void main(String[] args) throws IOException {
		Resource resource = new ClassPathResource("temp/test.txt");
		File file = resource.getFile();
		System.out.println(file);

		String bucket_name = "resume-backend-app";
//		String file_path = "./";
		String key_name = "test";

		System.out.format("Uploading %s to S3 bucket %s...\n", file.getName(), bucket_name);
		final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withRegion(Regions.AP_NORTHEAST_1).build();
		try {
			s3.putObject(bucket_name, key_name, file);
		} catch (AmazonServiceException e) {
			e.printStackTrace();
		}
		System.out.println("Done!");
	}
}
