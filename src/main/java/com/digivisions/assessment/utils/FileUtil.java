package com.digivisions.assessment.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class FileUtil {


    public static byte[] getFileAsByteArray(MultipartFile file) {
        try {
            return file.getBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
