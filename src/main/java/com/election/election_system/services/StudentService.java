package com.election.election_system.services;

import com.election.election_system.model.Student;
import com.election.election_system.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getByRegNo(String regNo) {
        return studentRepository.findByRegistrationNumber(regNo)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }
}