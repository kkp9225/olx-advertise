package com.olxadvertise.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.olxadvertise.entity.FilesDB;

public interface FilesDBRepo extends JpaRepository<FilesDB, Integer>{

	@Query
	("SELECT f FROM FilesDB f where f.fileCode=?1")
	FilesDB getFile(String fileCode);

}
