package com.example.simple_biosamples_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.simple_biosamples_client.*")
public class SimpleBiosamplesClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleBiosamplesClientApplication.class, args);
	}
}
