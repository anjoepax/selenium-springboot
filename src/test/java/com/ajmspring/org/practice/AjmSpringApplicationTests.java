package com.ajmspring.org.practice;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class AjmSpringApplicationTests {

	@Autowired
	private Faker faker;

	//@Test
	void contextLoads() {
		System.out.println(faker.name().firstName());
	}
}

