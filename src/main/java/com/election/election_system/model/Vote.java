package com.election.election_system.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "votes",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = {"student_id", "position_id"})
       }
)
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Who voted
    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    // What position they voted for (President, Vice etc.)
    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;

    // Who they voted for
    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable = false)
    private Candidate candidate;

    private LocalDateTime voteTime;

    public Vote() {
        this.voteTime = LocalDateTime.now();
    }

    public Vote(Student student, Position position, Candidate candidate) {
        this.student = student;
        this.position = position;
        this.candidate = candidate;
        this.voteTime = LocalDateTime.now();
    }

    
}
