package com.college.eventportal.dto;

import java.time.LocalDate;

public class EventRequest {

    private String title;
    private String description;
    private LocalDate eventDate;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }
}
