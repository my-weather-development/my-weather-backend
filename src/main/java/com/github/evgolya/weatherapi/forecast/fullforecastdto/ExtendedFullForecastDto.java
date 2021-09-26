package com.github.evgolya.weatherapi.forecast.fullforecastdto;

import com.github.evgolya.geolocationapi.dto.GeocodeLocationItemDto;

public class ExtendedFullForecastDto {

    private final FullForecastDto fullForecastDto;
    private final GeocodeLocationItemDto geocodeLocationItemDto;

    public ExtendedFullForecastDto(FullForecastDto fullForecastDto, GeocodeLocationItemDto geocodeLocationItemDto) {
        this.fullForecastDto = fullForecastDto;
        this.geocodeLocationItemDto = geocodeLocationItemDto;
    }

    public FullForecastDto getFullForecastDto() {
        return fullForecastDto;
    }

    public GeocodeLocationItemDto getGeocodeLocationItemDto() {
        return geocodeLocationItemDto;
    }
}
