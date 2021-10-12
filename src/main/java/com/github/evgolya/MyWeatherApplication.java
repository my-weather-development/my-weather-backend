package com.github.evgolya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class MyWeatherApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyWeatherApplication.class, args);
    }
}
