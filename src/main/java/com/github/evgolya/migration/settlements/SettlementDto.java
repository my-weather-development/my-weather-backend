package com.github.evgolya.migration.settlements;

import java.util.Objects;

public class SettlementDto {

    private String country;
    private String region;
    private String state;
    private String locality;
    private String localityAscii;
    private Double latitude;
    private Double longitude;
    private String countryCode;

    public String getCountry() {
        return country;
    }

    public SettlementDto setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public SettlementDto setRegion(String region) {
        this.region = region;
        return this;
    }

    public String getState() {
        return state;
    }

    public SettlementDto setState(String state) {
        this.state = state;
        return this;
    }

    public String getLocality() {
        return locality;
    }

    public SettlementDto setLocality(String locality) {
        this.locality = locality;
        return this;
    }

    public String getLocalityAscii() {
        return localityAscii;
    }

    public SettlementDto setLocalityAscii(String localityAscii) {
        this.localityAscii = localityAscii;
        return this;
    }

    public Double getLatitude() {
        return latitude;
    }

    public SettlementDto setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }

    public SettlementDto setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public SettlementDto setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SettlementDto that = (SettlementDto) o;
        return Objects.equals(country, that.country) &&
            Objects.equals(region, that.region) &&
            Objects.equals(state, that.state) &&
            Objects.equals(locality, that.locality) &&
            Objects.equals(localityAscii, that.localityAscii) &&
            Objects.equals(latitude, that.latitude) &&
            Objects.equals(longitude, that.longitude) &&
            Objects.equals(countryCode, that.countryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, region, state, locality, localityAscii, latitude, longitude, countryCode);
    }
}
