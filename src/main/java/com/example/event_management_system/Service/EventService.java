package com.example.event_management_system.Service;

import com.example.event_management_system.DTOs.EventDTO;
import com.example.event_management_system.DTOs.RequestEvent;
import com.example.event_management_system.DTOs.ResponseEvent;
import org.springframework.data.domain.Page;

import java.util.Date;
import java.util.List;

public interface EventService {

    EventDTO createEvent(EventDTO eventDTO);
    Page<ResponseEvent> getEventsByDate(RequestEvent requestEvent, int pageNumber);

}
