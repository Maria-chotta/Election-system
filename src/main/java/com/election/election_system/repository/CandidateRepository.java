package com.election.election_system.repository;

import com.election.election_system.model.Candidate;
import com.election.election_system.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    List<Candidate> findByPosition(Position position);
}