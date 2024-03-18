package com.spring.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing // Enabling JPA Auditing
public class SpringbootJpaManyToManyMappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaManyToManyMappingApplication.class, args);
	}

}
