package com.election.election_system.services;

import com.election.election_system.model.Candidate;
import com.election.election_system.model.Position;
import com.election.election_system.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public Candidate saveCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public List<Candidate> getByPosition(Position position) {
        return candidateRepository.findByPosition(position);
    }
}