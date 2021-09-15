package com.github.evgolya.weatherapi.apiclient.urlbuilder;

import com.github.evgolya.weatherapi.ApiConstantsProvider;

import java.util.ArrayList;
import java.util.List;

public class UrlBuilder {

    private final String apiMethod;
    private final List<UrlParameter> urlParameters = new ArrayList<>();

    public UrlBuilder(String apiMethod) {
        this.apiMethod = apiMethod;
    }

    public void addParameter(UrlParameter urlParameter) {
        urlParameters.add(urlParameter);
    }

    public String buildUrl() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ApiConstantsProvider.WEATHER_API_CONTEXT);
        stringBuilder.append(apiMethod);

        for (UrlParameter parameter : urlParameters) {
            stringBuilder.append(parameter.stringify());
        }

        return stringBuilder.toString();
    }
}
