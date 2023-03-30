package com.capstone.asn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.Capstone")
public class AsnApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsnApplication.class, args);
	}

}
