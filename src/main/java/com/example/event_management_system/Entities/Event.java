package com.example.event_management_system.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    private String event_id;
    private String event_name;
    private String city_name;
    private Date date;
    private String time;
    private String latitude;
    private String longitude;
}
