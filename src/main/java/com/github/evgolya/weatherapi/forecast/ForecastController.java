package com.github.evgolya.weatherapi.forecast;

import com.github.evgolya.weatherapi.LocalityCoordinates;
import com.github.evgolya.weatherapi.apiclient.ForecastApiClient;
import com.github.evgolya.weatherapi.forecast.currentweatherdto.CurrentWeatherDto;
import com.github.evgolya.weatherapi.forecast.fullforecastdto.FullForecastDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForecastController {

    private final ForecastApiClient forecastApiClient;

    public ForecastController(ForecastApiClient forecastApiClient) {
        this.forecastApiClient = forecastApiClient;
    }

    @GetMapping("/")
    public String healthCheck() {
        return "Server is available";
    }

    @PostMapping(path = "/current-weather", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<CurrentWeatherDto> getCurrentWeather(@RequestBody LocalityCoordinates localityCoordinates) {
        return ResponseEntity
            .ok()
            .header("Access-Control-Allow-Origin", "*")
            .body(forecastApiClient.getCurrentWeatherByCoordinates(localityCoordinates.getLatitude(), localityCoordinates.getLongitude()));
    }

    @PostMapping(path = "/forecast/{days}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<FullForecastDto> getForecastForMultipleDays(@PathVariable Integer days, @RequestBody LocalityCoordinates localityCoordinates) {
        return ResponseEntity
            .ok()
            .header("Access-Control-Allow-Origin", "*")
            .body(forecastApiClient.getForecastByCoordinates(days, localityCoordinates.getLatitude(), localityCoordinates.getLongitude()));
    }
}