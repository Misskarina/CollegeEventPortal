package com.college.eventportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.college.eventportal.dto.EventRequest;
import com.college.eventportal.entity.Event;
import com.college.eventportal.entity.User;
import com.college.eventportal.repository.EventRepository;
import com.college.eventportal.repository.UserRepository;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepo;

    @Autowired
    private UserRepository userRepo;

    public Event create(EventRequest r) {
        String email = SecurityContextHolder.getContext()
                .getAuthentication()
                .getName();

        User u = userRepo.findByEmail(email).orElseThrow();

        Event e = new Event();
        e.setTitle(r.getTitle());
        e.setDescription(r.getDescription());
        e.setEventDate(r.getEventDate());
        e.setCreatedBy(u);

        return eventRepo.save(e);
    }

    public List<Event> all() {
        return eventRepo.findAll();
    }

    public void delete(Long id) {
        eventRepo.deleteById(id);
    }
}
