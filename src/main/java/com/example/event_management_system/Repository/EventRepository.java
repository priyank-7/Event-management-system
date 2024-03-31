package com.example.event_management_system.Repository;

import com.example.event_management_system.DTOs.ResponseEvent;
import com.example.event_management_system.Entities.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, String> {

    @Query(value = "SELECT e FROM Event e where e.date >= :startDate and e.date < :endDate")
    Page<Event> findByDateAfter (@Param("startDate") Date startDate, @Param("endDate") Date endDate, Pageable pageable);
}
