package com.college.eventportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.college.eventportal.dto.EventRequest;
import com.college.eventportal.entity.Event;
import com.college.eventportal.service.EventService;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired EventService service;

    @PostMapping
    public Event create(@RequestBody EventRequest r) {
        return service.create(r);
    }

    @GetMapping
    public List<Event> all() {
        return service.all();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
