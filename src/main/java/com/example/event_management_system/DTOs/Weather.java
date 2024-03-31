package com.example.event_management_system.DTOs;

import lombok.Getter;

@Getter
public class Weather {

    private String weather;

    public void setWeather(String weather) {
        this.weather = weather;
    }
}
