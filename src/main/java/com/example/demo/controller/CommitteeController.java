package com.example.demo.controller;

import com.example.demo.model.Committee;
import com.example.demo.model.Event;
import com.example.demo.model.Participant;
import com.example.demo.service.CommitteeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/committees")
public class CommitteeController {

    private final CommitteeService committeeService;

    public CommitteeController(CommitteeService committeeService) {
        this.committeeService = committeeService;
    }

    //GET ALL DATA COMMITTEE
    @GetMapping("")
    public List<Committee> findAll() {
        return committeeService.findAll();
    }

    //CREATE
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Committee create(@Valid @RequestBody Committee committee) {
        return committeeService.create(committee);
    }

    //DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        committeeService.delete(id);
    }

    //PUT
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Committee committee,
                       @PathVariable Integer id) {
        committeeService.update(id, committee);
    }
}
