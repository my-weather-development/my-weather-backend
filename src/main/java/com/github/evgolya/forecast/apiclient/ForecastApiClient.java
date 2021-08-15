package com.github.evgolya.forecast.apiclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.evgolya.forecast.WeatherApiConstants;
import com.github.evgolya.forecast.dto.currentweather.CurrentWeatherDto;
import com.github.evgolya.forecast.dto.fullforecast.FullForecastDto;
import com.github.evgolya.forecast.parameter.DaysUrlParameter;
import com.github.evgolya.forecast.parameter.ForecastUrlBuilder;
import com.github.evgolya.forecast.parameter.QueryUrlParameter;
import com.github.evgolya.forecast.parameter.UrlParameter;
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
    private final ObjectMapper objectMapper;

    public ForecastApiClient(WeatherApiKeyProvider weatherApiKeyProvider) {
        this.httpClient = HttpClient.newHttpClient();
        this.apiKeyUrlParameter = weatherApiKeyProvider.getKey();
        this.objectMapper = new ObjectMapper();
    }

    public CurrentWeatherDto getCurrentWeatherByCoordinates(double latitude, double longitude) {
        final HttpResponse<String> response = getData(WeatherApiConstants.CURRENT_WEATHER_METHOD, new QueryUrlParameter(latitude, longitude));
        try {
            return objectMapper.readValue(response.body(), CurrentWeatherDto.class);
        } catch (JsonProcessingException e) {
            logger.error("JSON parsing exception for coordinates: lat {}, lon {}", latitude, longitude);
            throw new ForecastDataParsingException("Cannot process current weather data", e);
        }
    }

    public FullForecastDto getForecastByCoordinates(int days, double latitude, double longitude) {
        final HttpResponse<String> response = getData(
            WeatherApiConstants.FORECAST_METHOD,
            new QueryUrlParameter(latitude, longitude), new DaysUrlParameter(days)
        );
        try {
            return objectMapper.readValue(response.body(), FullForecastDto.class);
        } catch (JsonProcessingException e) {
            logger.error("JSON parsing exception for coordinates: lat {}, lon {}", latitude, longitude);
            throw new ForecastDataParsingException("Cannot process forecast data", e);
        }
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

    private HttpResponse<String> getData(String apiMethod, UrlParameter ... parameters) {
        final ForecastUrlBuilder forecastUrlBuilder = new ForecastUrlBuilder(apiMethod, apiKeyUrlParameter);
        for (UrlParameter parameter : parameters) {
            forecastUrlBuilder.addParameter(parameter);
        }
        return sendHttpRequest(forecastUrlBuilder.buildUrl());
    }

    public HttpResponse<String> sendHttpRequest(String url) {
        try {
            final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .GET()
                .build();
            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());
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

    private static final class ForecastDataParsingException extends RuntimeException {

        public ForecastDataParsingException(String message, JsonProcessingException exception) {
            super(message, exception);
        }
    }
}
