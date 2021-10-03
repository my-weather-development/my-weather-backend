package com.github.evgolya.weatherapi.forecast.fullforecastdto;

import com.github.evgolya.geolocationapi.dto.GeocodeLocationItemDto;
import com.github.evgolya.weatherapi.fourhoursforecast.FourHoursForecastDto;

public class ExtendedFullForecastDto {

    private final FullForecastDto fullForecastDto;
    private final FourHoursForecastDto fourHoursForecastDto;
    private final GeocodeLocationItemDto geocodeLocationItemDto;

    public ExtendedFullForecastDto(FullForecastDto fullForecastDto, FourHoursForecastDto fourHoursForecastDto, GeocodeLocationItemDto geocodeLocationItemDto) {
        this.fullForecastDto = fullForecastDto;
        this.fourHoursForecastDto = fourHoursForecastDto;
        this.geocodeLocationItemDto = geocodeLocationItemDto;
    }

    public FullForecastDto getFullForecastDto() {
        return fullForecastDto;
    }

    public GeocodeLocationItemDto getGeocodeLocationItemDto() {
        return geocodeLocationItemDto;
    }

    public FourHoursForecastDto getFourHoursForecastDto() {
        return fourHoursForecastDto;
    }
}
