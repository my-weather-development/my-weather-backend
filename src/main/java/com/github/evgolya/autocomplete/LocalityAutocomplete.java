package com.github.evgolya.autocomplete;

import java.util.Objects;

public class LocalityAutocomplete {

    private String country;
    private String region;
    private String state;
    private String locality;

    public String getCountry() {
        return country;
    }

    public LocalityAutocomplete setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public LocalityAutocomplete setRegion(String region) {
        this.region = region;
        return this;
    }

    public String getState() {
        return state;
    }

    public LocalityAutocomplete setState(String state) {
        this.state = state;
        return this;
    }

    public String getLocality() {
        return locality;
    }

    public LocalityAutocomplete setLocality(String locality) {
        this.locality = locality;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocalityAutocomplete that = (LocalityAutocomplete) o;
        return Objects.equals(country, that.country) &&
            Objects.equals(region, that.region) &&
            Objects.equals(state, that.state) &&
            Objects.equals(locality, that.locality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, region, state, locality);
    }
}
