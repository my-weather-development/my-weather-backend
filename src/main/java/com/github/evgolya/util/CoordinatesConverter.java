package com.github.evgolya.util;

import java.text.DecimalFormat;

public final class CoordinatesConverter {

    private static final String NUMBERS_AFTER_DOT = "#0.000000";

    private CoordinatesConverter() {
        // hide public constructor
    }

    public static double latitudeToDecDegree(double degree, double min, double sec) {
        return convert(degree, min, sec);
    }

    public static double longitudeToDecDegree(double degree, double min, double sec) {
        return convert(degree, min, sec);
    }

    private static double convert(double degree, double min, double sec) {
        final double decimalDegrees = degree + min / 60 + sec / 3600;
        final DecimalFormat decimalFormat = new DecimalFormat(NUMBERS_AFTER_DOT);
        return Double.parseDouble(decimalFormat.format(decimalDegrees));
    }
}
