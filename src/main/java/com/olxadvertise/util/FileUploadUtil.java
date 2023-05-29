package com.olxadvertise.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

	public static String fileCode(String fileName, MultipartFile multipartFile)
            throws IOException {
        String fileCode = RandomStringUtils.randomAlphanumeric(8);
        return fileCode;
    }
}
