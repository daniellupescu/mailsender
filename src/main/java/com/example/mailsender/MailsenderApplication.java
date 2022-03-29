package com.example.mailsender;

import com.example.mailsender.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MailsenderApplication implements CommandLineRunner {

    @Autowired
    private MailService mailService;

    public static void main(String[] args) {
        SpringApplication.run(MailsenderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        mailService.sendMail();
    }
}