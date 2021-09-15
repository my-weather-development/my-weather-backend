package com.github.evgolya.weatherapi.apiclient.urlbuilder;

public class QueryUrlParameter implements UrlParameter {

    private final Double latitude;
    private final Double longitude;
    private final String apiKeyUrlParameter;

    public QueryUrlParameter(Double latitude, Double longitude, String apiKeyUrlParameter) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.apiKeyUrlParameter = apiKeyUrlParameter;
    }

    @Override
    public String stringify() {
        return String.format("?key=%s&q=%f,%f", apiKeyUrlParameter, latitude, longitude);
    }
}
