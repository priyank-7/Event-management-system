package com.example.event_management_system.Controller;

import com.example.event_management_system.DTOs.EventDTO;
import com.example.event_management_system.DTOs.RequestEvent;
import com.example.event_management_system.Service.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createEvent(@Valid @RequestBody EventDTO eventDTO) {
        return ResponseEntity.ok(this.eventService.createEvent(eventDTO));
    }

    @GetMapping("/find/{pageNumber}")
    public ResponseEntity<?> getEventsByDate(@Valid @RequestBody RequestEvent eventDTO, @PathVariable int pageNumber) {
        return ResponseEntity.ok(this.eventService.getEventsByDate(eventDTO, pageNumber));
    }


}
