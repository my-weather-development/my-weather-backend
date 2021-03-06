package com.github.evgolya.weatherapi.astronomy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationDto {

    private String name;

    private String region;

    private String country;

    @JsonProperty("lat")
    private Double latitude;

    @JsonProperty("lon")
    private Double longitude;

    @JsonProperty("tz_id")
    private String timezone;

    private String localtime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getLocaltime() {
        return localtime;
    }

    public void setLocaltime(String localtime) {
        this.localtime = localtime;
    }

    @Override
    public String toString() {
        return "LocationDto{" +
            "name='" + name + '\'' +
            ", region='" + region + '\'' +
            ", country='" + country + '\'' +
            ", latitude=" + latitude +
            ", longitude=" + longitude +
            ", timezone='" + timezone + '\'' +
            ", localtime='" + localtime + '\'' +
            '}';
    }
}
