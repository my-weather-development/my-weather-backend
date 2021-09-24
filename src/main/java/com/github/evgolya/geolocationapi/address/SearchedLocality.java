package com.github.evgolya.geolocationapi.address;

import static java.util.Objects.nonNull;

public class SearchedLocality {

    private String country;
    private String state;
    private String locality;
    private String street;
    private Integer buildingNumber;
    private String district;
    private Integer apartment;
    private Integer postalCode;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(Integer buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getApartment() {
        return apartment;
    }

    public void setApartment(Integer apartment) {
        this.apartment = apartment;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        concat(country, stringBuilder);
        concat(state, stringBuilder);
        concat(locality, stringBuilder);
        concat(street, stringBuilder);
        concat(district, stringBuilder);
        addressNumberChecking(buildingNumber, stringBuilder);
        addressNumberChecking(apartment, stringBuilder);
        addressNumberChecking(postalCode, stringBuilder);
        return stringBuilder.toString();
    }

    private void addressNumberChecking(Integer number, StringBuilder stringBuilder) {
        if (nonNull(number) && number > 0) {
            concat(String.valueOf(number), stringBuilder);
        }
    }

    private void concat(String str, StringBuilder stringBuilder) {
        if (nonNull(str) && !str.isEmpty() && !str.isBlank()) {
            stringBuilder.append(str).append(",");
        }
    }
}
