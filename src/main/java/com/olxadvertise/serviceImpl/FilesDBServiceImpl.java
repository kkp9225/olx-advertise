package com.olxadvertise.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olxadvertise.entity.FilesDB;
import com.olxadvertise.repo.FilesDBRepo;
import com.olxadvertise.service.FilesDBService;

@Service
public class FilesDBServiceImpl implements FilesDBService{

	@Autowired
	FilesDBRepo filesDBRepo;

	@Override
	public void saveFile(FilesDB response) {
		filesDBRepo.save(response);
	}

	@Override
	public FilesDB getFile(String fileCode) {
		// TODO Auto-generated method stub
		return filesDBRepo.getFile(fileCode);
	}
	
}
