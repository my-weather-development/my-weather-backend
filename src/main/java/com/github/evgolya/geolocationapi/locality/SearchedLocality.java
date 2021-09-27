package com.github.evgolya.geolocationapi.locality;

import static java.util.Objects.nonNull;

public class SearchedLocality {

    private static final String URL_ENCODED_SPACE = "%20";
    private static final String REPLACEABLE_TARGET = " ";

    private String country;
    private String state;
    private String locality;

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

    public boolean isEmpty() {
        return nonNull(country) && country.isEmpty() ||
            nonNull(state) && state.isEmpty() ||
            nonNull(locality) && locality.isEmpty();
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        convertSpaceToUTF8Format(country, stringBuilder);
        convertSpaceToUTF8Format(state, stringBuilder);
        convertSpaceToUTF8Format(locality, stringBuilder);
        return stringBuilder.toString();
    }

    private void convertSpaceToUTF8Format(String str, StringBuilder stringBuilder) {
        if (nonNull(str)) {
            // TODO: Come up with better solution instead replace() method
            concat(str.replace(REPLACEABLE_TARGET, URL_ENCODED_SPACE), stringBuilder);
        }
    }

    private void concat(String str, StringBuilder stringBuilder) {
        if (!str.isEmpty() && !str.isBlank()) {
            stringBuilder.append(str).append(",");
        }
    }
}
