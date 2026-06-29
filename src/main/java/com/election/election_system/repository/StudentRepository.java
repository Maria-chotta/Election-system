package com.election.election_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.election.election_system.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByRegistrationNumber(String registrationNumber);
}