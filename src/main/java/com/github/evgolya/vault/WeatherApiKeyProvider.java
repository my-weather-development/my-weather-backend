package com.github.evgolya.vault;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("weather-api")
@Component
public class WeatherApiKeyProvider { // TODO: add key provider for Geocoding & Search API

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
