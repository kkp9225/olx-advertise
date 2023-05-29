package com.olxadvertise.serviceImpl;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
//import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.olxadvertise.service.UserServiceDelegate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceDelegateCircuitBreakerImpl implements UserServiceDelegate {

	/*
	 * @Autowired CircuitBreakerFactory ciruitBreakerFactory;
	 */

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	WebClient webClient = WebClient.create();
	
	
	/*
	 * @Override public Boolean isValidUser(String auth_token) { HttpHeaders headers
	 * = new HttpHeaders(); headers.add("Authorization", auth_token);
	 * headers.add("Content-type", MediaType.APPLICATION_JSON_VALUE);
	 * HttpEntity<String> entity = new HttpEntity<>(headers); CircuitBreaker
	 * circuitBreaker = ciruitBreakerFactory.create("AUTH_TOKEN_VALIDATION");
	 * ResponseEntity<Boolean> result = circuitBreaker.run(() -> this.restTemplate
	 * .exchange("http://login-service/token/validate", HttpMethod.GET, entity,
	 * Boolean.class), throwable -> fallbackForIsValidUser(auth_token, throwable));
	 * return result.getBody(); }
	 */

	@Override
	@CircuitBreaker(name = "AUTH_TOKEN_VALIDATION", fallbackMethod = "fallbackForIsValidUser")
	public Boolean isValidUser(String auth_token) {
		/*
		 * HttpHeaders headers=new HttpHeaders();
		 * headers.add("Authorization",auth_token);
		 * headers.add("Content-type",MediaType.APPLICATION_JSON_VALUE);
		 * HttpEntity<String>entity=new HttpEntity<>(headers); return
		 * restTemplate.exchange("http://login-service/token/validate",HttpMethod.GET,
		 * entity,Boolean.class).getBody();
		 */
		Boolean isValid = false;
		try {
			isValid = webClient.get()
			.uri(new URI("http://localhost:7001/token/validate"))
			.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
			.header("Authorization", auth_token)
			.retrieve()
			.onStatus(HttpStatus::is4xxClientError, error -> Mono.error(new RuntimeException("API not found. Please check the url.")))
			.onStatus(HttpStatus::is5xxServerError, error -> Mono.error(new RuntimeException("Internal server error.")))
			.bodyToMono(Boolean.class)
			.block();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("MONO " + isValid);
		return isValid;
	}

	private Boolean fallbackForIsValidUser(String auth_token, Throwable throwable) throws Throwable {
		System.out.println("Login server down " + throwable);
		return false;
	}

}
