package com.github.evgolya.geolocationapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.evgolya.geolocationapi.address.SearchedLocality;
import com.github.evgolya.geolocationapi.dto.GeocodingLocationDto;
import com.github.evgolya.vault.GeocodingAndSearchApiKeyProvider;
import com.github.evgolya.weatherapi.ApiConstantsProvider;
import com.github.evgolya.weatherapi.apiclient.HttpRequestSender;
import com.github.evgolya.weatherapi.apiclient.urlbuilder.GeoApiKeyUrlParameter;
import com.github.evgolya.weatherapi.apiclient.urlbuilder.GeoQueryUrlParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.http.HttpResponse;

@Component
public class GeocodingAndSearchApiClient {

    private static final Logger logger = LoggerFactory.getLogger(GeocodingAndSearchApiClient.class);
    private final HttpRequestSender httpRequestSender;
    private final String geoCodingApiKey;
    private final ObjectMapper objectMapper;

    public GeocodingAndSearchApiClient(
        HttpRequestSender httpRequestSender,
        ObjectMapper objectMapper,
        GeocodingAndSearchApiKeyProvider geocodingAndSearchApiKeyProvider
    ) {
        this.httpRequestSender = httpRequestSender;
        this.objectMapper = objectMapper;
        this.geoCodingApiKey = geocodingAndSearchApiKeyProvider.getKey();
    }

    public GeocodingLocationDto getCoordinatesByLocality(SearchedLocality searchedLocality) {
        final HttpResponse<String> response = httpRequestSender.send(
            ApiConstantsProvider.GEOCODE_API_CONTEXT,
            ApiConstantsProvider.GEOCODE_METHOD,
            new GeoQueryUrlParameter(searchedLocality),
            new GeoApiKeyUrlParameter(geoCodingApiKey)
        );
        try {
            return objectMapper.readValue(response.body(), GeocodingLocationDto.class);
        } catch (JsonProcessingException e) {
            logger.error("JSON parsing exception for locality: {}, {}", searchedLocality.getCountry(), searchedLocality.getLocality());
            throw new LocalityParsingException("Cannot process locality data", e);
        }
    }

    public GeocodingLocationDto getCoordinatesByLocality(SearchedLocality searchedLocality, String ip) {
        // TODO: implement
        return null;
    }

    private static final class LocalityParsingException extends RuntimeException {

        public LocalityParsingException(String message, Exception exception) {
            super(message, exception);
        }
    }
}
