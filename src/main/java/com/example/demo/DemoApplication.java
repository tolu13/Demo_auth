package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.JWTutil;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostMapping("/login")
	public String processLogin(@RequestBody LoginRequest LoginRequest) {
		String username = LoginRequest.getUsername();
		String password = LoginRequest.getPassword();
	
		if ("admin".equals(username) && "password1234".equals(password)) {
			String token =JWTutil.generateToken(username);
			return "{\"token\":\""+ token +  "\"}";
		} else {
			return "Invalid username or password.";
		}
	
	}

}
