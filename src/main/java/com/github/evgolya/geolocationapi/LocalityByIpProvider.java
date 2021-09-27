package com.github.evgolya.geolocationapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.evgolya.ApiConstantsProvider;
import com.github.evgolya.exception.APIResponseParsingException;
import com.github.evgolya.geolocationapi.dto.LocationDataByIpDto;
import com.github.evgolya.geolocationapi.locality.SearchedLocality;
import com.github.evgolya.vault.IpStackApiKeyProvider;
import com.github.evgolya.weatherapi.apiclient.HttpRequestSender;
import com.github.evgolya.weatherapi.apiclient.urlbuilder.apikey.IpStackApiKeyUrlParameter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.http.HttpResponse;

@Component
public class LocalityByIpProvider {

    private final String publicIpMock;
    private final String geolocationApiKey;
    private final ObjectMapper objectMapper;
    private final HttpRequestSender httpRequestSender;

    public LocalityByIpProvider(
        @Value("${public.ip.mock}") String publicIpMock,
        ObjectMapper objectMapper,
        HttpRequestSender httpRequestSender,
        IpStackApiKeyProvider ipStackApiKeyProvider
    ) {
        this.publicIpMock = publicIpMock;
        this.objectMapper = objectMapper;
        this.httpRequestSender = httpRequestSender;
        this.geolocationApiKey = System.getenv().getOrDefault("IP_STACK_API_KEY", ipStackApiKeyProvider.getKey());
    }

    public SearchedLocality getLocality(String ip) {
        final HttpResponse<String> httpResponse = httpRequestSender.send(
            ApiConstantsProvider.IP_STACK_API_CONTEXT,
            ApiConstantsProvider.ROOT_PATH + publicIpMock,
            new IpStackApiKeyUrlParameter(geolocationApiKey)
        );

        try {
            final LocationDataByIpDto locationDataByIpDto = objectMapper.readValue(httpResponse.body(), LocationDataByIpDto.class);
            final SearchedLocality searchedLocality = new SearchedLocality();
            searchedLocality.setLocality(locationDataByIpDto.getCity());
            searchedLocality.setCountry(locationDataByIpDto.getCountryName());
            searchedLocality.setState(locationDataByIpDto.getRegionName());
            return searchedLocality;
        } catch (JsonProcessingException e) {
            throw new APIResponseParsingException("Cannot process received data by ip", e);
        }
    }
}
