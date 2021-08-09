package com.github.evgolya.httpclient;

import org.springframework.stereotype.Component;

import java.net.http.HttpClient;

@Component
public class WeatherApiClient {

    private final HttpClient httpClient;

    public WeatherApiClient() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public void getForecastForLocalityByCoordinates(int days, double latitude, double longitude) {
        // TODO: implement
    }

    public void getCurrentWeatherForLocalityByCoordinates(double latitude, double longitude) {
        // TODO: implement
    }

    public void getForecastForLocalityByCoordinates(int days, String latitude, String longitude) {
        // TODO: implement
    }

    public void getCurrentWeatherForLocalityByCoordinates(String latitude, String longitude) {
        // TODO: implement
    }

    public void getForecastForLocality(int days, String locality) {
        // TODO: implement
    }

    public void getCurrentWeatherForLocality(String locality) {
        // TODO: implement
    }

    public void getForecastForLocalityByIP(int days, String ip) {
        // TODO: implement
    }

    public void getCurrentWeatherForLocalityByIP(String ip) {
        // TODO: implement
    }
}
