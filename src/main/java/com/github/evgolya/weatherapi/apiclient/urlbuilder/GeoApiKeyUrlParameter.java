package com.github.evgolya.weatherapi.apiclient.urlbuilder;

public class GeoApiKeyUrlParameter implements UrlParameter {

    private final String apiKey;

    public GeoApiKeyUrlParameter(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String stringify() {
        return String.format("apiKey=%s", apiKey);
    }
}
