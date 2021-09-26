package com.github.evgolya.geolocationapi.address;

import static java.util.Objects.nonNull;

public class SearchedLocality {

    private static final String SPACE_HTTP_ENTITY = "%20";
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

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        // TODO: Come up with better solution instead replace() method
        concat(country.replace(REPLACEABLE_TARGET, SPACE_HTTP_ENTITY), stringBuilder);
        concat(state.replace(REPLACEABLE_TARGET, SPACE_HTTP_ENTITY), stringBuilder);
        concat(locality.replace(REPLACEABLE_TARGET, SPACE_HTTP_ENTITY), stringBuilder);
        return stringBuilder.toString();
    }

    private void concat(String str, StringBuilder stringBuilder) {
        if (nonNull(str) && !str.isEmpty() && !str.isBlank()) {
            stringBuilder.append(str).append(",");
        }
    }
}
