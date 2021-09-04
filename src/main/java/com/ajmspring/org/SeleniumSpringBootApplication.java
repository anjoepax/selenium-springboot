package com.ajmspring.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class SeleniumSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeleniumSpringBootApplication.class, args);
	}
}
