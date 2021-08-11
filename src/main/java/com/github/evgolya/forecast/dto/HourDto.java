package com.github.evgolya.forecast.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HourDto {

    private String time;

    @JsonProperty("temp_c")
    private Integer temperatureInCelsius;

    @JsonProperty("temp_f")
    private Integer temperatureInFahrenheit;

    @JsonProperty("is_day")
    private Integer isDay;

    private ConditionDto condition;

    @JsonProperty("wind_mph")
    private Integer windMPH;

    @JsonProperty("wind_kph")
    private Integer windKPH;

    @JsonProperty("wind_degree")
    private Integer windDegree;

    @JsonProperty("wind_dir")
    private String windDirection;

    @JsonProperty("pressure_mb")
    private Integer pressureMB;

    @JsonProperty("pressure_in")
    private Integer pressureIN;

    @JsonProperty("precip_mm")
    private Integer precipitationsMM;

    @JsonProperty("precip_in")
    private Integer precipitationsIN;

    @JsonProperty("humidity")
    private Integer humidity;

    @JsonProperty("cloud")
    private Integer cloud;

    @JsonProperty("feelslike_c")
    private Integer feelsLikeInCelsius;

    @JsonProperty("feelslike_f")
    private Integer feelsLikeInFahrenheit;

    @JsonProperty("windchill_c")
    private Integer windchillInCelsius;

    @JsonProperty("windchill_f")
    private Integer windchillInFahrenheit;

    @JsonProperty("heatindex_c")
    private Integer heatIndexInCelsius;

    @JsonProperty("heatindex_f")
    private Integer heatIndexInFahrenheit;

    @JsonProperty("dewpoint_c")
    private Integer dewPointInCelsius;

    @JsonProperty("dewpoint_f")
    private Integer dewPointInFahrenheit;

    @JsonProperty("will_it_rain")
    private Integer willItRain;

    @JsonProperty("chance_of_rain")
    private String chanceOfRain;

    @JsonProperty("will_it_snow")
    private Integer willItSnow;

    @JsonProperty("chance_of_snow")
    private String chanceOfSnow;

    @JsonProperty("vis_km")
    private Integer visibilityKM;

    @JsonProperty("vis_miles")
    private Integer visibilityMiles;

    @JsonProperty("gust_mph")
    private Integer gustMPH;

    @JsonProperty("gust_kph")
    private Integer gustKPH;

    @JsonProperty("uv")
    private Integer ultraviolet;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getTemperatureInCelsius() {
        return temperatureInCelsius;
    }

    public void setTemperatureInCelsius(Integer temperatureInCelsius) {
        this.temperatureInCelsius = temperatureInCelsius;
    }

    public Integer getTemperatureInFahrenheit() {
        return temperatureInFahrenheit;
    }

    public void setTemperatureInFahrenheit(Integer temperatureInFahrenheit) {
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

    public Integer getWindMPH() {
        return windMPH;
    }

    public void setWindMPH(Integer windMPH) {
        this.windMPH = windMPH;
    }

    public Integer getWindKPH() {
        return windKPH;
    }

    public void setWindKPH(Integer windKPH) {
        this.windKPH = windKPH;
    }

    public Integer getWindDegree() {
        return windDegree;
    }

    public void setWindDegree(Integer windDegree) {
        this.windDegree = windDegree;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public Integer getPressureMB() {
        return pressureMB;
    }

    public void setPressureMB(Integer pressureMB) {
        this.pressureMB = pressureMB;
    }

    public Integer getPressureIN() {
        return pressureIN;
    }

    public void setPressureIN(Integer pressureIN) {
        this.pressureIN = pressureIN;
    }

    public Integer getPrecipitationsMM() {
        return precipitationsMM;
    }

    public void setPrecipitationsMM(Integer precipitationsMM) {
        this.precipitationsMM = precipitationsMM;
    }

    public Integer getPrecipitationsIN() {
        return precipitationsIN;
    }

    public void setPrecipitationsIN(Integer precipitationsIN) {
        this.precipitationsIN = precipitationsIN;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getCloud() {
        return cloud;
    }

    public void setCloud(Integer cloud) {
        this.cloud = cloud;
    }

    public Integer getFeelsLikeInCelsius() {
        return feelsLikeInCelsius;
    }

    public void setFeelsLikeInCelsius(Integer feelsLikeInCelsius) {
        this.feelsLikeInCelsius = feelsLikeInCelsius;
    }

    public Integer getFeelsLikeInFahrenheit() {
        return feelsLikeInFahrenheit;
    }

    public void setFeelsLikeInFahrenheit(Integer feelsLikeInFahrenheit) {
        this.feelsLikeInFahrenheit = feelsLikeInFahrenheit;
    }

    public Integer getWindchillInCelsius() {
        return windchillInCelsius;
    }

    public void setWindchillInCelsius(Integer windchillInCelsius) {
        this.windchillInCelsius = windchillInCelsius;
    }

    public Integer getWindchillInFahrenheit() {
        return windchillInFahrenheit;
    }

    public void setWindchillInFahrenheit(Integer windchillInFahrenheit) {
        this.windchillInFahrenheit = windchillInFahrenheit;
    }

    public Integer getHeatIndexInCelsius() {
        return heatIndexInCelsius;
    }

    public void setHeatIndexInCelsius(Integer heatIndexInCelsius) {
        this.heatIndexInCelsius = heatIndexInCelsius;
    }

    public Integer getHeatIndexInFahrenheit() {
        return heatIndexInFahrenheit;
    }

    public void setHeatIndexInFahrenheit(Integer heatIndexInFahrenheit) {
        this.heatIndexInFahrenheit = heatIndexInFahrenheit;
    }

    public Integer getDewPointInCelsius() {
        return dewPointInCelsius;
    }

    public void setDewPointInCelsius(Integer dewPointInCelsius) {
        this.dewPointInCelsius = dewPointInCelsius;
    }

    public Integer getDewPointInFahrenheit() {
        return dewPointInFahrenheit;
    }

    public void setDewPointInFahrenheit(Integer dewPointInFahrenheit) {
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

    public Integer getVisibilityKM() {
        return visibilityKM;
    }

    public void setVisibilityKM(Integer visibilityKM) {
        this.visibilityKM = visibilityKM;
    }

    public Integer getVisibilityMiles() {
        return visibilityMiles;
    }

    public void setVisibilityMiles(Integer visibilityMiles) {
        this.visibilityMiles = visibilityMiles;
    }

    public Integer getGustMPH() {
        return gustMPH;
    }

    public void setGustMPH(Integer gustMPH) {
        this.gustMPH = gustMPH;
    }

    public Integer getGustKPH() {
        return gustKPH;
    }

    public void setGustKPH(Integer gustKPH) {
        this.gustKPH = gustKPH;
    }

    public Integer getUltraviolet() {
        return ultraviolet;
    }

    public void setUltraviolet(Integer ultraviolet) {
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
