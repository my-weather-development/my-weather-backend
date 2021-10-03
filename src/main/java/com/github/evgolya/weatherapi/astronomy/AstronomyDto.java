package com.github.evgolya.weatherapi.astronomy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AstronomyDto {

    @JsonProperty("location")
    private LocationDto locationDto;

    private Astronomy astronomy;

    public LocationDto getLocationDto() {
        return locationDto;
    }

    public void setLocationDto(LocationDto locationDto) {
        this.locationDto = locationDto;
    }

    public Astronomy getAstronomy() {
        return astronomy;
    }

    public void setAstronomy(Astronomy astronomy) {
        this.astronomy = astronomy;
    }

    @Override
    public String toString() {
        return "AstronomyDto{" +
            "locationDto=" + locationDto +
            ", astronomy=" + astronomy +
            '}';
    }
}
