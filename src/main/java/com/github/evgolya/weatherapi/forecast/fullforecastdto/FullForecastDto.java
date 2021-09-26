package com.github.evgolya.weatherapi.forecast.fullforecastdto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FullForecastDto {

    @JsonProperty("forecast")
    private ForecastDto forecastDto;

    public ForecastDto getForecastDto() {
        return forecastDto;
    }

    public void setForecastDto(ForecastDto forecastDto) {
        this.forecastDto = forecastDto;
    }

    @Override
    public String toString() {
        return "FullForecastDto{" +
            "forecastDto=" + forecastDto +
            '}';
    }
}
