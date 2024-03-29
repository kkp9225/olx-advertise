package com.olxadvertise;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class OlxAdvertiseApplication {

	public static void main(String[] args) {
		SpringApplication.run(OlxAdvertiseApplication.class, args);
	}

	@Bean
	public Docket getCustomizedDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.olxadvertise"))
				.build()
				.apiInfo(buildApiDoc());
	}
	
	private ApiInfo buildApiDoc() {
		return new ApiInfo("Advertise API", "This API helps to see advertises", "1.0.0", "https://zensar.com/policy", new Contact("Kartik", "/zensar.com", "kartik.patil@zensar.com"), "GPL", "http://gpl.com", new ArrayList<VendorExtension>());
	}
	
	@Bean
	@LoadBalanced
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }
	
	 @Bean
	    WebClient webClient(WebClient.Builder builder) {
	        return builder.build();
	    }
	
}
