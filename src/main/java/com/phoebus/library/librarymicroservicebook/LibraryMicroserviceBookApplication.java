package com.phoebus.library.librarymicroservicebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LibraryMicroserviceBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryMicroserviceBookApplication.class, args);
	}

}
