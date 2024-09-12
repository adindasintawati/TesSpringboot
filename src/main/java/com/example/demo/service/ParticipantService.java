package com.example.demo.service;

import com.example.demo.model.Event;
import com.example.demo.model.Participant;
import com.example.demo.repository.ParticipantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {

    private final ParticipantRepository participantRepository;

    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    //GET ALL DATA PARTICIPANT
    public List<Participant> findAll() {
        return participantRepository.findAll();
    }

    public Optional<Participant> getParticipantById(Integer id) {
        return participantRepository.findById(id);
    }

    //POST
    public Participant create(Participant participant) {
        return participantRepository.save(participant);
    }

    //DELETE
    public void delete(Integer id) {
        participantRepository.delete(
                participantRepository
                        .findById(id)
                        .orElseThrow(() -> new ParticipantNotFoundException(id)));
    }
}
