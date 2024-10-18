package com.placementcellCodes.CollegePlacementcell.service;

import com.placementcellCodes.CollegePlacementcell.model.Student;
import com.placementcellCodes.CollegePlacementcell.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Indicates that this class is a Spring service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired // Spring will automatically inject the StudentRepository bean
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Method to fetch all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll(); // Calls the repository method to get all students
    }

    // Method to fetch a student by ID
    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(id); // Calls the repository method to find a student by ID
    }

    // Method to fetch a student by email
    public Optional<Student> getStudentByEmail(String email) {
        return Optional.ofNullable(studentRepository.findByEmail(email)); // Calls the custom query method
    }

    // Method to add a new student
    public Student addStudent(Student student) {
        return studentRepository.save(student); // Calls the repository method to save the student
    }

    // Method to update an existing student
    public Student updateStudent(String id, Student student) {
        // Check if the student exists
        if (studentRepository.existsById(id)) {
            student.setId(id); // Set the ID to the existing student
            return studentRepository.save(student); // Update the student
        }
        return null; // Return null if the student does not exist
    }

    // Method to delete a student by ID
    public void deleteStudent(String id) {
        studentRepository.deleteById(id); // Calls the repository method to delete a student by ID
    }

    // Additional methods can be added as needed
}

