package com.github.evgolya.weatherapi.apiclient.urlbuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UrlBuilder {

    private final String apiContext;
    private final String apiMethod;
    private final List<UrlParameter> urlParameters = new ArrayList<>();

    public UrlBuilder(String apiContext, String apiMethod) {
        this.apiContext = apiContext;
        this.apiMethod = apiMethod;
    }

    public void addParameter(UrlParameter urlParameter) {
        urlParameters.add(urlParameter);
    }

    public String buildUrl() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(apiContext)
            .append(apiMethod)
            .append("?");

        final String joinedUrlParameters = urlParameters.stream()
            .map(UrlParameter::stringify)
            .collect(Collectors.joining("&"));

        stringBuilder.append(joinedUrlParameters);
        return stringBuilder.toString();
    }
}
