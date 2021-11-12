package com.olxadvertise.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

@RestController
public class AdvertiseController {

	private static final String TOKEN = "KkPaTil25011992";
	
	@PostMapping("/hi")
	public ResponseEntity<?> sayHi(){
		return new ResponseEntity<>("HI! Welcome to Springboot Microservices", HttpStatus.OK);
	}
	
	@PostMapping("/advertise")
	public ResponseEntity<?> advertise(@RequestBody Advertise advertise, @RequestHeader String auth_token){
		if(auth_token.equals(TOKEN)) {
			advertise.setId(1);
			advertise.setTitle("laptop sale");
			advertise.setPrice("54000");
			advertise.setCategory("Electronic goods");
			advertise.setDescription("intel core 3 Sony Vaio");
			advertise.setCreatedDate(new Date());
			advertise.setModifiedDate(null);
			advertise.setStatus("OPEN");
			return new ResponseEntity<>(advertise, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/advertise/{id}")
	public ResponseEntity<?> updateAdvertise(@PathVariable int id, @RequestBody Advertise advertise, @RequestHeader String auth_token){
		if(auth_token.equals(TOKEN)) {
			advertise.setId(id);
			advertise.setCreatedDate(new Date());
			advertise.setModifiedDate(new Date());
			advertise.setStatus("OPEN");
			return new ResponseEntity<>(advertise, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/user/advertise")
	public ResponseEntity<?> userAdvertises(@RequestHeader String auth_token){
		if(auth_token.equals(TOKEN)) {
			Advertise ad1 = new Advertise();
			ad1.setId(1);
			ad1.setTitle("laptop sale");
			ad1.setPrice("54000");
			ad1.setCategory("Electronic goods");
			ad1.setDescription("intel core 3 Sony Vaio");
			ad1.setCreatedDate(new Date());
			ad1.setModifiedDate(null);
			ad1.setStatus("OPEN");
			
			Advertise ad2 = new Advertise();
			ad2.setId(2);
			ad2.setTitle("Sofa available for sale");
			ad2.setPrice("30000");
			ad2.setCategory("Furniture");
			ad2.setDescription("Sofa 5 years old available for Sale in Pune");
			ad2.setCreatedDate(new Date());
			ad2.setModifiedDate(null);
			ad2.setStatus("OPEN");
			List<Advertise> arrAdvertises = new ArrayList<>();
			arrAdvertises.add(ad1);
			arrAdvertises.add(ad2);
			return new ResponseEntity<>(arrAdvertises, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/user/advertise/{postId}")
	public ResponseEntity<?> userAdvertiseDetail(@PathVariable int postId, @RequestHeader String auth_token){
		if(auth_token.equals(TOKEN)) {
			Advertise ad1 = new Advertise();
			ad1.setId(1);
			ad1.setTitle("laptop sale");
			ad1.setPrice("54000");
			ad1.setCategory("Electronic goods");
			ad1.setDescription("intel core 3 Sony Vaio");
			ad1.setCreatedDate(new Date());
			ad1.setModifiedDate(null);
			ad1.setStatus("OPEN");
			
			return new ResponseEntity<>(ad1, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/user/advertise/{postId}")
	public ResponseEntity<?> deleteUserAdvertise(@PathVariable int postId, @RequestHeader String auth_token){
		if(auth_token.equals(TOKEN)) {
			return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
		}
		return new ResponseEntity<>(Boolean.FALSE,HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/advertise/search/filtercriteria")
	public ResponseEntity<?> searchUserAdvertiseFilterCriteria(){
			Advertise ad1 = new Advertise();
			ad1.setId(1);
			ad1.setTitle("laptop sale");
			ad1.setPrice("54000");
			ad1.setCategory("Electronic goods");
			ad1.setDescription("intel core 3 Sony Vaio");
			ad1.setCreatedDate(new Date());
			ad1.setModifiedDate(null);
			ad1.setStatus("OPEN");
			
			Advertise ad2 = new Advertise();
			ad2.setId(2);
			ad2.setTitle("Sofa available for sale");
			ad2.setPrice("30000");
			ad2.setCategory("Furniture");
			ad2.setDescription("Sofa 5 years old available for Sale in Pune");
			ad2.setCreatedDate(new Date());
			ad2.setModifiedDate(null);
			ad2.setStatus("OPEN");
			List<Advertise> arrAdvertises = new ArrayList<>();
			arrAdvertises.add(ad1);
			arrAdvertises.add(ad2);
			return new ResponseEntity<>(arrAdvertises, HttpStatus.OK);
	}

	@GetMapping("/advertise/search")
	public ResponseEntity<?> searchUserAdvertise(){
			Advertise ad1 = new Advertise();
			ad1.setId(1);
			ad1.setTitle("laptop sale");
			ad1.setPrice("54000");
			ad1.setCategory("Electronic goods");
			ad1.setDescription("intel core 3 Sony Vaio");
			ad1.setCreatedDate(new Date());
			ad1.setModifiedDate(null);
			ad1.setStatus("OPEN");
			
			Advertise ad2 = new Advertise();
			ad2.setId(2);
			ad2.setTitle("Sofa available for sale");
			ad2.setPrice("30000");
			ad2.setCategory("Furniture");
			ad2.setDescription("Sofa 5 years old available for Sale in Pune");
			ad2.setCreatedDate(new Date());
			ad2.setModifiedDate(null);
			ad2.setStatus("OPEN");
			List<Advertise> arrAdvertises = new ArrayList<>();
			arrAdvertises.add(ad1);
			arrAdvertises.add(ad2);
			return new ResponseEntity<>(arrAdvertises, HttpStatus.OK);
	}

	@GetMapping("/advertise/{postId}")
	public ResponseEntity<?> deleteAdvertise(@PathVariable int postId, @RequestHeader String auth_token){
		if(auth_token.equals(TOKEN)) {
			Advertise ad1 = new Advertise();
			ad1.setId(1);
			ad1.setTitle("laptop sale");
			ad1.setPrice("54000");
			ad1.setCategory("Electronic goods");
			ad1.setDescription("intel core 3 Sony Vaio");
			ad1.setCreatedDate(new Date());
			ad1.setModifiedDate(null);
			ad1.setStatus("OPEN");
			
			return new ResponseEntity<>(ad1, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
