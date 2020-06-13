package com.web.sample_web.service.impl;

import com.web.sample_web.service.StorageService;
import com.web.sample_web.service.UploadService;
import com.web.sample_web.util.MultipartFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class DefaultUploadService implements UploadService {

    private final StorageService storageService;

    @Autowired
    public DefaultUploadService(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public String upload(MultipartFile multipartFile) {
        File file = new MultipartFileUtil().toFile(multipartFile);
        return storageService.upload(file);
    }

}
