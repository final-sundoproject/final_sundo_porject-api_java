package com.project.sundo_project.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class FileUploadService {
    private final AwsS3Service s3Service;

    public String uploadProfileImage(MultipartFile profileImage) throws IOException {

        String uniqueFileName = UUID.randomUUID() + "_" + profileImage.getOriginalFilename();

        String url = s3Service.uploadToS3Bucket(profileImage.getBytes(), uniqueFileName);

        return url;
    }
}
