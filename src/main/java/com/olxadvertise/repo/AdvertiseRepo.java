package com.olxadvertise.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.olxadvertise.entity.AdvertiseEntity;

public interface AdvertiseRepo  extends JpaRepository<AdvertiseEntity, Integer>{

	@Query("SELECT a FROM AdvertiseEntity a WHERE a.id=?1")
	AdvertiseEntity findByPostId(int postId);

}
