package com.github.evgolya.weatherapi.forecast.fullforecastdto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastDay {

    private String date;

    @JsonProperty("day")
    private DayDto dayDto;

    @JsonProperty("hour")
    private List<HourDto> hourDtos;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DayDto getDayDto() {
        return dayDto;
    }

    public void setDayDto(DayDto dayDto) {
        this.dayDto = dayDto;
    }

    public List<HourDto> getHourDtos() {
        return hourDtos;
    }

    public void setHourDtos(List<HourDto> hourDtos) {
        this.hourDtos = hourDtos;
    }

    @Override
    public String toString() {
        return "ForecastDay{" +
            "date='" + date + '\'' +
            ", dayDto=" + dayDto +
            ", hourDtos=" + hourDtos +
            '}';
    }
}
