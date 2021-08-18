package com.github.evgolya.weatherapi.astronomy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Astronomy {

    @JsonProperty("astro")
    public AstroData astroData;

    public AstroData getAstroData() {
        return astroData;
    }

    public void setAstroData(AstroData astroData) {
        this.astroData = astroData;
    }

    @Override
    public String toString() {
        return "Astronomy{" +
            "astroData=" + astroData +
            '}';
    }
}
