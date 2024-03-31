package com.example.event_management_system.Helper;

import com.example.event_management_system.DTOs.EventDTO;
import com.example.event_management_system.DTOs.ResponseEvent;
import com.example.event_management_system.Entities.Event;

public class EventMapper {

    public static Event EventDTOToEvent(EventDTO eventDto){
        return Event.builder()
                .event_id(eventDto.getEvent_id())
                .event_name(eventDto.getEvent_name())
                .city_name(eventDto.getCity_name())
                .date(eventDto.getDate())
                .time(eventDto.getTime())
                .latitude(eventDto.getLatitude())
                .longitude(eventDto.getLongitude())
                .build();
    }

    public static EventDTO EventToEventDTO(Event event){
        return EventDTO.builder()
                .event_id(event.getEvent_id())
                .event_name(event.getEvent_name())
                .city_name(event.getCity_name())
                .date(event.getDate())
                .time(event.getTime())
                .latitude(event.getLatitude())
                .longitude(event.getLongitude())
                .build();
    }

    public static ResponseEvent EventToResponseEvent(Event event){
        return ResponseEvent.builder()
                .eventId(event.getEvent_id())
                .eventName(event.getEvent_name())
                .cityName(event.getCity_name())
                .date(event.getDate())
                .build();
    }

    public static ResponseEvent EventDTOToResponseEvent(EventDTO eventDTO){
        return ResponseEvent.builder()
                .eventId(eventDTO.getEvent_id())
                .eventName(eventDTO.getEvent_name())
                .cityName(eventDTO.getCity_name())
                .date(eventDTO.getDate())
                .Weather(eventDTO.getWeather())
                .distance_km(eventDTO.getDistance_km())
                .build();
    }
}
