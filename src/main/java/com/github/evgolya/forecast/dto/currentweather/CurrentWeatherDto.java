package com.github.evgolya.forecast.dto.currentweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.evgolya.forecast.dto.fullforecast.LocationDto;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeatherDto {

    @JsonProperty("location")
    private LocationDto locationDto;

    @JsonProperty("current")
    private CurrentForecast currentForecast;

    public LocationDto getLocationDto() {
        return locationDto;
    }

    public void setLocationDto(LocationDto locationDto) {
        this.locationDto = locationDto;
    }

    public CurrentForecast getCurrentForecast() {
        return currentForecast;
    }

    public void setCurrentForecast(CurrentForecast currentForecast) {
        this.currentForecast = currentForecast;
    }

    @Override
    public String toString() {
        return "CurrentWeatherDto{" +
            "locationDto=" + locationDto +
            ", currentForecast=" + currentForecast +
            '}';
    }
}
