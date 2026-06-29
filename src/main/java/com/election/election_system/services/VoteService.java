package com.election.election_system.services;

import com.election.election_system.model.*;
import com.election.election_system.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PositionRepository positionRepository;

    // 🔥 CAST VOTE
    public Vote castVote(Long studentId, Long candidateId, Long positionId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        Position position = positionRepository.findById(positionId)
                .orElseThrow(() -> new RuntimeException("Position not found"));

        // ❌ Rule: one vote per position
        if (voteRepository.findByStudentAndPosition(student, position).isPresent()) {
            throw new RuntimeException("You already voted for this position");
        }

        // ❌ Rule: ensure candidate matches position
        if (!candidate.getPosition().getId().equals(position.getId())) {
            throw new RuntimeException("Invalid candidate for this position");
        }

        Vote vote = new Vote(student, position, candidate);

        return voteRepository.save(vote);
    }

    // 📊 RESULTS
    public List<Object[]> getResults() {
        return voteRepository.countVotesPerCandidate();
    }
}