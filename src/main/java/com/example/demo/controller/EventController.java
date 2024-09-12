package com.example.demo.controller;

import com.example.demo.model.Event;
import com.example.demo.service.EventService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.persistence.*;

import java.util.List;


@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    // GET ALL DATA EVENTS
    @GetMapping("")
    public List<Event> findAll() {
        return eventService.findAll();
    }

    //CREATE
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Event create(@Valid @RequestBody Event event) {
        return eventService.create(event);
    }

    //DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        eventService.delete(id);
    }

    //PUT
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Event event,
                       @PathVariable Integer id) {
        eventService.update(id, event);
    }
}

