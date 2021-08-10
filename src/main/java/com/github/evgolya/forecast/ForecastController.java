package com.github.evgolya.forecast;

import com.github.evgolya.forecast.apiclient.ForecastApiClient;
import com.github.evgolya.forecast.dto.LocalityCoordinates;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/current-weather")
    public String getCurrentWeather(@RequestBody LocalityCoordinates localityCoordinates) {
        return forecastApiClient.getCurrentWeatherByCoordinates(localityCoordinates.getLatitude(), localityCoordinates.getLongitude());
    }

    @GetMapping("/forecast/{days}")
    public String getForecastForMultipleDays(@PathVariable Integer days, @RequestBody LocalityCoordinates localityCoordinates) {
        return forecastApiClient.getForecastByCoordinates(days, localityCoordinates.getLatitude(), localityCoordinates.getLongitude());
    }
}
