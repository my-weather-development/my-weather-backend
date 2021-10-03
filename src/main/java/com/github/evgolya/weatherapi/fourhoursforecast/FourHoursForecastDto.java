package com.github.evgolya.weatherapi.fourhoursforecast;

import com.github.evgolya.weatherapi.forecast.fullforecastdto.HourDto;

import java.util.List;

public class FourHoursForecastDto {

    private List<HourDto> hours;

    public List<HourDto> getHours() {
        return hours;
    }

    public FourHoursForecastDto setHours(List<HourDto> hours) {
        this.hours = hours;
        return this;
    }
}
