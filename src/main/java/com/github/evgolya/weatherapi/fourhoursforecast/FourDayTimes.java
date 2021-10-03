package com.github.evgolya.weatherapi.fourhoursforecast;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum FourDayTimes {

    MORNING("06:00"),
    AFTERNOON("12:00"),
    EVENING("18:00"),
    NIGHT("00:00"),
    ;

    private final String time;

    private static final Set<String> dayTimes = initializeHoursSet();

    FourDayTimes(String time) {
        this.time = time;
    }

    public static Set<String> getDayTimes() {
        return dayTimes;
    }

    private static Set<String> initializeHoursSet() {
        return Arrays.stream(FourDayTimes.values())
            .map(v -> v.time)
            .collect(Collectors.toSet());
    }
}
