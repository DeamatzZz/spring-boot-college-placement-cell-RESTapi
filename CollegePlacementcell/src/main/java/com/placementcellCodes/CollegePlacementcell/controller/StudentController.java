package com.placementcellCodes.CollegePlacementcell.controller;


import com.placementcellCodes.CollegePlacementcell.model.Student;
import com.placementcellCodes.CollegePlacementcell.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Indicates that this class is a REST controller
@RequestMapping("/api/students") // Base URL for student operations
public class StudentController {

    private final StudentService studentService;

    @Autowired // Inject the StudentService
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping // Endpoint to get all students
    public List<Student> getAllStudents() {
        return studentService.getAllStudents(); // Calls the service method
    }

    @GetMapping("/{id}") // Endpoint to get a student by ID
    public ResponseEntity<Student> getStudentById(@PathVariable String id) {
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping // Endpoint to add a new student
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student); // Calls the service method
    }

    @PutMapping("/{id}") // Endpoint to update an existing student
    public ResponseEntity<Student> updateStudent(@PathVariable String id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        return updatedStudent != null ? ResponseEntity.ok(updatedStudent) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}") // Endpoint to delete a student by ID
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build(); // Returns 204 No Content
    }

    // Additional endpoints can be added as needed
}
