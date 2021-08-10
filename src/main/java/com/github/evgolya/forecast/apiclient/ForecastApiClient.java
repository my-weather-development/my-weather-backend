package com.github.evgolya.forecast.apiclient;

import com.github.evgolya.forecast.WeatherApiConstants;
import com.github.evgolya.forecast.parameter.DaysUrlParameter;
import com.github.evgolya.forecast.parameter.ForecastUrlBuilder;
import com.github.evgolya.forecast.parameter.QueryUrlParameter;
import com.github.evgolya.vault.WeatherApiKeyProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
@EnableConfigurationProperties(WeatherApiKeyProvider.class)
public class ForecastApiClient {

    private static final Logger logger = LoggerFactory.getLogger(ForecastApiClient.class);
    private final HttpClient httpClient;
    private final String apiKeyUrlParameter;

    public ForecastApiClient(WeatherApiKeyProvider weatherApiKeyProvider) {
        this.apiKeyUrlParameter = weatherApiKeyProvider.getKey();
        this.httpClient = HttpClient.newHttpClient();
    }

    public String getCurrentWeatherByCoordinates(double latitude, double longitude) {
        final ForecastUrlBuilder forecastUrlBuilder = new ForecastUrlBuilder(WeatherApiConstants.CURRENT_WEATHER_METHOD, apiKeyUrlParameter);
        forecastUrlBuilder.addParameter(new QueryUrlParameter(latitude, longitude));
        return getData(forecastUrlBuilder.buildUrl());
    }

    public String getForecastByCoordinates(int days, double latitude, double longitude) {
        final ForecastUrlBuilder forecastUrlBuilder = new ForecastUrlBuilder(WeatherApiConstants.FORECAST_METHOD, apiKeyUrlParameter);
        forecastUrlBuilder.addParameter(new QueryUrlParameter(latitude, longitude));
        forecastUrlBuilder.addParameter(new DaysUrlParameter(days));
        return getData(forecastUrlBuilder.buildUrl());
    }

    public String getForecastByCoordinates(int days, String latitude, String longitude) {
        // TODO: implement
        return null;
    }

    public String getCurrentWeatherByCoordinates(String latitude, String longitude) {
        // TODO: implement
        return null;
    }

    public String getForecastForLocality(int days, String locality) {
        // TODO: implement
        return null;
    }

    public String getCurrentWeatherForLocality(String locality) {
        // TODO: implement
        return null;
    }

    public String getForecastForLocalityByIP(int days, String ip) {
        // TODO: implement
        return null;
    }

    public String getCurrentWeatherForLocalityByIP(String ip) {
        // TODO: implement
        return null;
    }

    public String getData(String url) {
        try {
            final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
            return httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (Exception e) {
            logger.error("Cannot send request to the Weather API");
            throw new WeatherApiRequestException("Cannot send request to the Weather API", e);
        }
    }

    private static final class WeatherApiRequestException extends RuntimeException {

        private WeatherApiRequestException(String message, Exception exception) {
            super(message, exception);
        }
    }
}
