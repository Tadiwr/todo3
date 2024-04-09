package com.shangwa.todo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.security.PermitAll;

@SpringBootApplication
@RestController
@PermitAll
public class Todo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Todo3Application.class, args);
	}

	@GetMapping("/")
	public String helloWorld() {
		return "Hello world From Shangwa";
	}

}
