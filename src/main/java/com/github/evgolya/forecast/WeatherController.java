package com.github.evgolya.forecast;

import com.github.evgolya.forecast.apiclient.WeatherApiClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final WeatherApiClient weatherApiClient;

    public WeatherController(WeatherApiClient weatherApiClient) {
        this.weatherApiClient = weatherApiClient;
    }

    @GetMapping("/")
    public String getData() {
        return weatherApiClient.getData();
    }
}
