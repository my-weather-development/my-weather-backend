package com.github.evgolya.forecast.dto.currentweather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.evgolya.forecast.dto.fullforecast.ConditionDto;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentForecast {

    @JsonProperty("last_updated")
    private String lastUpdated;

    @JsonProperty("temp_c")
    private Double temperatureInCelsius;

    @JsonProperty("temp_f")
    private Double temperatureInFahrenheit;

    @JsonProperty("is_day")
    private Integer isDay;

    private ConditionDto condition;

    @JsonProperty("wind_mph")
    private Double windMPH;

    @JsonProperty("wind_kph")
    private Double windKPH;

    @JsonProperty("wind_degree")
    private Double windDegree;

    @JsonProperty("wind_dir")
    private String windDirection;

    @JsonProperty("pressure_mb")
    private Double pressureMB;

    @JsonProperty("pressure_in")
    private Double pressureIN;

    @JsonProperty("precip_mm")
    private Double precipitationMM;

    @JsonProperty("precip_in")
    private Double precipitationIN;

    private Double humidity;

    private Double cloud;

    @JsonProperty("feelslike_c")
    private Double feelsLikeInCelsius;

    @JsonProperty("feelslike_f")
    private Double feelsLikeInFahrenheit;

    @JsonProperty("vis_km")
    private Double visibilityKM;

    @JsonProperty("vis_miles")
    private Double visibilityMiles;

    @JsonProperty("uv")
    private Double ultraviolet;

    @JsonProperty("gust_mph")
    private Double gustMPH;

    @JsonProperty("gust_kph")
    private Double gustKPH;

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLast_updated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Double getTemperatureInCelsius() {
        return temperatureInCelsius;
    }

    public void setTemperatureInCelsius(Double temperatureInCelsius) {
        this.temperatureInCelsius = temperatureInCelsius;
    }

    public Double getTemperatureInFahrenheit() {
        return temperatureInFahrenheit;
    }

    public void setTemperatureInFahrenheit(Double temperatureInFahrenheit) {
        this.temperatureInFahrenheit = temperatureInFahrenheit;
    }

    public Integer getIsDay() {
        return isDay;
    }

    public void setIsDay(Integer isDay) {
        this.isDay = isDay;
    }

    public ConditionDto getCondition() {
        return condition;
    }

    public void setCondition(ConditionDto condition) {
        this.condition = condition;
    }

    public Double getWindMPH() {
        return windMPH;
    }

    public void setWindMPH(Double windMPH) {
        this.windMPH = windMPH;
    }

    public Double getWindKPH() {
        return windKPH;
    }

    public void setWindKPH(Double windKPH) {
        this.windKPH = windKPH;
    }

    public Double getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(Double windDegree) {
        this.windDegree = windDegree;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public Double getPressureMB() {
        return pressureMB;
    }

    public void setPressureMB(Double pressureMB) {
        this.pressureMB = pressureMB;
    }

    public Double getPressureIN() {
        return pressureIN;
    }

    public void setPressureIN(Double pressureIN) {
        this.pressureIN = pressureIN;
    }

    public Double getPrecipitationMM() {
        return precipitationMM;
    }

    public void setPrecipitationMM(Double precipitationMM) {
        this.precipitationMM = precipitationMM;
    }

    public Double getPrecipitationIN() {
        return precipitationIN;
    }

    public void setPrecipitationIN(Double precipitationIN) {
        this.precipitationIN = precipitationIN;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getCloud() {
        return cloud;
    }

    public void setCloud(Double cloud) {
        this.cloud = cloud;
    }

    public Double getFeelsLikeInCelsius() {
        return feelsLikeInCelsius;
    }

    public void setFeelsLikeInCelsius(Double feelsLikeInCelsius) {
        this.feelsLikeInCelsius = feelsLikeInCelsius;
    }

    public Double getFeelsLikeInFahrenheit() {
        return feelsLikeInFahrenheit;
    }

    public void setFeelsLikeInFahrenheit(Double feelsLikeInFahrenheit) {
        this.feelsLikeInFahrenheit = feelsLikeInFahrenheit;
    }

    public Double getVisibilityKM() {
        return visibilityKM;
    }

    public void setVisibilityKM(Double visibilityKM) {
        this.visibilityKM = visibilityKM;
    }

    public Double getVisibilityMiles() {
        return visibilityMiles;
    }

    public void setVisibilityMiles(Double visibilityMiles) {
        this.visibilityMiles = visibilityMiles;
    }

    public Double getUltraviolet() {
        return ultraviolet;
    }

    public void setUltraviolet(Double ultraviolet) {
        this.ultraviolet = ultraviolet;
    }

    public Double getGustMPH() {
        return gustMPH;
    }

    public void setGustMPH(Double gustMPH) {
        this.gustMPH = gustMPH;
    }

    public Double getGustKPH() {
        return gustKPH;
    }

    public void setGustKPH(Double gustKPH) {
        this.gustKPH = gustKPH;
    }

    @Override
    public String toString() {
        return "CurrentForecast{" +
            "lastUpdated=" + lastUpdated +
            ", temperatureInCelsius=" + temperatureInCelsius +
            ", temperatureInFahrenheit=" + temperatureInFahrenheit +
            ", isDay=" + isDay +
            ", condition=" + condition +
            ", windMPH=" + windMPH +
            ", windKPH=" + windKPH +
            ", windDegree=" + windDegree +
            ", windDirection='" + windDirection + '\'' +
            ", pressureMB=" + pressureMB +
            ", pressureIN=" + pressureIN +
            ", precipitationMM=" + precipitationMM +
            ", precipitationIN=" + precipitationIN +
            ", humidity=" + humidity +
            ", cloud=" + cloud +
            ", feelsLikeInCelsius=" + feelsLikeInCelsius +
            ", feelsLikeInFahrenheit=" + feelsLikeInFahrenheit +
            ", visibilityKM=" + visibilityKM +
            ", visibilityMiles=" + visibilityMiles +
            ", ultraviolet=" + ultraviolet +
            ", gustMPH=" + gustMPH +
            ", gustKPH=" + gustKPH +
            '}';
    }
}
