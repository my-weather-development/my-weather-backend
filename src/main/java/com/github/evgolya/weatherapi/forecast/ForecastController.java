package com.github.evgolya.weatherapi.forecast;

import com.github.evgolya.geolocationapi.LocalityByIpProvider;
import com.github.evgolya.geolocationapi.locality.SearchedLocality;
import com.github.evgolya.weatherapi.forecast.currentweatherdto.ExtendedCurrentWeatherDto;
import com.github.evgolya.weatherapi.forecast.fullforecastdto.ExtendedFullForecastDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import static java.util.Objects.isNull;

// TODO: set header to a response instead duplicating (https://www.baeldung.com/spring-response-header#3-adding-a-header-for-all-responses)
@RestController
public class ForecastController {

    private final ForecastDataProvider forecastDataProvider;
    private final LocalityByIpProvider localityByIpProvider;

    public ForecastController(ForecastDataProvider forecastDataProvider, LocalityByIpProvider localityByIpProvider) {
        this.forecastDataProvider = forecastDataProvider;
        this.localityByIpProvider = localityByIpProvider;
    }

    @GetMapping("/health-check")
    public String healthCheck() {
        return "Server is available";
    }

    @PostMapping(path = "/current-weather", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ExtendedCurrentWeatherDto> getCurrentWeatherForLocality(
        @RequestBody(required = false) SearchedLocality searchedLocalityCommand,
        HttpServletRequest httpServletRequest
    ) {
        final SearchedLocality searchedLocality = getSearchedLocalityByIp(searchedLocalityCommand, httpServletRequest.getRemoteAddr());
        return ResponseEntity
            .ok()
            .header("Access-Control-Allow-Origin", "*")
            .body(forecastDataProvider.getCurrentWeatherForLocality(searchedLocality));
    }

    @PostMapping(path = "/forecast/{days}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ExtendedFullForecastDto> getForecastForLocality(
        @PathVariable Integer days,
        @RequestBody(required = false) SearchedLocality searchedLocalityCommand,
        HttpServletRequest httpServletRequest
    ) {
        final SearchedLocality searchedLocality = getSearchedLocalityByIp(searchedLocalityCommand, httpServletRequest.getRemoteAddr());
        return ResponseEntity
            .ok()
            .header("Access-Control-Allow-Origin", "*")
            .body(forecastDataProvider.getForecastForLocality(days, searchedLocality));
    }

    private SearchedLocality getSearchedLocalityByIp(SearchedLocality searchedLocality, String ip) {
        return isNull(searchedLocality) || searchedLocality.isEmpty()
            ? localityByIpProvider.getLocality(ip)
            : searchedLocality;
    }
}
