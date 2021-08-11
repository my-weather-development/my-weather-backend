package com.github.evgolya.forecast.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ConditionDto {

    private String text;

    private String icon;

    private Integer code;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ConditionDto{" +
            "text='" + text + '\'' +
            ", icon='" + icon + '\'' +
            ", code=" + code +
            '}';
    }
}
