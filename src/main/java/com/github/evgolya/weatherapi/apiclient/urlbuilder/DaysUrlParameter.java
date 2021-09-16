package com.github.evgolya.weatherapi.apiclient.urlbuilder;

public class DaysUrlParameter implements UrlParameter {

    private final Integer days;

    public DaysUrlParameter(Integer days) {
        this.days = days;
    }

    @Override
    public String stringify() {
        return String.format("days=%d", days);
    }
}
