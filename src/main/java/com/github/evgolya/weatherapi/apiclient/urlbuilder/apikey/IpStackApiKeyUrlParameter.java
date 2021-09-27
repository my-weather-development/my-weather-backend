package com.github.evgolya.weatherapi.apiclient.urlbuilder.apikey;

import com.github.evgolya.weatherapi.apiclient.urlbuilder.UrlParameter;

public class IpStackApiKeyUrlParameter implements UrlParameter {

    private final String apiKey;

    public IpStackApiKeyUrlParameter(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String stringify() {
        return String.format("access_key=%s", apiKey);
    }
}
