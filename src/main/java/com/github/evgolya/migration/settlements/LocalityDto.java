package com.github.evgolya.migration.settlements;

import java.util.Objects;

public class LocalityDto {

    private String country;
    private Boolean isState;
    private String administrativeTerritorialUnit;
    private String locality;
    private String localityAscii;
    private Double latitude;
    private Double longitude;
    private String countryCode;

    // TODO: think about this variant
//    Map<Country, Map<Domain, List<Settlement>>> map;

    public static LocalityDto newBuilder() {
        return new LocalityDto();
    }

    public String getAdministrativeTerritorialUnit() {
        return administrativeTerritorialUnit;
    }

    public LocalityDto setAdministrativeTerritorialUnit(String administrativeTerritorialUnit) {
        this.administrativeTerritorialUnit = administrativeTerritorialUnit;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public LocalityDto setCountry(String country) {
        this.country = country;
        return this;
    }

    public Boolean getIsState() {
        return isState;
    }

    public LocalityDto setIsState(Boolean isState) {
        this.isState = isState;
        return this;
    }

    public String getLocality() {
        return locality;
    }

    public LocalityDto setLocality(String locality) {
        this.locality = locality;
        return this;
    }

    public String getLocalityAscii() {
        return localityAscii;
    }

    public LocalityDto setLocalityAscii(String localityAscii) {
        this.localityAscii = localityAscii;
        return this;
    }

    public Double getLatitude() {
        return latitude;
    }

    public LocalityDto setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }

    public LocalityDto setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public LocalityDto setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocalityDto that = (LocalityDto) o;
        return Objects.equals(country, that.country) &&
            Objects.equals(isState, that.isState) &&
            Objects.equals(administrativeTerritorialUnit, that.administrativeTerritorialUnit) &&
            Objects.equals(locality, that.locality) &&
            Objects.equals(localityAscii, that.localityAscii) &&
            Objects.equals(latitude, that.latitude) &&
            Objects.equals(longitude, that.longitude) &&
            Objects.equals(countryCode, that.countryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, isState, administrativeTerritorialUnit, locality, localityAscii, latitude, longitude, countryCode);
    }
}
