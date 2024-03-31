package com.example.event_management_system.Service.Impl;

import com.example.event_management_system.Client.RestClient;
import com.example.event_management_system.DTOs.EventDTO;
import com.example.event_management_system.DTOs.RequestEvent;
import com.example.event_management_system.DTOs.ResponseEvent;
import com.example.event_management_system.Entities.Event;
import com.example.event_management_system.Exception.ResourceNotFoundException;
import com.example.event_management_system.Helper.DateHelper;
import com.example.event_management_system.Helper.EventMapper;
import com.example.event_management_system.Helper.PageManagement;
import com.example.event_management_system.Repository.EventRepository;
import com.example.event_management_system.Service.EventService;
import com.github.f4b6a3.ulid.UlidCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    private final RestClient restClient = new RestClient(restTemplate);

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    @Override
    public EventDTO createEvent(EventDTO eventDTO) {
        eventDTO.setEvent_id(UlidCreator.getUlid().toString());
        return EventMapper.EventToEventDTO(this.eventRepository.save(EventMapper.EventDTOToEvent(eventDTO)));
    }

    @Override
    public Page<ResponseEvent> getEventsByDate(RequestEvent requestEvent, int pageNumber) {

        Pageable pageable = PageRequest.of(pageNumber, PageManagement.PAGE_SIZE, Sort.by("date").ascending());
        // Page<Event> responseEvent = new ArrayList<>();
        System.out.println(requestEvent.getDate());
        System.out.println(DateHelper.getFutureDate(requestEvent.getDate()));
        Page<Event> pages = this.eventRepository.findByDateAfter(requestEvent.getDate(), DateHelper.getFutureDate(requestEvent.getDate()), pageable);
        return pages.map(event -> restClient.processEvent(event, requestEvent));
//                .orElseThrow(() -> new ResourceNotFoundException("No events found"))
//                .forEach(event -> )
//
//                .stream()
//                .map(EventMapper::EventToEventDTO)
//                .map(eventDTO -> EventMapper.EventDTOToResponseEvent(restClient.processEvent(eventDTO, requestEvent)))
//                .collect(Collectors.toList());
    }
}
