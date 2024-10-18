package com.placementcellCodes.CollegePlacementcell.repository;



import com.placementcellCodes.CollegePlacementcell.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
    // You can define custom query methods here if needed

    // Example: Find a student by email
    Student findByEmail(String email);
}
