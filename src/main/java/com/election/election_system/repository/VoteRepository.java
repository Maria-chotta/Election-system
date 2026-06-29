package com.election.election_system.repository;

import com.election.election_system.model.Vote;
import com.election.election_system.model.Student;
import com.election.election_system.model.Position;
import com.election.election_system.model.Candidate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    Optional<Vote> findByStudentAndPosition(Student student, Position position);

    List<Vote> findByPosition(Position position);

    List<Vote> findByCandidate(Candidate candidate);

    @Query("SELECT v.candidate.id, COUNT(v) FROM Vote v GROUP BY v.candidate.id")
    List<Object[]> countVotesPerCandidate();
}