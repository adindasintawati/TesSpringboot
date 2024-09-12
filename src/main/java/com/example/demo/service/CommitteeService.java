package com.example.demo.service;

import com.example.demo.model.Committee;
import com.example.demo.model.Event;
import com.example.demo.repository.CommitteeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommitteeService {

    private final CommitteeRepository committeeRepository;

    public CommitteeService(CommitteeRepository committeeRepository) {
        this.committeeRepository = committeeRepository;
    }

    //GET ALL DATA COMMITTEE
    public List<Committee> findAll() {
        return committeeRepository.findAll();
    }

    //POST
    public Committee create(Committee committee) {
        return committeeRepository.save(committee);
    }

    //DELETE
    public void delete(Integer id) {
        committeeRepository.delete(
                committeeRepository
                        .findById(id)
                        .orElseThrow(() -> new CommitteeNotFoundException(id)));
    }

    //PUT
    public void update(Integer id, Committee committee) {
        if (!committeeRepository.existsById(id)) {
            throw new EventNotFoundException(id);
        }
        Committee updateCommittee = new Committee(
                id,
                committee.getName()
        );
        committeeRepository.save(updateCommittee);
    }
}
