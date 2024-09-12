package com.example.demo.service;

import com.example.demo.model.Event;
import com.example.demo.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Optional<Event> getEventById(Integer id) {
        return eventRepository.findById(id);
    }


    //GET ALL DATA EVENTS
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    //POST
    public Event create(Event event) {
        return eventRepository.save(event);
    }

    //DELETE
    public void delete(Integer id) {
        eventRepository.delete(
                eventRepository
                        .findById(id)
                        .orElseThrow(() -> new EventNotFoundException(id)));
    }

    //PUT
    public void update(Integer id, Event event) {
        if (!eventRepository.existsById(id)) {
            throw new EventNotFoundException(id);
        }
        Event existingEvent = eventRepository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));
        Event updateEvent = new Event(
                event.getId(),
                event.getTitle(),
                event.getStartOn(),
                event.getCompleteOn(),
                event.getParticipant(),
                event.getLocation(),
                existingEvent.getVersion()
        );
        eventRepository.save(updateEvent);
    }
}
