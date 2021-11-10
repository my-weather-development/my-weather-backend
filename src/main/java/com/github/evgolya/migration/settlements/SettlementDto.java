package com.github.evgolya.migration.settlements;

import java.util.Objects;

public class SettlementDto {

    private String locality;

    private String ascii;

    private Double latitude;

    private Double longitude;

    public String getLocality() {
        return locality;
    }

    public SettlementDto setLocality(String locality) {
        this.locality = locality;
        return this;
    }

    public String getAscii() {
        return ascii;
    }

    public SettlementDto setAscii(String ascii) {
        this.ascii = ascii;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SettlementDto that = (SettlementDto) o;
        return Objects.equals(locality, that.locality) &&
            Objects.equals(ascii, that.ascii) &&
            Objects.equals(latitude, that.latitude) &&
            Objects.equals(longitude, that.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locality, ascii, latitude, longitude);
    }
}
