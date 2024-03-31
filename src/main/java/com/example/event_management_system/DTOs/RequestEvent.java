package com.example.event_management_system.DTOs;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class RequestEvent {

    @NotNull(message = "latitude is required")
    private String latitude;
    @NotNull(message = "longitude is required")
    private String longitude;
    @NotNull(message = "date is required")
    private Date date;
}