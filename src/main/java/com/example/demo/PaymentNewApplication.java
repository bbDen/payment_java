package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.demo.controllers")
@ComponentScan("com.example.demo.interceptor")
public class PaymentNewApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentNewApplication.class, args);
	}

}
