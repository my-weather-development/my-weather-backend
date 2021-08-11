package com.github.evgolya.forecast.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DayDto {

    @JsonProperty("maxtemp_c")
    private Integer maxTemperatureInCelsius;

    @JsonProperty("maxtemp_f")
    private Integer maxTemperatureInFahrenheit;

    @JsonProperty("mintemp_c")
    private Integer minTemperatureInCelsius;

    @JsonProperty("mintemp_f")
    private Integer minTemperatureInFahrenheit;

    @JsonProperty("avgtemp_c")
    private Integer averageTemperatureInCelsius;

    @JsonProperty("avgtemp_f")
    private Integer averageTemperatureInFahrenheit;

    @JsonProperty("maxwind_mph")
    private Integer maxWindMPH;

    @JsonProperty("maxwind_kph")
    private Integer maxWindKPH;

    @JsonProperty("totalprecip_mm")
    private Integer totalPrecipitationsMM;

    @JsonProperty("totalprecip_in")
    private Integer totalPrecipitationsIN;

    @JsonProperty("avgvis_km")
    private Integer averageVisibilityKM;

    @JsonProperty("avgvis_miles")
    private Integer averageVisibilityMiles;

    @JsonProperty("avghumidity")
    private Integer averageHumidity;

    @JsonProperty("daily_will_it_rain")
    private Integer dailyWillItRain;

    @JsonProperty("daily_chance_of_rain")
    private String dailyChanceOfRain;

    @JsonProperty("daily_will_it_snow")
    private Integer dailyWillItSnow;

    @JsonProperty("daily_chance_of_snow")
    private String dailyChanceOfSnow;

    @JsonProperty("condition")
    private ConditionDto condition;

    @JsonProperty("uv")
    private Integer ultraviolet;

    public Integer getMaxTemperatureInCelsius() {
        return maxTemperatureInCelsius;
    }

    public void setMaxTemperatureInCelsius(Integer maxTemperatureInCelsius) {
        this.maxTemperatureInCelsius = maxTemperatureInCelsius;
    }

    public Integer getMaxTemperatureInFahrenheit() {
        return maxTemperatureInFahrenheit;
    }

    public void setMaxTemperatureInFahrenheit(Integer maxTemperatureInFahrenheit) {
        this.maxTemperatureInFahrenheit = maxTemperatureInFahrenheit;
    }

    public Integer getMinTemperatureInCelsius() {
        return minTemperatureInCelsius;
    }

    public void setMinTemperatureInCelsius(Integer minTemperatureInCelsius) {
        this.minTemperatureInCelsius = minTemperatureInCelsius;
    }

    public Integer getMinTemperatureInFahrenheit() {
        return minTemperatureInFahrenheit;
    }

    public void setMinTemperatureInFahrenheit(Integer minTemperatureInFahrenheit) {
        this.minTemperatureInFahrenheit = minTemperatureInFahrenheit;
    }

    public Integer getAverageTemperatureInCelsius() {
        return averageTemperatureInCelsius;
    }

    public void setAverageTemperatureInCelsius(Integer averageTemperatureInCelsius) {
        this.averageTemperatureInCelsius = averageTemperatureInCelsius;
    }

    public Integer getAverageTemperatureInFahrenheit() {
        return averageTemperatureInFahrenheit;
    }

    public void setAverageTemperatureInFahrenheit(Integer averageTemperatureInFahrenheit) {
        this.averageTemperatureInFahrenheit = averageTemperatureInFahrenheit;
    }

    public Integer getMaxWindMPH() {
        return maxWindMPH;
    }

    public void setMaxWindMPH(Integer maxWindMPH) {
        this.maxWindMPH = maxWindMPH;
    }

    public Integer getMaxWindKPH() {
        return maxWindKPH;
    }

    public void setMaxWindKPH(Integer maxWindKPH) {
        this.maxWindKPH = maxWindKPH;
    }

    public Integer getTotalPrecipitationsMM() {
        return totalPrecipitationsMM;
    }

    public void setTotalPrecipitationsMM(Integer totalPrecipitationsMM) {
        this.totalPrecipitationsMM = totalPrecipitationsMM;
    }

    public Integer getTotalPrecipitationsIN() {
        return totalPrecipitationsIN;
    }

    public void setTotalPrecipitationsIN(Integer totalPrecipitationsIN) {
        this.totalPrecipitationsIN = totalPrecipitationsIN;
    }

    public Integer getAverageVisibilityKM() {
        return averageVisibilityKM;
    }

    public void setAverageVisibilityKM(Integer averageVisibilityKM) {
        this.averageVisibilityKM = averageVisibilityKM;
    }

    public Integer getAverageVisibilityMiles() {
        return averageVisibilityMiles;
    }

    public void setAverageVisibilityMiles(Integer averageVisibilityMiles) {
        this.averageVisibilityMiles = averageVisibilityMiles;
    }

    public Integer getAverageHumidity() {
        return averageHumidity;
    }

    public void setAverageHumidity(Integer averageHumidity) {
        this.averageHumidity = averageHumidity;
    }

    public Integer getDailyWillItRain() {
        return dailyWillItRain;
    }

    public void setDailyWillItRain(Integer dailyWillItRain) {
        this.dailyWillItRain = dailyWillItRain;
    }

    public String getDailyChanceOfRain() {
        return dailyChanceOfRain;
    }

    public void setDailyChanceOfRain(String dailyChanceOfRain) {
        this.dailyChanceOfRain = dailyChanceOfRain;
    }

    public Integer getDailyWillItSnow() {
        return dailyWillItSnow;
    }

    public void setDailyWillItSnow(Integer dailyWillItSnow) {
        this.dailyWillItSnow = dailyWillItSnow;
    }

    public String getDailyChanceOfSnow() {
        return dailyChanceOfSnow;
    }

    public void setDailyChanceOfSnow(String dailyChanceOfSnow) {
        this.dailyChanceOfSnow = dailyChanceOfSnow;
    }

    public ConditionDto getCondition() {
        return condition;
    }

    public void setCondition(ConditionDto condition) {
        this.condition = condition;
    }

    public Integer getUltraviolet() {
        return ultraviolet;
    }

    public void setUltraviolet(Integer ultraviolet) {
        this.ultraviolet = ultraviolet;
    }

    @Override
    public String toString() {
        return "DayDto{" +
            "maxTemperatureInCelsius=" + maxTemperatureInCelsius +
            ", maxTemperatureInFahrenheit=" + maxTemperatureInFahrenheit +
            ", minTemperatureInCelsius=" + minTemperatureInCelsius +
            ", minTemperatureInFahrenheit=" + minTemperatureInFahrenheit +
            ", averageTemperatureInCelsius=" + averageTemperatureInCelsius +
            ", averageTemperatureInFahrenheit=" + averageTemperatureInFahrenheit +
            ", maxWindMPH=" + maxWindMPH +
            ", maxWindKPH=" + maxWindKPH +
            ", totalPrecipitationsMM=" + totalPrecipitationsMM +
            ", totalPrecipitationsIN=" + totalPrecipitationsIN +
            ", averageVisibilityKM=" + averageVisibilityKM +
            ", averageVisibilityMiles=" + averageVisibilityMiles +
            ", averageHumidity=" + averageHumidity +
            ", dailyWillItRain=" + dailyWillItRain +
            ", dailyChanceOfRain=" + dailyChanceOfRain +
            ", dailyWillItSnow=" + dailyWillItSnow +
            ", dailyChanceOfSnow=" + dailyChanceOfSnow +
            ", condition=" + condition +
            ", ultraviolet=" + ultraviolet +
            '}';
    }
}
