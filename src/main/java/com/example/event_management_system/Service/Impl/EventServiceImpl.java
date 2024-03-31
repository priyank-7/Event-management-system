package com.example.event_management_system.Service.Impl;

import com.example.event_management_system.Client.RestClient;
import com.example.event_management_system.DTOs.EventDTO;
import com.example.event_management_system.DTOs.RequestEvent;
import com.example.event_management_system.DTOs.ResponseEvent;
import com.example.event_management_system.Helper.DateHelper;
import com.example.event_management_system.Helper.EventMapper;
import com.example.event_management_system.Repository.EventRepository;
import com.example.event_management_system.Service.EventService;
import com.github.f4b6a3.ulid.UlidCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

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
    public List<ResponseEvent> getEventsByDate(RequestEvent requestEvent) {
        List<ResponseEvent> responseEvent = new ArrayList<>();
        Optional.ofNullable(this.eventRepository.findByDateBetween(requestEvent.getDate(), DateHelper.getFutureDate()))
                .orElse(Collections.emptyList())
                .forEach(event -> {
                    responseEvent.add(restClient.processEvent(event, requestEvent, EventMapper.EventToResponseEvent(event)));
                });
        return responseEvent;
    }
}
