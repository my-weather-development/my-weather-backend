package com.github.evgolya.weatherapi.forecast;

import com.github.evgolya.geolocationapi.address.SearchedLocality;
import com.github.evgolya.weatherapi.LocalityCoordinates;
import com.github.evgolya.weatherapi.apiclient.ExtendedCurrentWeatherDto;
import com.github.evgolya.weatherapi.apiclient.ExtendedFullForecastDto;
import com.github.evgolya.weatherapi.apiclient.ForecastDataProvider;
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

// TODO: set header to a response instead duplicating (https://www.baeldung.com/spring-response-header#3-adding-a-header-for-all-responses)
@RestController
public class ForecastController {

    private final ForecastDataProvider forecastDataProvider;

    public ForecastController(ForecastDataProvider forecastDataProvider) {
        this.forecastDataProvider = forecastDataProvider;
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
            .body(forecastDataProvider.getCurrentWeatherByCoordinates(localityCoordinates.getLatitude(), localityCoordinates.getLongitude()));
    }

    @PostMapping(path = "/forecast/{days}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<FullForecastDto> getForecastForMultipleDays(@PathVariable Integer days, @RequestBody LocalityCoordinates localityCoordinates) {
        return ResponseEntity
            .ok()
            .header("Access-Control-Allow-Origin", "*")
            .body(forecastDataProvider.getForecastByCoordinates(days, localityCoordinates.getLatitude(), localityCoordinates.getLongitude()));
    }

    @PostMapping(path = "/current-weather/locality", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ExtendedCurrentWeatherDto> getCurrentWeatherForLocality(@RequestBody SearchedLocality searchedLocality) {
        return ResponseEntity
            .ok()
            .header("Access-Control-Allow-Origin", "*")
            .body(forecastDataProvider.getCurrentWeatherForLocality(searchedLocality));
    }

    @PostMapping(path = "/forecast/locality/{days}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ExtendedFullForecastDto> getForecastForLocality(@PathVariable Integer days, @RequestBody SearchedLocality searchedLocality) {
        return ResponseEntity
            .ok()
            .header("Access-Control-Allow-Origin", "*")
            .body(forecastDataProvider.getForecastForLocality(days, searchedLocality));
    }
}
