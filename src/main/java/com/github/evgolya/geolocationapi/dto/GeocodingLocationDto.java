package com.github.evgolya.geolocationapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodingLocationDto {

    private List<GeocodeLocationItemDto> items;

    public List<GeocodeLocationItemDto> getItems() {
        return items;
    }

    public void setItems(List<GeocodeLocationItemDto> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "GeocodeLocationDto{" +
            "items=" + items +
            '}';
    }
}
