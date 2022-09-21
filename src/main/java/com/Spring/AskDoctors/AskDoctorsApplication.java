package com.Spring.AskDoctors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.Spring.AskDoctors.*"
})
public class AskDoctorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AskDoctorsApplication.class, args);
	}

}
