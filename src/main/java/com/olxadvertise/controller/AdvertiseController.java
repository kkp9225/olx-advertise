package com.olxadvertise.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.olxadvertise.dto.Advertise;
import com.olxadvertise.service.AdvertiseService;
import com.olxadvertise.service.UserServiceDelegate;

import io.swagger.annotations.ApiOperation;

@RestController
public class AdvertiseController {

	@Autowired
	AdvertiseService advertiseService;
	
	@Autowired
	UserServiceDelegate userServiceDelegate; 
	
	@PostMapping("/hi")
	public ResponseEntity<?> sayHi(){
		return new ResponseEntity<>("HI! Welcome to Springboot Microservices", HttpStatus.OK);
	}
	
	@PostMapping("/advertise")
	@ApiOperation(value = "This service helps to post new advertise")
	public ResponseEntity<?> advertise(@RequestHeader("Authorization") String auth_token, @RequestBody Advertise advertise){
		Boolean isValidToken = userServiceDelegate.isValidUser(auth_token);
		if(isValidToken) {
			Advertise advertiseAdded = advertiseService.saveAdd(advertise); 
			return new ResponseEntity<>(advertiseAdded, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
	
	@PutMapping("/advertise/{id}")
	@ApiOperation(value = "This service helps to update advertise")
	public ResponseEntity<?> updateAdvertise(@PathVariable int id, @RequestBody Advertise advertise, @RequestHeader("Authorization") String auth_token){
		Boolean isValidToken = userServiceDelegate.isValidUser(auth_token);
		if(isValidToken) {
			Advertise updateAdvertise = advertiseService.updateAdd(id, advertise);
			return new ResponseEntity<>(updateAdvertise, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
	
	@GetMapping("/advertise/{postId}")
	@ApiOperation(value = "This service helps to view particular advertise details")
	public ResponseEntity<?> getAdvertiseDetails(@PathVariable int postId, @RequestHeader("Authorization") String auth_token){
		Boolean isValidToken = userServiceDelegate.isValidUser(auth_token);
		if(isValidToken) {
			Advertise ad1 = advertiseService.findAdById(postId);
			
			return new ResponseEntity<>(ad1, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
	
	@DeleteMapping("/advertise/{postId}")
	@ApiOperation(value = "This service helps to delete particular advertise posted by logged in user")
	public ResponseEntity<?> deleteUserAdvertise(@PathVariable int postId, @RequestHeader("Authorization") String auth_token){
		Boolean isValidToken = userServiceDelegate.isValidUser(auth_token);
		if(isValidToken) {
			advertiseService.deleteAd(postId);
			return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		}
		return new ResponseEntity<>(Boolean.FALSE,HttpStatus.UNAUTHORIZED);
	}

	/*
	 * @GetMapping("/user/advertise/{postId}")
	 * 
	 * @ApiOperation(value =
	 * "This service helps to view particular advertise posted by logged in user")
	 * public ResponseEntity<?> userAdvertiseDetail(@PathVariable int
	 * postId, @RequestHeader("Authorization") String auth_token){ Boolean
	 * isValidToken = userServiceDelegate.isValidUser(auth_token); if(isValidToken)
	 * { Advertise ad1 = new Advertise(); ad1 = advertiseService.findAdById(postId);
	 * 
	 * return new ResponseEntity<>(ad1, HttpStatus.OK); } return new
	 * ResponseEntity<>(HttpStatus.UNAUTHORIZED); }
	 */

	

	/*
	 * @GetMapping("/advertise/search/filtercriteria")
	 * 
	 * @ApiOperation(value =
	 * "This service helps to search particular advertise by filter") public
	 * ResponseEntity<?> searchUserAdvertiseFilterCriteria(){ Advertise ad1 = new
	 * Advertise(); ad1.setId(1); ad1.setTitle("laptop sale");
	 * ad1.setPrice("54000"); ad1.setCategory("Electronic goods");
	 * ad1.setDescription("intel core 3 Sony Vaio"); ad1.setCreatedDate(new Date());
	 * ad1.setModifiedDate(null); ad1.setStatus("OPEN");
	 * 
	 * Advertise ad2 = new Advertise(); ad2.setId(2);
	 * ad2.setTitle("Sofa available for sale"); ad2.setPrice("30000");
	 * ad2.setCategory("Furniture");
	 * ad2.setDescription("Sofa 5 years old available for Sale in Pune");
	 * ad2.setCreatedDate(new Date()); ad2.setModifiedDate(null);
	 * ad2.setStatus("OPEN"); List<Advertise> arrAdvertises = new ArrayList<>();
	 * arrAdvertises.add(ad1); arrAdvertises.add(ad2); return new
	 * ResponseEntity<>(arrAdvertises, HttpStatus.OK); }
	 * 
	 * @GetMapping("/advertise/search")
	 * 
	 * @ApiOperation(value =
	 * "This service helps to search particular advertise by searchtext") public
	 * ResponseEntity<?> searchUserAdvertise(){ Advertise ad1 = new Advertise();
	 * ad1.setId(1); ad1.setTitle("laptop sale"); ad1.setPrice("54000");
	 * ad1.setCategory("Electronic goods");
	 * ad1.setDescription("intel core 3 Sony Vaio"); ad1.setCreatedDate(new Date());
	 * ad1.setModifiedDate(null); ad1.setStatus("OPEN");
	 * 
	 * Advertise ad2 = new Advertise(); ad2.setId(2);
	 * ad2.setTitle("Sofa available for sale"); ad2.setPrice("30000");
	 * ad2.setCategory("Furniture");
	 * ad2.setDescription("Sofa 5 years old available for Sale in Pune");
	 * ad2.setCreatedDate(new Date()); ad2.setModifiedDate(null);
	 * ad2.setStatus("OPEN"); List<Advertise> arrAdvertises = new ArrayList<>();
	 * arrAdvertises.add(ad1); arrAdvertises.add(ad2); return new
	 * ResponseEntity<>(arrAdvertises, HttpStatus.OK); }
	 */

	
}
