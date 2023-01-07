package com.khiempm1.mindx.demo.orb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ResumeBuilderApp {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(ResumeBuilderApp.class);
        springApplication.run(args);
    }
}
