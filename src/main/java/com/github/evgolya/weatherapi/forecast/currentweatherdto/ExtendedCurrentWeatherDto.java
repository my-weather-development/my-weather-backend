package com.github.evgolya.weatherapi.forecast.currentweatherdto;

import com.github.evgolya.geolocationapi.dto.GeocodeLocationItemDto;

public class ExtendedCurrentWeatherDto {

    private final CurrentWeatherDto currentWeatherDto;
    private final GeocodeLocationItemDto geocodeLocationItemDto;

    public ExtendedCurrentWeatherDto(CurrentWeatherDto currentWeatherDto, GeocodeLocationItemDto geocodeLocationItemDto) {
        this.currentWeatherDto = currentWeatherDto;
        this.geocodeLocationItemDto = geocodeLocationItemDto;
    }

    public CurrentWeatherDto getCurrentWeatherDto() {
        return currentWeatherDto;
    }

    public GeocodeLocationItemDto getGeocodeLocationItemDto() {
        return geocodeLocationItemDto;
    }
}
