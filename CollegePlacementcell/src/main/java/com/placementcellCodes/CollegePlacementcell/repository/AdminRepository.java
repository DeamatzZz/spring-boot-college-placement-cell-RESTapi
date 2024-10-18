package com.placementcellCodes.CollegePlacementcell.repository;



import  com.placementcellCodes.CollegePlacementcell.model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<Admin, String> {
    // Example: Find an admin by username
    Admin findByUsername(String username);
}

