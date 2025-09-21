package com.example.strapi_1.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PropertyLogger implements CommandLineRunner {
 @Value("${spring.mail.username}")
    private String mailUsername;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("============================================================");
        System.out.println("ДИАГНОСТИКА:spring.mail.username:");
        System.out.println("'" + mailUsername + "'");
        System.out.println("============================================================");
    }
}