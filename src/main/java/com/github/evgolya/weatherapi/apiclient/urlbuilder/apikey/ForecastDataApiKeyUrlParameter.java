package com.github.evgolya.weatherapi.apiclient.urlbuilder.apikey;

import com.github.evgolya.weatherapi.apiclient.urlbuilder.UrlParameter;

public class ForecastDataApiKeyUrlParameter implements UrlParameter {

    private final String apiKey;

    public ForecastDataApiKeyUrlParameter(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String stringify() {
        return String.format("key=%s", apiKey);
    }
}
