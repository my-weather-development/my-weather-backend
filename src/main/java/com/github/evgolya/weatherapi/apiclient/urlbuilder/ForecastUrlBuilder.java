package com.github.evgolya.weatherapi.apiclient.urlbuilder;

import com.github.evgolya.weatherapi.WeatherApiConstants;

import java.util.ArrayList;
import java.util.List;

public class ForecastUrlBuilder {

    private final String apiMethod;
    private final String apiKeyUrlParameter;
    private final List<UrlParameter> urlParameters = new ArrayList<>();

    public ForecastUrlBuilder(String apiMethod, String apiKeyUrlParameter) {
        this.apiMethod = apiMethod;
        this.apiKeyUrlParameter = apiKeyUrlParameter;
    }

    public void addParameter(UrlParameter urlParameter) {
        urlParameters.add(urlParameter);
    }

    public String buildUrl() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(WeatherApiConstants.WEATHER_API_CONTEXT);
        stringBuilder.append(apiMethod);
        stringBuilder.append("?key=");
        stringBuilder.append(apiKeyUrlParameter);

        for (UrlParameter parameter : urlParameters) {
            stringBuilder.append(parameter.stringify());
        }

        return stringBuilder.toString();
    }
}
