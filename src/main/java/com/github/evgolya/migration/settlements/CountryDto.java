package com.github.evgolya.migration.settlements;

import java.util.Objects;

public class CountryDto {

    private String title;

    private String countryCode;

    public String getTitle() {
        return title;
    }

    public CountryDto setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public CountryDto setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryDto that = (CountryDto) o;
        return Objects.equals(title, that.title) &&
            Objects.equals(countryCode, that.countryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, countryCode);
    }
}
