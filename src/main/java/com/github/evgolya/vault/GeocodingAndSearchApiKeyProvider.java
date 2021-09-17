package com.github.evgolya.vault;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("geocoding-and-search-api")
@Component
public class GeocodingAndSearchApiKeyProvider {

    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
