package com.github.evgolya;

public final class ApiConstantsProvider {

    public static final String IP_STACK_API_CONTEXT = "http://api.ipstack.com"; // HTTPS available for Premium account
    public static final String WEATHER_API_CONTEXT = "http://api.weatherapi.com/v1"; // TODO: Is HTTPS available for this API?
    public static final String GEOCODE_API_CONTEXT = "https://geocode.search.hereapi.com/v1";

    public static final String CURRENT_WEATHER_METHOD = "/current.json";
    public static final String FORECAST_METHOD = "/forecast.json";
    public static final String ASTRONOMY_METHOD = "/astronomy.json";
    public static final String GEOCODE_METHOD = "/geocode";

    public static final String ROOT_PATH = "/";

    private ApiConstantsProvider() {
        // hide public constructor
    }
}
