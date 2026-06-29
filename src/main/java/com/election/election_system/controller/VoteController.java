package com.election.election_system.controller;

import com.election.election_system.model.Vote;
import com.election.election_system.services.VoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/votes")
@CrossOrigin("*")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @PostMapping
    public Vote castVote(@RequestParam Long studentId,
                         @RequestParam Long candidateId,
                         @RequestParam Long positionId) {
        return voteService.castVote(studentId, candidateId, positionId);
    }

    @GetMapping("/results")
    public List<Object[]> getResults() {
        return voteService.getResults();
    }
}