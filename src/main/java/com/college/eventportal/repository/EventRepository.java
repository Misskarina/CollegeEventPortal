package com.college.eventportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.eventportal.entity.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
}
