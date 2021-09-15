package com.github.evgolya.geolocationapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MapView {

    private Double west;

    private Double south;

    private Double east;

    private Double north;

    public Double getWest() {
        return west;
    }

    public void setWest(Double west) {
        this.west = west;
    }

    public Double getSouth() {
        return south;
    }

    public void setSouth(Double south) {
        this.south = south;
    }

    public Double getEast() {
        return east;
    }

    public void setEast(Double east) {
        this.east = east;
    }

    public Double getNorth() {
        return north;
    }

    public void setNorth(Double north) {
        this.north = north;
    }

    @Override
    public String toString() {
        return "MapView{" +
            "west=" + west +
            ", south=" + south +
            ", east=" + east +
            ", north=" + north +
            '}';
    }
}
