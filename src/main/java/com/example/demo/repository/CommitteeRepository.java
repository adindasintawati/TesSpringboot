package com.example.demo.repository;

import com.example.demo.model.Committee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommitteeRepository extends JpaRepository<Committee, Integer> {
}
