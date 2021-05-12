package com.searchservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SearchService1Application {

	public static void main(String[] args) {
		SpringApplication.run(SearchService1Application.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate gettemplate(){return new RestTemplate();}
}