package com.devops.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@RestController
public class MyApp {

	@GetMapping("/")
	public String defaultPage() {
		return "NEW COMMIT !!"; // Customize this
																									// message as needed
	}

	@GetMapping("/message")
	public String displayMessage() {
		return "Test completed successfully!";
	}

	public static void main(String[] args) {
		SpringApplication.run(MyApp.class, args);
	}
}
