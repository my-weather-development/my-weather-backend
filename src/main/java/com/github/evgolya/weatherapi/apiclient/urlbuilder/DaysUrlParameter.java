package com.github.evgolya.weatherapi.apiclient.urlbuilder;

public class DaysUrlParameter implements UrlParameter {

    private final Integer days;
    private final String apiKeyUrlParameter;

    public DaysUrlParameter(Integer days, String apiKeyUrlParameter) {
        this.days = days;
        this.apiKeyUrlParameter = apiKeyUrlParameter;
    }

    @Override
    public String stringify() {
        return String.format("?key=%s&days=%d", apiKeyUrlParameter, days);
    }
}
