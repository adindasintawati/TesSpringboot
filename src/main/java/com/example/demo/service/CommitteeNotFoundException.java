package com.example.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CommitteeNotFoundException extends RuntimeException {
    public CommitteeNotFoundException(Integer id) { super("Event not found");
    }
}
