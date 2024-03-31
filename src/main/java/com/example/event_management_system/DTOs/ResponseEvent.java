package com.example.event_management_system.DTOs;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ResponseEvent {

    private String eventId;
    private String eventName;
    private String cityName;
    private Date date;
    private String Weather;
    private String distance_km;
}
