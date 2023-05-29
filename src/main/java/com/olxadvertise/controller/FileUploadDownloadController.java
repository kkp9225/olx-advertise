package com.olxadvertise.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

import com.olxadvertise.entity.FilesDB;
import com.olxadvertise.service.FilesDBService;
import com.olxadvertise.service.UserServiceDelegate;
import com.olxadvertise.util.FileUploadUtil;

@RestController
public class FileUploadDownloadController {

	@Autowired
	UserServiceDelegate userServiceDelegate;
	
	@Autowired 
	FilesDBService filesDBService;
	
	@PostMapping("/uploadFile")
	public ResponseEntity<FilesDB> uploadFile(@RequestHeader("Authorization") String auth_token,
			@RequestParam("file") MultipartFile multipartFile) throws IOException {
		Boolean isValidToken = userServiceDelegate.isValidUser(auth_token);
		if (isValidToken) {
			String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
			long size = multipartFile.getSize();
			String filecode = FileUploadUtil.fileCode(fileName, multipartFile);
			FilesDB response = new FilesDB();
			response.setFileName(fileName);
			response.setSize(size);
			response.setData(multipartFile.getBytes());
			response.setFileType(multipartFile.getContentType());
			response.setDownloadUri("/downloadFile/" + filecode);
			response.setFileCode(filecode);
			filesDBService.saveFile(response);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}

	@GetMapping("/downloadFile/{fileCode}")
	public ResponseEntity<?> downloadFile(@RequestHeader("Authorization") String auth_token,
			@PathVariable("fileCode") String fileCode) {
		Boolean isValidToken = userServiceDelegate.isValidUser(auth_token);
		if (isValidToken) {
			 FilesDB filesDB = filesDBService.getFile(fileCode);
			    return ResponseEntity.ok()
			        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filesDB.getFileName() + "\"")
			        .body(filesDB.getData());
			  }
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
}
