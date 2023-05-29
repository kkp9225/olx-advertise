package com.olxadvertise.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.olxadvertise.dto.Advertise;
import com.olxadvertise.entity.AdvertiseEntity;
import com.olxadvertise.repo.AdvertiseRepo;
import com.olxadvertise.service.AdvertiseService;

@Service
public class AdvertiseServiceImplementation implements AdvertiseService {

	@Autowired
	AdvertiseRepo advertiseRepo;
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public Advertise saveAdd(Advertise advertise) {
		AdvertiseEntity newAddEntity = new AdvertiseEntity(advertise.getCategoryId(), advertise.getDescription(),
				advertise.getPrice(), advertise.getTitle());
		newAddEntity = advertiseRepo.save(newAddEntity);
		Advertise advertiseAdded = new Advertise(newAddEntity.getId(), newAddEntity.getTitle(), newAddEntity.getPrice(),
				newAddEntity.getCategoryId(), newAddEntity.getDescription(), newAddEntity.getUsername(),
				newAddEntity.getCreatedDate(), newAddEntity.getModifiedDate(), newAddEntity.getStatus(),
				newAddEntity.getCategory(), newAddEntity.getStatusId());
		return advertiseAdded;
	}

	@Override
	public Advertise updateAdd(int id, Advertise advertise) {
		AdvertiseEntity newAddEntity = new AdvertiseEntity(id, advertise.getTitle(), advertise.getPrice(),
				advertise.getCategoryId(), advertise.getDescription(), advertise.getUsername(), new Date(), new Date(),
				advertise.getStatus(), advertise.getCategory(), advertise.getCategoryId());
		newAddEntity = advertiseRepo.save(newAddEntity);
		Advertise advertiseAdded = new Advertise(newAddEntity.getId(), newAddEntity.getTitle(), newAddEntity.getPrice(),
				newAddEntity.getCategoryId(), newAddEntity.getDescription(), newAddEntity.getUsername(),
				newAddEntity.getCreatedDate(), newAddEntity.getModifiedDate(), newAddEntity.getStatus(),
				newAddEntity.getCategory(), newAddEntity.getStatusId());
		return advertiseAdded;
	}

	@Override
	public List<Advertise> findAll() {
		List<AdvertiseEntity> allAdds = advertiseRepo.findAll();
		List<Advertise> adds = new ArrayList<>();
		for (AdvertiseEntity newAddEntity : allAdds) {
			Advertise advertiseAdded = new Advertise(newAddEntity.getId(), newAddEntity.getTitle(),
					newAddEntity.getPrice(), newAddEntity.getCategoryId(), newAddEntity.getDescription(),
					newAddEntity.getUsername(), newAddEntity.getCreatedDate(), newAddEntity.getModifiedDate(),
					newAddEntity.getStatus(), newAddEntity.getCategory(), newAddEntity.getStatusId());
			adds.add(advertiseAdded);
		}
		System.out.println("All adds are " + adds);
		return adds;
	}

	

	@Override
	public Advertise findAdById(int postId) {
		AdvertiseEntity newAddEntity = new AdvertiseEntity();
		newAddEntity = advertiseRepo.findByPostId(postId);
		Advertise advertiseAdded = new Advertise(newAddEntity.getId(), newAddEntity.getTitle(), newAddEntity.getPrice(),
				newAddEntity.getCategoryId(), newAddEntity.getDescription(), newAddEntity.getUsername(),
				newAddEntity.getCreatedDate(), newAddEntity.getModifiedDate(), newAddEntity.getStatus(),
				newAddEntity.getCategory(), newAddEntity.getStatusId());
		return advertiseAdded;
	}

	@Override
	public void deleteAd(int postId) {
		advertiseRepo.deleteById(postId);
	}
}
