package com.example.dima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class DimaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DimaApplication.class, args);
    }

}
