package com.election.election_system.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String registrationNumber;

    private String fullName;

    private String email;

    private String password;

    private String academicLevel; // DIPLOMA or DEGREE

    private boolean hasVoted;

    public Student() {}

    public Student(Long id, String registrationNumber, String fullName,
                   String email, String password,
                   String academicLevel, boolean hasVoted) {
        this.id = id;
        this.registrationNumber = registrationNumber;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.academicLevel = academicLevel;
        this.hasVoted = hasVoted;
    }

    // Getters and Setters
}