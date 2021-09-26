package com.github.evgolya.weatherapi.forecast.currentweatherdto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeatherDto {

    @JsonProperty("current")
    private CurrentForecast currentForecast;

    public CurrentForecast getCurrentForecast() {
        return currentForecast;
    }

    public void setCurrentForecast(CurrentForecast currentForecast) {
        this.currentForecast = currentForecast;
    }

    @Override
    public String toString() {
        return "CurrentWeatherDto{" +
            "currentForecast=" + currentForecast +
            '}';
    }
}
