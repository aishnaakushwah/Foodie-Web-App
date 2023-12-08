package com.example.NotificationService.controller;

import com.example.NotificationService.domain.Email;
import com.example.NotificationService.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notification")
public class EmailController {
    @Autowired
    EmailService emailService;

    @PostMapping("/email/{email}")
    public ResponseEntity sendMail(@PathVariable String email, @RequestBody Email content){
        return new ResponseEntity<>(emailService.sendEmail(email,content.subject,content.body),HttpStatus.OK);
    }

}