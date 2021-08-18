package com.github.evgolya.weatherapi;

public final class WeatherApiConstants {

    public static final String WEATHER_API_CONTEXT = "http://api.weatherapi.com/v1";

    public static final String CURRENT_WEATHER_METHOD = "/current.json";
    public static final String FORECAST_METHOD = "/forecast.json";
    public static final String ASTRONOMY_METHOD = "/astronomy.json";

    private WeatherApiConstants() {
        // hide public constructor
    }
}
