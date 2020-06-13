package com.web.sample_web.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MultipartFileUtil {

    private static final Map<String, Format> map = new HashMap<>();

    private enum Format {
        JPEG,
        JPG
    }

    static {
        map.put("jpeg", Format.JPEG);
        map.put("jpg", Format.JPG);
    }

    public File toFile(MultipartFile file) {
        try {
            return tryConvertToFile(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private File tryConvertToFile(MultipartFile file) throws IOException {
        var contentType = file.getContentType();
        ifFormatNotSupport(Objects.requireNonNull(contentType));
        var format = getFormat(contentType);
        var tempFile = Files.createTempFile(null, ".".concat(format)).toFile();
        file.transferTo(tempFile);
        return tempFile;
    }

    private void ifFormatNotSupport(String contentType) {
        if (!map.containsKey(getFormat(contentType))) {
            throw new RuntimeException();
        }
    }

    private String getFormat(String contentType) {
        return contentType.split("/")[1].toLowerCase();
    }
}
