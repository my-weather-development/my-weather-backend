package com.github.evgolya.util;

import java.text.DecimalFormat;

public final class CoordinatesConverter {

    private static final String NUMBERS_SELECTING_PATTERN = "[0-9.]+";
    private static final String NUMBERS_AFTER_DOT = "#0.000000";

    private CoordinatesConverter() {
        // hide public constructor
    }

    // sexagesimal numeral system, also known as base 60 or sexagenary
    public static Double fromBase60ToDecimalDegree(String coordinate) {
        // TODO: implement (use NUMBERS_SELECTING_PATTERN)
        return null;
    }

    public static Double coordinateToDecimalDegree(double degree, double min, double sec) {
        final double decimalDegrees = degree + min / 60 + sec / 3600;
        final DecimalFormat decimalFormat = new DecimalFormat(NUMBERS_AFTER_DOT);
        return Double.parseDouble(decimalFormat.format(decimalDegrees));
    }
}
