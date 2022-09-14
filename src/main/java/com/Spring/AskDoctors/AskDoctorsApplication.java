package com.Spring.AskDoctors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.Spring.AskDoctors.services.UserService;

//@EnableCaching


@SpringBootApplication(scanBasePackages = {
	"com.Spring.AskDoctors"
})
public class AskDoctorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AskDoctorsApplication.class, args);
	}



}
