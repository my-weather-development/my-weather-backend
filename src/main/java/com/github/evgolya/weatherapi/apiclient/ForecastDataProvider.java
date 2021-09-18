package com.github.evgolya.weatherapi.apiclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.evgolya.vault.WeatherApiKeyProvider;
import com.github.evgolya.weatherapi.ApiConstantsProvider;
import com.github.evgolya.weatherapi.apiclient.urlbuilder.DaysUrlParameter;
import com.github.evgolya.weatherapi.apiclient.urlbuilder.ForecastDataApiKeyUrlParameter;
import com.github.evgolya.weatherapi.apiclient.urlbuilder.QueryUrlParameter;
import com.github.evgolya.weatherapi.astronomy.AstronomyDto;
import com.github.evgolya.weatherapi.forecast.currentweatherdto.CurrentWeatherDto;
import com.github.evgolya.weatherapi.forecast.fullforecastdto.FullForecastDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.net.http.HttpResponse;

@Component
@EnableConfigurationProperties(WeatherApiKeyProvider.class)
public class ForecastDataProvider {

    private static final Logger logger = LoggerFactory.getLogger(ForecastDataProvider.class);
    private final String weatherApiKey;
    private final ObjectMapper objectMapper;
    private final HttpRequestSender httpRequestSender;

    public ForecastDataProvider(WeatherApiKeyProvider weatherApiKeyProvider, ObjectMapper objectMapper, HttpRequestSender httpRequestSender) {
        this.httpRequestSender = httpRequestSender;
        this.weatherApiKey = weatherApiKeyProvider.getKey();
        this.objectMapper = objectMapper;
    }

    public CurrentWeatherDto getCurrentWeatherByCoordinates(Double latitude, Double longitude) {
        final HttpResponse<String> response = httpRequestSender.send(
            ApiConstantsProvider.WEATHER_API_CONTEXT,
            ApiConstantsProvider.CURRENT_WEATHER_METHOD,
            new QueryUrlParameter(latitude, longitude),
            new ForecastDataApiKeyUrlParameter(weatherApiKey)
        );
        try {
            return objectMapper.readValue(response.body(), CurrentWeatherDto.class);
        } catch (JsonProcessingException e) {
            logger.error("JSON parsing exception for coordinates: lat {}, lon {}", latitude, longitude);
            throw new ForecastDataParsingException("Cannot process current weather data", e);
        }
    }

    public FullForecastDto getForecastByCoordinates(int days, Double latitude, Double longitude) {
        final HttpResponse<String> response = httpRequestSender.send(
            ApiConstantsProvider.WEATHER_API_CONTEXT,
            ApiConstantsProvider.FORECAST_METHOD,
            new QueryUrlParameter(latitude, longitude),
            new DaysUrlParameter(days),
            new ForecastDataApiKeyUrlParameter(weatherApiKey)
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
        // TODO: implement, locality = city/town/village etc.
        return null;
    }

    public String getCurrentWeatherForLocality(String locality) {
        // TODO: implement, locality = city/town/village etc.
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

    public AstronomyDto getAstronomyData(Double latitude, Double longitude) {
        final HttpResponse<String> response = httpRequestSender.send(
            ApiConstantsProvider.WEATHER_API_CONTEXT,
            ApiConstantsProvider.ASTRONOMY_METHOD,
            new QueryUrlParameter(latitude, longitude),
            new ForecastDataApiKeyUrlParameter(weatherApiKey)
        );
        try {
            return objectMapper.readValue(response.body(), AstronomyDto.class);
        } catch (JsonProcessingException e) {
            logger.error("JSON parsing exception for coordinates: lat {}, lon {}", latitude, longitude);
            throw new AstronomyDataParsingException("Cannot process astronomy data", e);
        }
    }

    private static final class ForecastDataParsingException extends RuntimeException {

        public ForecastDataParsingException(String message, JsonProcessingException exception) {
            super(message, exception);
        }
    }

    private static final class AstronomyDataParsingException extends RuntimeException {

        public AstronomyDataParsingException(String message, JsonProcessingException exception) {
            super(message, exception);
        }
    }
}