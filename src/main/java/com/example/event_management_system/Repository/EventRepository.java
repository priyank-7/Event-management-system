package com.example.event_management_system.Repository;

import com.example.event_management_system.Entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, String> {

    List<Event> findByDateBetween(Date startDate, Date endDate);

}
