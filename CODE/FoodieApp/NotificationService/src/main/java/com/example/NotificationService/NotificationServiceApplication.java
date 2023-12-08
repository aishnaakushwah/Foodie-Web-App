package com.example.NotificationService;

import com.example.NotificationService.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NotificationServiceApplication {
	@Autowired
	private EmailService emailService;
	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}


}