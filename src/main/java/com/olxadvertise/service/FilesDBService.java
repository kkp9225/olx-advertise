package com.olxadvertise.service;

import com.olxadvertise.entity.FilesDB;

public interface FilesDBService {

	void saveFile(FilesDB response);

	FilesDB getFile(String fileCode);

}
