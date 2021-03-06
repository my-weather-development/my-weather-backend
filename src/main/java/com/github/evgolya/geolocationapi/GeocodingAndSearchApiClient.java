package com.github.evgolya.geolocationapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.evgolya.ApiConstantsProvider;
import com.github.evgolya.geolocationapi.dto.GeocodingLocationDto;
import com.github.evgolya.geolocationapi.locality.SearchedLocality;
import com.github.evgolya.vault.GeocodingAndSearchApiKeyProvider;
import com.github.evgolya.weatherapi.apiclient.HttpRequestSender;
import com.github.evgolya.weatherapi.apiclient.urlbuilder.GeoLangUrlParameter;
import com.github.evgolya.weatherapi.apiclient.urlbuilder.GeoQueryUrlParameter;
import com.github.evgolya.weatherapi.apiclient.urlbuilder.apikey.GeoApiKeyUrlParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.net.http.HttpResponse;

@Component
public class GeocodingAndSearchApiClient {

    private static final String EN_LANG = "en";
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
        this.geoCodingApiKey = System.getenv().getOrDefault("GEOCODING_API_KEY", geocodingAndSearchApiKeyProvider.getKey());
    }

    public GeocodingLocationDto getCoordinatesByLocality(SearchedLocality searchedLocality) {
        final HttpResponse<String> response = httpRequestSender.send(
            ApiConstantsProvider.GEOCODE_API_CONTEXT,
            ApiConstantsProvider.GEOCODE_METHOD,
            new GeoQueryUrlParameter(searchedLocality),
            new GeoApiKeyUrlParameter(geoCodingApiKey),
            new GeoLangUrlParameter(EN_LANG) // TODO: make dynamically
        );
        try {
            return objectMapper.readValue(response.body(), GeocodingLocationDto.class);
        } catch (JsonProcessingException e) {
            logger.error("JSON parsing exception for locality: {}, {}", searchedLocality.getCountry(), searchedLocality.getLocality());
            throw new LocalityParsingException("Cannot process locality data", e);
        }
    }

    private static final class LocalityParsingException extends RuntimeException {

        public LocalityParsingException(String message, Exception exception) {
            super(message, exception);
        }
    }
}
