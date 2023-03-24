package com.mahesh101.Restaurant.Management;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class RestaurantManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(RestaurantManagementApplication.class, args);
		log.info("Restaurant Management Application is Starting...");

	}
}
