package com.ing.atm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class AtmApplication {
	public static void main(String[] args) {
		SpringApplication.run(AtmApplication.class, args);
	}
}
