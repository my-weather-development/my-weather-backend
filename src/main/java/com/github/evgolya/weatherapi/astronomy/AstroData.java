package com.github.evgolya.weatherapi.astronomy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AstroData {

    private String sunrise;

    private String sunset;

    private String moonrise;

    private String moonset;

    @JsonProperty("moon_phase")
    private String moonPhase;

    @JsonProperty("moon_illumination")
    private Integer moonIllumination;

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getMoonrise() {
        return moonrise;
    }

    public void setMoonrise(String moonrise) {
        this.moonrise = moonrise;
    }

    public String getMoonset() {
        return moonset;
    }

    public void setMoonset(String moonset) {
        this.moonset = moonset;
    }

    public String getMoonPhase() {
        return moonPhase;
    }

    public void setMoonPhase(String moonPhase) {
        this.moonPhase = moonPhase;
    }

    public Integer getMoonIllumination() {
        return moonIllumination;
    }

    public void setMoonIllumination(Integer moonIllumination) {
        this.moonIllumination = moonIllumination;
    }

    @Override
    public String toString() {
        return "AstroData{" +
            "sunrise='" + sunrise + '\'' +
            ", sunset='" + sunset + '\'' +
            ", moonrise='" + moonrise + '\'' +
            ", moonset='" + moonset + '\'' +
            ", moonPhase='" + moonPhase + '\'' +
            ", moonIllumination=" + moonIllumination +
            '}';
    }
}
