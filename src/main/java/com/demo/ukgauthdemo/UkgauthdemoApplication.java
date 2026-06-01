package com.demo.ukgauthdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UkgauthdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UkgauthdemoApplication.class, args);

	}

}
