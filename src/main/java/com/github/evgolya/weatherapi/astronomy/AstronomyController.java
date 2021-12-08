package com.github.evgolya.weatherapi.astronomy;

import com.github.evgolya.weatherapi.LocalityCoordinates;
import com.github.evgolya.weatherapi.forecast.ForecastDataProvider;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AstronomyController {

    private final ForecastDataProvider forecastDataProvider;

    public AstronomyController(ForecastDataProvider forecastDataProvider) {
        this.forecastDataProvider = forecastDataProvider;
    }

    @PostMapping(path = "/astronomy", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<AstronomyDto> getAstronomyData(@RequestBody LocalityCoordinates localityCoordinates) {
        return ResponseEntity
            .ok()
            .body(forecastDataProvider.getAstronomyData(localityCoordinates.getLatitude(),localityCoordinates.getLongitude()));
    }
}
