package com.project.sundo_project.evaluation.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Service
@Slf4j
public class AwsS3Service {

    private S3Client s3;

    @Value("${aws.credentials.accessKey}")
    private String accessKey;
    @Value("${aws.credentials.secretKey}")
    private String secretKey;
    @Value("${aws.region}")
    private String region;
    @Value("${aws.bucketName}")
    private String bucketName;

    @PostConstruct
    private void initAmazonS3(){

        AwsBasicCredentials credentials = AwsBasicCredentials.create(accessKey, secretKey);

        this.s3 = S3Client.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();

    }

    public String uploadToS3Bucket(byte[] uploadFile, String fileName){

        String datePath = LocalDate.now().toString().replace("-", "/");
        String fullPath = datePath + "/" + fileName;

        PutObjectRequest request = PutObjectRequest.builder()
                .bucket(bucketName)
                .key(fullPath)
                .build();

        s3.putObject(request, RequestBody.fromBytes(uploadFile));

        return s3.utilities()
                .getUrl(b->b.bucket(bucketName).key(fullPath))
                .toString()
                ;
    }

}
