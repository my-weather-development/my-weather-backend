package com.github.evgolya.weatherapi.fourhoursforecast;

import com.github.evgolya.weatherapi.forecast.fullforecastdto.ForecastDay;
import com.github.evgolya.weatherapi.forecast.fullforecastdto.FullForecastDto;
import com.github.evgolya.weatherapi.forecast.fullforecastdto.HourDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Objects.nonNull;

public class FourHoursForecastProvider {

    private static final String SELECT_HOURS_PATTERN = "\\d{2}:\\d{2}";

    public static FourHoursForecastDto get(FullForecastDto fullForecastDto) {
        final List<HourDto> result = new ArrayList<>();
        final Set<String> dayTimes = FourDayTimes.getDayTimes();

        for (ForecastDay forecastDay : fullForecastDto.getForecastDto().getForecastDays()) {
            for (HourDto hourDto : forecastDay.getHourDtos()) {
                final String time = getMatchedTime(hourDto);
                if (nonNull(time) && dayTimes.contains(time)) {
                    result.add(hourDto);
                }
            }
        }
        return new FourHoursForecastDto().setHours(result);
    }

    private static String getMatchedTime(HourDto hourDto) {
        final Matcher matcher = Pattern.compile(SELECT_HOURS_PATTERN)
            .matcher(hourDto.getTime());
        return matcher.find() ? matcher.group() : null;
    }

}
