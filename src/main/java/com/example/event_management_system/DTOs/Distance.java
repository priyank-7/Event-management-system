package com.example.event_management_system.DTOs;

import lombok.Getter;

@Getter
public class Distance {
    private String distance_km;

    public void setDistance_km(String distance_km) {
        this.distance_km = distance_km;
    }
}
