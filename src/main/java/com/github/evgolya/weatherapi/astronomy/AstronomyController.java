package com.github.evgolya.weatherapi.astronomy;

import com.github.evgolya.weatherapi.LocalityCoordinates;
import com.github.evgolya.weatherapi.apiclient.ForecastApiClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AstronomyController {

    private final ForecastApiClient forecastApiClient;

    public AstronomyController(ForecastApiClient forecastApiClient) {
        this.forecastApiClient = forecastApiClient;
    }

    @PostMapping(path = "/astronomy", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<AstronomyDto> getAstronomyData(@RequestBody LocalityCoordinates localityCoordinates) {
        return ResponseEntity
            .ok()
            .header("Access-Control-Allow-Origin", "*")
            .body(forecastApiClient.getAstronomyData(localityCoordinates.getLatitude(),localityCoordinates.getLongitude()));
    }
}
