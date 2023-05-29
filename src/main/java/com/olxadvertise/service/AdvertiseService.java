package com.olxadvertise.service;

import java.util.List;

import com.olxadvertise.dto.Advertise;

public interface AdvertiseService {

	Advertise saveAdd(Advertise advertise);

	Advertise updateAdd(int id, Advertise advertise);

	List<Advertise> findAll();

	Advertise findAdById(int postId);

	void deleteAd(int postId);

}
