package com.election.election_system.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String manifesto;

    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    public Candidate() {}

    public Candidate(Long id, String fullName,
                     String manifesto, String imageUrl,
                     Position position) {
        this.id = id;
        this.fullName = fullName;
        this.manifesto = manifesto;
        this.imageUrl = imageUrl;
        this.position = position;
    }

    public Position getPosition() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPosition'");
    }

    public static Candidate saveCandidate(Candidate candidate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveCandidate'");
    }

    public static List<Candidate> getAllCandidates() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllCandidates'");
    }

    // Getters and Setters
}
