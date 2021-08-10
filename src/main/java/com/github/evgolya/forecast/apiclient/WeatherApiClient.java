package com.github.evgolya.forecast.apiclient;

import com.github.evgolya.vault.WeatherApiKeyProvider;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
@EnableConfigurationProperties(WeatherApiKeyProvider.class)
public class WeatherApiClient {

    private final HttpClient httpClient;
    private final WeatherApiKeyProvider weatherApiKeyProvider;

    public WeatherApiClient(WeatherApiKeyProvider weatherApiKeyProvider) {
        this.weatherApiKeyProvider = weatherApiKeyProvider;
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

    public String getData() {
        final HttpRequest request = HttpRequest.newBuilder()
//            .uri(URI.create("http://api.weatherapi.com/v1/current.json?key=51eaba171ea94bbfbf3203521210908&q=49.444444,32.059722"))
//            .uri(URI.create("http://api.weatherapi.com/v1/forecast.json?key=51eaba171ea94bbfbf3203521210908&q=49.444444,32.059722&days=3"))
            .uri(URI.create("http://api.weatherapi.com/v1/current.json?key="+ weatherApiKeyProvider.getKey() + "&q=49.444444,32.059722"))
            .build();
        try {
            return httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Fail";
    }
}
