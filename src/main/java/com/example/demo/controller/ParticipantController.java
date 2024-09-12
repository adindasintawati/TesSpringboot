package com.example.demo.controller;

import com.example.demo.model.Event;
import com.example.demo.model.Participant;
import com.example.demo.service.EventService;
import com.example.demo.service.ParticipantService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {

    private final ParticipantService participantService;

    private final EventService eventService;

    public ParticipantController(ParticipantService participantService, EventService eventService) {
        this.participantService = participantService;
        this.eventService = eventService;
    }

    //GET ALL DATA PARTICIPANTS
    @GetMapping("")
    public List<Participant> findAll() {
        return participantService.findAll();
    }

    //CREATE
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Participant create(@Valid @RequestBody Participant participant) {
        return participantService.create(participant);
    }

    //DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        participantService.delete(id);
    }

    //PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> updateParticipant(@PathVariable Integer id, @RequestBody Participant participantDetails) {
        Optional<Participant> participant = participantService.getParticipantById(id);

        if (participant.isPresent()) {
            Participant existingParticipant = participant.get();

            existingParticipant.setName(participantDetails.getName());
            existingParticipant.setEmail(participantDetails.getEmail());

            if (participantDetails.getEvent() != null) {
                Integer eventId = participantDetails.getEvent().getId();
                Optional<Event> event = eventService.getEventById(eventId);

                if (event.isPresent()) {
                    existingParticipant.setEvent(event.get());

                    Participant updatedParticipant = participantService.create(existingParticipant);

                    return ResponseEntity.ok(updatedParticipant);
                } else {
                    Map<String, String> response = new HashMap<>();
                    response.put("status", "404");
                    response.put("message", "Event not found");
                    return ResponseEntity.status(404).body(response);
                }
            } else {
                Map<String, String> response = new HashMap<>();
                response.put("status", "400");
                response.put("message", "Event is required");
                return ResponseEntity.status(400).body(response);
            }

        } else {
            Map<String, String> response = new HashMap<>();
            response.put("status", "404");
            response.put("message", "Participant not found");
            return ResponseEntity.status(404).body(response);
        }
    }
}
