package com.github.evgolya.weatherapi.apiclient.urlbuilder;

import com.github.evgolya.geolocationapi.locality.SearchedLocality;

public class GeoQueryUrlParameter implements UrlParameter {

    private final SearchedLocality searchedLocality;

    public GeoQueryUrlParameter(SearchedLocality searchedLocality) {
        this.searchedLocality = searchedLocality;
    }

    @Override
    public String stringify() {
        return String.format("q=%s", searchedLocality.toString());
    }
}
