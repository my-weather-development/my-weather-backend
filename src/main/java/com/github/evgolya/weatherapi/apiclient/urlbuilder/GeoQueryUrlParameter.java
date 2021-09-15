package com.github.evgolya.weatherapi.apiclient.urlbuilder;

import com.github.evgolya.geolocationapi.address.SearchedLocality;

public class GeoQueryUrlParameter implements UrlParameter {

    private final SearchedLocality searchedLocality;
    private final String apiKeyUrlParameter;

    public GeoQueryUrlParameter(SearchedLocality searchedLocality, String apiKeyUrlParameter) {
        this.searchedLocality = searchedLocality;
        this.apiKeyUrlParameter = apiKeyUrlParameter;
    }

    @Override
    public String stringify() {
        return String.format("?apiKey=%s&q=%s", apiKeyUrlParameter, searchedLocality.toString());
    }
}
