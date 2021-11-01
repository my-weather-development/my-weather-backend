package com.github.evgolya.autocomplete;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Settlement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String country;

    private String region;

    private String state;

    private String locality;

    private String localityAscii;

    private Double latitude;

    private Double longitude;

    private String countryCode;

    public Settlement() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getLocalityAscii() {
        return localityAscii;
    }

    public void setLocalityAscii(String localityAscii) {
        this.localityAscii = localityAscii;
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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Settlement that = (Settlement) o;
        return Objects.equals(id, that.id) &&
            Objects.equals(country, that.country) &&
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
        return Objects.hash(id, country, region, state, locality, localityAscii, latitude, longitude, countryCode);
    }
}
