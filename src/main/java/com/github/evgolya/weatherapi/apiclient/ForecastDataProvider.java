package com.github.evgolya.weatherapi.apiclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.evgolya.geolocationapi.GeocodingAndSearchApiClient;
import com.github.evgolya.geolocationapi.address.SearchedLocality;
import com.github.evgolya.geolocationapi.dto.Coordinates;
import com.github.evgolya.geolocationapi.dto.GeocodeLocationItemDto;
import com.github.evgolya.geolocationapi.dto.GeocodingLocationDto;
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
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

@Component
@EnableConfigurationProperties(WeatherApiKeyProvider.class)
public class ForecastDataProvider {

    private static final Logger logger = LoggerFactory.getLogger(ForecastDataProvider.class);
    private final String weatherApiKey;
    private final ObjectMapper objectMapper;
    private final HttpRequestSender httpRequestSender;
    private final GeocodingAndSearchApiClient geocodingAndSearchApiClient;

    public ForecastDataProvider(
        WeatherApiKeyProvider weatherApiKeyProvider,
        ObjectMapper objectMapper,
        HttpRequestSender httpRequestSender,
        GeocodingAndSearchApiClient geocodingAndSearchApiClient
    ) {
        this.httpRequestSender = httpRequestSender;
        this.geocodingAndSearchApiClient = geocodingAndSearchApiClient;
        this.weatherApiKey = weatherApiKeyProvider.getKey();
        this.objectMapper = objectMapper;
    }

    public ExtendedCurrentWeatherDto getCurrentWeatherForLocality(SearchedLocality searchedLocality) {
        return applyGeocodingLocation(
            searchedLocality,
            () -> new ExtendedCurrentWeatherDto(new CurrentWeatherDto(), new GeocodeLocationItemDto()),
            (coordinates, geocodeLocationDto) -> {
                final CurrentWeatherDto currentWeatherDto = getCurrentWeatherByCoordinates(coordinates.getLatitude(), coordinates.getLongitude());
                return new ExtendedCurrentWeatherDto(currentWeatherDto, geocodeLocationDto);
            }
        );
    }

    public ExtendedFullForecastDto getForecastForLocality(Integer days, SearchedLocality searchedLocality) {
        return applyGeocodingLocation(
            searchedLocality,
            () -> new ExtendedFullForecastDto(new FullForecastDto(), new GeocodeLocationItemDto()),
            (coordinates, geocodeLocationDto) -> {
                final FullForecastDto fullForecastDto = getForecastByCoordinates(days, coordinates.getLatitude(), coordinates.getLongitude());
                return new ExtendedFullForecastDto(fullForecastDto, geocodeLocationDto);
            }
        );
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

    public FullForecastDto getForecastByCoordinates(Integer days, Double latitude, Double longitude) {
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

    public String getForecastForLocalityByIP(Integer days, String ip) {
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

    private <T> T applyGeocodingLocation(SearchedLocality searchedLocality, Supplier<T> emptyDto, BiFunction<Coordinates, GeocodeLocationItemDto, T> getForecastData) {
        final GeocodingLocationDto geocodingLocationDto = geocodingAndSearchApiClient.getCoordinatesByLocality(searchedLocality);
        final List<GeocodeLocationItemDto> items = geocodingLocationDto.getItems();
        if (items.isEmpty()) {
            return emptyDto.get();
        }
        // TODO: find & handle case when the list of items contains more than one item
        final GeocodeLocationItemDto geocodeLocationItemDto = items.get(0);
        final Coordinates coordinates = geocodeLocationItemDto.getCoordinates();

        return getForecastData.apply(coordinates, geocodeLocationItemDto);
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
