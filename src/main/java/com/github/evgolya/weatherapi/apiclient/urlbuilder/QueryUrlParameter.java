package com.github.evgolya.weatherapi.apiclient.urlbuilder;

public class QueryUrlParameter implements UrlParameter {

    private final Double latitude;
    private final Double longitude;

    public QueryUrlParameter(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String stringify() {
        return String.format("q=%f,%f", latitude, longitude);
    }
}
