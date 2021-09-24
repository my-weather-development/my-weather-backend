package com.github.evgolya.weatherapi.apiclient.urlbuilder;

public class GeoLangUrlParameter implements UrlParameter {

    private final String language;

    public GeoLangUrlParameter(String language) {
        this.language = language;
    }

    @Override
    public String stringify() {
        return String.format("lang=%s", language);
    }
}
