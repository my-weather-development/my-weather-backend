package com.github.evgolya.forecast.dto.fullforecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FullForecastDto {

    @JsonProperty("location")
    private LocationDto locationDto;

    @JsonProperty("forecast")
    private ForecastDto forecastDto;

    public LocationDto getLocationDto() {
        return locationDto;
    }

    public void setLocationDto(LocationDto locationDto) {
        this.locationDto = locationDto;
    }

    public ForecastDto getForecastDto() {
        return forecastDto;
    }

    public void setForecastDto(ForecastDto forecastDto) {
        this.forecastDto = forecastDto;
    }

    @Override
    public String toString() {
        return "FullForecastDto{" +
            "locationDto=" + locationDto +
            ", forecastDto=" + forecastDto +
            '}';
    }
}
