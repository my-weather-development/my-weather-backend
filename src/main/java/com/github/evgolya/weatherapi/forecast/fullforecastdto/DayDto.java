package com.github.evgolya.weatherapi.forecast.fullforecastdto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DayDto {

    @JsonProperty("maxtemp_c")
    private Double maxTemperatureInCelsius;

    @JsonProperty("maxtemp_f")
    private Double maxTemperatureInFahrenheit;

    @JsonProperty("mintemp_c")
    private Double minTemperatureInCelsius;

    @JsonProperty("mintemp_f")
    private Double minTemperatureInFahrenheit;

    @JsonProperty("avgtemp_c")
    private Double averageTemperatureInCelsius;

    @JsonProperty("avgtemp_f")
    private Double averageTemperatureInFahrenheit;

    @JsonProperty("maxwind_mph")
    private Double maxWindMPH;

    @JsonProperty("maxwind_kph")
    private Double maxWindKPH;

    @JsonProperty("totalprecip_mm")
    private Double totalPrecipitationsMM;

    @JsonProperty("totalprecip_in")
    private Double totalPrecipitationsIN;

    @JsonProperty("avgvis_km")
    private Double averageVisibilityKM;

    @JsonProperty("avgvis_miles")
    private Double averageVisibilityMiles;

    @JsonProperty("avghumidity")
    private Double averageHumidity;

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
    private Double ultraviolet;

    public Double getMaxTemperatureInCelsius() {
        return maxTemperatureInCelsius;
    }

    public void setMaxTemperatureInCelsius(Double maxTemperatureInCelsius) {
        this.maxTemperatureInCelsius = maxTemperatureInCelsius;
    }

    public Double getMaxTemperatureInFahrenheit() {
        return maxTemperatureInFahrenheit;
    }

    public void setMaxTemperatureInFahrenheit(Double maxTemperatureInFahrenheit) {
        this.maxTemperatureInFahrenheit = maxTemperatureInFahrenheit;
    }

    public Double getMinTemperatureInCelsius() {
        return minTemperatureInCelsius;
    }

    public void setMinTemperatureInCelsius(Double minTemperatureInCelsius) {
        this.minTemperatureInCelsius = minTemperatureInCelsius;
    }

    public Double getMinTemperatureInFahrenheit() {
        return minTemperatureInFahrenheit;
    }

    public void setMinTemperatureInFahrenheit(Double minTemperatureInFahrenheit) {
        this.minTemperatureInFahrenheit = minTemperatureInFahrenheit;
    }

    public Double getAverageTemperatureInCelsius() {
        return averageTemperatureInCelsius;
    }

    public void setAverageTemperatureInCelsius(Double averageTemperatureInCelsius) {
        this.averageTemperatureInCelsius = averageTemperatureInCelsius;
    }

    public Double getAverageTemperatureInFahrenheit() {
        return averageTemperatureInFahrenheit;
    }

    public void setAverageTemperatureInFahrenheit(Double averageTemperatureInFahrenheit) {
        this.averageTemperatureInFahrenheit = averageTemperatureInFahrenheit;
    }

    public Double getMaxWindMPH() {
        return maxWindMPH;
    }

    public void setMaxWindMPH(Double maxWindMPH) {
        this.maxWindMPH = maxWindMPH;
    }

    public Double getMaxWindKPH() {
        return maxWindKPH;
    }

    public void setMaxWindKPH(Double maxWindKPH) {
        this.maxWindKPH = maxWindKPH;
    }

    public Double getTotalPrecipitationsMM() {
        return totalPrecipitationsMM;
    }

    public void setTotalPrecipitationsMM(Double totalPrecipitationsMM) {
        this.totalPrecipitationsMM = totalPrecipitationsMM;
    }

    public Double getTotalPrecipitationsIN() {
        return totalPrecipitationsIN;
    }

    public void setTotalPrecipitationsIN(Double totalPrecipitationsIN) {
        this.totalPrecipitationsIN = totalPrecipitationsIN;
    }

    public Double getAverageVisibilityKM() {
        return averageVisibilityKM;
    }

    public void setAverageVisibilityKM(Double averageVisibilityKM) {
        this.averageVisibilityKM = averageVisibilityKM;
    }

    public Double getAverageVisibilityMiles() {
        return averageVisibilityMiles;
    }

    public void setAverageVisibilityMiles(Double averageVisibilityMiles) {
        this.averageVisibilityMiles = averageVisibilityMiles;
    }

    public Double getAverageHumidity() {
        return averageHumidity;
    }

    public void setAverageHumidity(Double averageHumidity) {
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

    public Double getUltraviolet() {
        return ultraviolet;
    }

    public void setUltraviolet(Double ultraviolet) {
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
