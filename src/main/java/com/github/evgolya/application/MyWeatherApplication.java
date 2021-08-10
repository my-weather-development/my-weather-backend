package com.github.evgolya.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.github.evgolya.*")
public class MyWeatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyWeatherApplication.class, args);
    }
}
