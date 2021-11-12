package com.olxadvertise;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
	
}
