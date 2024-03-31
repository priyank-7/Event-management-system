package com.example.event_management_system.DTOs;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Setter
@Getter
@Builder
public class EventDTO {

    private String event_id;
    @NotNull(message = "Event name is required")
    private String event_name;
    @NotNull(message = "City name is required")
    private String city_name;
    @NotNull(message = "Date is required")
    @FutureOrPresent(message = "Date should be in the future")
    private Date date;
    @NotNull(message = "Time is required")
    private String time;
    @NotNull(message = "Latitude is required")
    private String latitude;
    @NotNull(message = "Longitude is required")
    private String longitude;
    private String distance;
    private String weather;
}
