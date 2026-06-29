package com.election.election_system.controller;

import com.election.election_system.model.Candidate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin("*")
public class CandidateController<candidateService> {

    @PostMapping
    public Candidate addCandidate(@RequestBody Candidate candidate) {
        return Candidate.saveCandidate(candidate);
    }

    @GetMapping
    public List<Candidate> getAll() {
        return Candidate.getAllCandidates();
    }
}