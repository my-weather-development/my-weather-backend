package com.github.evgolya.forecast.dto.fullforecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HourDto {

    private String time;

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
    private Double precipitationsMM;

    @JsonProperty("precip_in")
    private Double precipitationsIN;

    @JsonProperty("humidity")
    private Double humidity;

    @JsonProperty("cloud")
    private Double cloud;

    @JsonProperty("feelslike_c")
    private Double feelsLikeInCelsius;

    @JsonProperty("feelslike_f")
    private Double feelsLikeInFahrenheit;

    @JsonProperty("windchill_c")
    private Double windchillInCelsius;

    @JsonProperty("windchill_f")
    private Double windchillInFahrenheit;

    @JsonProperty("heatindex_c")
    private Double heatIndexInCelsius;

    @JsonProperty("heatindex_f")
    private Double heatIndexInFahrenheit;

    @JsonProperty("dewpoint_c")
    private Double dewPointInCelsius;

    @JsonProperty("dewpoint_f")
    private Double dewPointInFahrenheit;

    @JsonProperty("will_it_rain")
    private Integer willItRain;

    @JsonProperty("chance_of_rain")
    private String chanceOfRain;

    @JsonProperty("will_it_snow")
    private Integer willItSnow;

    @JsonProperty("chance_of_snow")
    private String chanceOfSnow;

    @JsonProperty("vis_km")
    private Double visibilityKM;

    @JsonProperty("vis_miles")
    private Double visibilityMiles;

    @JsonProperty("gust_mph")
    private Double gustMPH;

    @JsonProperty("gust_kph")
    private Double gustKPH;

    @JsonProperty("uv")
    private Double ultraviolet;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public Double getPrecipitationsMM() {
        return precipitationsMM;
    }

    public void setPrecipitationsMM(Double precipitationsMM) {
        this.precipitationsMM = precipitationsMM;
    }

    public Double getPrecipitationsIN() {
        return precipitationsIN;
    }

    public void setPrecipitationsIN(Double precipitationsIN) {
        this.precipitationsIN = precipitationsIN;
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

    public Double getWindchillInCelsius() {
        return windchillInCelsius;
    }

    public void setWindchillInCelsius(Double windchillInCelsius) {
        this.windchillInCelsius = windchillInCelsius;
    }

    public Double getWindchillInFahrenheit() {
        return windchillInFahrenheit;
    }

    public void setWindchillInFahrenheit(Double windchillInFahrenheit) {
        this.windchillInFahrenheit = windchillInFahrenheit;
    }

    public Double getHeatIndexInCelsius() {
        return heatIndexInCelsius;
    }

    public void setHeatIndexInCelsius(Double heatIndexInCelsius) {
        this.heatIndexInCelsius = heatIndexInCelsius;
    }

    public Double getHeatIndexInFahrenheit() {
        return heatIndexInFahrenheit;
    }

    public void setHeatIndexInFahrenheit(Double heatIndexInFahrenheit) {
        this.heatIndexInFahrenheit = heatIndexInFahrenheit;
    }

    public Double getDewPointInCelsius() {
        return dewPointInCelsius;
    }

    public void setDewPointInCelsius(Double dewPointInCelsius) {
        this.dewPointInCelsius = dewPointInCelsius;
    }

    public Double getDewPointInFahrenheit() {
        return dewPointInFahrenheit;
    }

    public void setDewPointInFahrenheit(Double dewPointInFahrenheit) {
        this.dewPointInFahrenheit = dewPointInFahrenheit;
    }

    public Integer getWillItRain() {
        return willItRain;
    }

    public void setWillItRain(Integer willItRain) {
        this.willItRain = willItRain;
    }

    public String getChanceOfRain() {
        return chanceOfRain;
    }

    public void setChanceOfRain(String chanceOfRain) {
        this.chanceOfRain = chanceOfRain;
    }

    public Integer getWillItSnow() {
        return willItSnow;
    }

    public void setWillItSnow(Integer willItSnow) {
        this.willItSnow = willItSnow;
    }

    public String getChanceOfSnow() {
        return chanceOfSnow;
    }

    public void setChanceOfSnow(String chanceOfSnow) {
        this.chanceOfSnow = chanceOfSnow;
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

    public Double getUltraviolet() {
        return ultraviolet;
    }

    public void setUltraviolet(Double ultraviolet) {
        this.ultraviolet = ultraviolet;
    }

    @Override
    public String toString() {
        return "HourDto{" +
            "time='" + time + '\'' +
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
            ", precipitationsMM=" + precipitationsMM +
            ", precipitationsIN=" + precipitationsIN +
            ", humidity=" + humidity +
            ", cloud=" + cloud +
            ", feelsLikeInCelsius=" + feelsLikeInCelsius +
            ", feelsLikeInFahrenheit=" + feelsLikeInFahrenheit +
            ", windchillInCelsius=" + windchillInCelsius +
            ", windchillInFahrenheit=" + windchillInFahrenheit +
            ", heatIndexInCelsius=" + heatIndexInCelsius +
            ", heatIndexInFahrenheit=" + heatIndexInFahrenheit +
            ", dewPointInCelsius=" + dewPointInCelsius +
            ", dewPointInFahrenheit=" + dewPointInFahrenheit +
            ", willItRain=" + willItRain +
            ", chanceOfRain='" + chanceOfRain + '\'' +
            ", willItSnow=" + willItSnow +
            ", chanceOfSnow='" + chanceOfSnow + '\'' +
            ", visibilityKM=" + visibilityKM +
            ", visibilityMiles=" + visibilityMiles +
            ", gustMPH=" + gustMPH +
            ", gustKPH=" + gustKPH +
            ", ultraviolet=" + ultraviolet +
            '}';
    }
}
