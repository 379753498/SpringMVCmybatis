package com.devtest.testserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.devtest.*")
public class TestngApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestngApplication.class, args);
    }
}
