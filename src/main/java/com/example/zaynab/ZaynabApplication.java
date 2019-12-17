package com.example.zaynab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

import java.util.Scanner;

@SpringBootApplication
@EnableJms
public class ZaynabApplication<a> implements CommandLineRunner {
    @Autowired
    private JmsWrapper jmsWrapper;

    public static void main(String[] args) {
        SpringApplication.run(ZaynabApplication.class, args);
    }


        @Override
        public void run(String... args) throws Exception {
            while (true) {
                Scanner scanner = new Scanner(System.in);
                String text = scanner.nextLine();
                jmsWrapper.sendMessage(text);
            }
        }

}
